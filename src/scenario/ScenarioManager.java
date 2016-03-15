package scenario;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import battle.BattleSetup;
import battle.SkillRankType;
import battle.dynamic.DynamicCompleteDamage;
import battle.dynamic.DynamicDamageVSEnemy;
import battle.dynamic.DynamicResistModifier;
import calc.DefenseCalculator;

import java.util.TreeMap;

import org.json.simple.parser.ParseException;

import com.rits.cloning.Cloner;

import items.Item;
import items.ItemObjects;
import items.ItemRemovalWrapper;

/** 
 * Aggregates multiple scenarios into a single list.
 * @author byronb92
 *
 */
public class ScenarioManager {
	private ArrayList<UrgotScenario> listAllScenarios;
	private String scenarioManagerName;
	
	public ScenarioManager()
	{
		listAllScenarios = new ArrayList<UrgotScenario>();
	}
	
	public void addAllScenarios(ArrayList<UrgotScenario> smallList)
	{
		listAllScenarios.addAll(smallList);
	}

	
	public void battleCollection(BattleSetup battleSetup, SkillRankType rankType)
	{
		for (UrgotScenario sce : getScenarios())
		{
			sce.computeBattleScenario(battleSetup, rankType);
		}
	}
	
	/**
	 * Looks through complete item lists and finds the item that will optimize damage output.
	 * ASSUMPTION: Scenario passed in has already has stats computed.
	 * @param sce
	 * @param itemCategory
	 * @return
	 * @throws CloneNotSupportedException
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws ParseException
	 * @throws IOException
	 */
	public UrgotScenario bestDamageItemToAdd(UrgotScenario sce, String itemCategory) throws CloneNotSupportedException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException, IOException
	{
		ItemObjects itemObjects = new ItemObjects();
		itemObjects.constructAllItems();
		// Scan through current scenario and remove any items the scenario already has.
		ItemRemovalWrapper removeItem = new ItemRemovalWrapper();
		for(Entry<String,Item> itemA: sce.getUrgotItems().getItems().entrySet())
		{
			removeItem.removeItemAfterBeingUsed(itemA.getKey(), itemObjects);
		}
		
		UrgotScenario highestDamageScenario = sce;
		Cloner cloner = new Cloner();
		
		for(Entry<String,Item> item: itemObjects.getItemObjects().entrySet())
		{
			UrgotScenario duplicateSce = cloner.deepClone(sce);
			UrgotScenario originalScenario = cloner.deepClone(sce);
			duplicateSce.addItem(item.getValue());
			duplicateSce.setScenarioName(item.getKey());

			
			originalScenario.computeStats();
			duplicateSce.computeStats();
			originalScenario.computeBattleScenario(BattleSetup.ALLIN_NOULT, SkillRankType.STANDARD);
			duplicateSce.computeBattleScenario(BattleSetup.ALLIN_NOULT, SkillRankType.STANDARD);
			highestDamageScenario = findHighestRawDamage(highestDamageScenario, duplicateSce);
			
		}
		return highestDamageScenario;
	}

	private DynamicCompleteDamage collectPreDamageStatsFromScenario(UrgotScenario sce, 
			double enemyBaseArmor, double enemyBonusArmor, 
			double enemyBaseMR, double enemyBonusMR)
	{
		double rawPhysicalDamage = sce.getBattleStats().getPhysicalDamage();
		double rawMagicDamage = sce.getBattleStats().getMagicDamage();
		
		DynamicDamageVSEnemy urgVsEnemy = new DynamicDamageVSEnemy();
		return urgVsEnemy.damageVsEnemy(resistModFromScenario(sce, urgVsEnemy),
				rawPhysicalDamage, rawMagicDamage, 
				enemyBaseArmor, enemyBonusArmor, enemyBaseMR, enemyBonusMR);			
	}
	
	
	public void computeStatsAndBattleScenario(BattleSetup battleSetup, SkillRankType rankType)
	{
		for (UrgotScenario sce : getScenarios())
		{
			sce.computeStatsAndBattleScenario(battleSetup, rankType);
		}
	}
	

	public DynamicCompleteDamage damageVsEnemy(UrgotScenario sce, 
			double enemyBaseArmor, double enemyBonusArmor,
			double enemyBaseMR, double enemyBonusMR)
	{
		return collectPreDamageStatsFromScenario(sce, 
				enemyBaseArmor, enemyBonusArmor, enemyBaseMR, enemyBonusMR);
	}


	public UrgotScenario damageVsHPDifferenceArmor()
	{
		UrgotScenario bestBalancedScenario = null;
		for (UrgotScenario currentScenario : getScenarios())
		{
			if (bestBalancedScenario == null)
			{
				bestBalancedScenario = currentScenario;
			}
			else
			{
				bestBalancedScenario = damageVsHPDifferenceArmor(bestBalancedScenario, currentScenario);
			}
		}
		return bestBalancedScenario;

		
	}
	

	public UrgotScenario damageVsHPDifferenceArmor(UrgotScenario sceA, UrgotScenario sceB)
	{
		
		UrgotScenario moreDamage = findHighestRawDamage(sceA,sceB);
		UrgotScenario tankier;
		if (sceA.getUrgotStats().getTotalArmor() > sceB.getUrgotStats().getTotalArmor())
		{
			tankier = sceA;
			if (moreDamage == sceA)
			{
				return sceA;
			}
		}
		else if (sceA.getUrgotStats().getTotalArmor() < sceB.getUrgotStats().getTotalArmor());
		{
			tankier = sceB;
			if (moreDamage == sceB)
			{
				return sceB;
			}
		}
		if (damageVsHPHelper(moreDamage,tankier) >= 0)
		{
			return tankier;
		}
		return moreDamage;
		
	}
	
	
	private double damageVsHPHelper(UrgotScenario moreDamage, UrgotScenario tankier)
	{
		double damageDifference = moreDamage.getBattleStats().getTotalDamage() -
				tankier.getBattleStats().getTotalDamage();
		double trueHPDifference = DefenseCalculator.findHealthVsPhysical(tankier) - 
				DefenseCalculator.findHealthVsPhysical(moreDamage);
		System.out.println ("Damage difference: " + (damageDifference - trueHPDifference));
		return damageDifference - trueHPDifference;
		
	}
	
	/**
	 * Finds the highest damage output scenario in all scenarios.
	 * @return null - there are no scenarios.
	 */
	public UrgotScenario findHighestRawDamage()
	{
		UrgotScenario highestDamageSce = null;
		for (UrgotScenario sce : listAllScenarios)
		{
			if (highestDamageSce == null)
			{
				highestDamageSce = sce;
			}
			else
			{
				double rawDamageA = sce.getBattleStats().getTotalDamage();
				double rawDamageB = highestDamageSce.getBattleStats().getTotalDamage();
				if (rawDamageA > rawDamageB)
				{
					highestDamageSce = sce;
				}
				else if (rawDamageA == rawDamageB)
				{
					System.out.println("-----------------");
					System.out.println("Duplicate raw damage: " + rawDamageA);
					System.out.println("Set 1: " + highestDamageSce.getScenarioName());
					System.out.println("Set 2: " + sce.getScenarioName());
				}
			}
		}
		return highestDamageSce;
	}
	
	public UrgotScenario findHighestRawDamage(UrgotScenario sceA, UrgotScenario sceB)
	{
		double rawDamageA = sceA.getBattleStats().getTotalDamage();
		double rawDamageB = sceB.getBattleStats().getTotalDamage();
		if (rawDamageA > rawDamageB)
		{
			return sceA;
		}
		else if (rawDamageA == rawDamageB)
		{
			System.out.println("-----------------");
			System.out.println("Duplicate raw damage: " + rawDamageA);
			System.out.println("Set 1 Scenario Name: " + sceA.getScenarioName());
			System.out.println("Set 2 Scenario Name: " + sceB.getScenarioName());
			System.out.println();
			return sceA;
		}

		return sceB;
	}
	
	/**
	 * Finds the highest damage output scenario in all scenarios.
	 * @return null - there are no scenarios.
	 */
	public UrgotScenario findHighestRealDamage(double enemyBaseArmor,
			double enemyBonusArmor, double enemyBaseMR, double enemyBonusMR)
	{
		UrgotScenario highestDamageSce = null;
		for (UrgotScenario sce : listAllScenarios)
		{
			if (highestDamageSce == null)
			{
				highestDamageSce = sce;
			}
			else
			{
				DynamicCompleteDamage dmgA = damageVsEnemy(sce, 
						enemyBaseArmor, enemyBonusArmor, enemyBaseMR, enemyBonusMR);
				DynamicCompleteDamage dmgB = damageVsEnemy(highestDamageSce, 
						enemyBaseArmor, enemyBonusArmor, enemyBaseMR, enemyBonusMR);
				if (dmgA.getTotalDamage() > dmgB.getTotalDamage())
				{
					highestDamageSce = sce;
				}
				else if (dmgA == dmgB)
				{
					System.out.println("-----------------");
					System.out.println("Duplicate raw damage: " + dmgA.getTotalDamage());
					System.out.println("Set 1: " + highestDamageSce.getScenarioName());
					System.out.println("Set 2: " + sce.getScenarioName());
				}
			}
		}
		return highestDamageSce;
	}
	
	/**
	 * Finds out which scenario does the most damage to a specific target.
	 * @param sceA
	 * @param sceB
	 * @param enemyArmor
	 * @param enemyMR
	 * @return null if the damage is equal.
	 */
	public DynamicCompleteDamage findHighestRealDamageFromTwoScenarios(
			UrgotScenario sceA, UrgotScenario sceB,
			double enemyBaseArmor, double enemyBonusArmor, 
			double enemyBaseMR, double enemyBonusMR)
	{
		DynamicCompleteDamage dmgA = damageVsEnemy(sceA, 
				enemyBaseArmor, enemyBonusArmor, 
				enemyBaseMR, enemyBonusMR);
		DynamicCompleteDamage dmgB = damageVsEnemy(sceB, 
				enemyBaseArmor, enemyBonusArmor, enemyBaseMR, enemyBonusMR);
		if (dmgA.getTotalDamage() > dmgB.getTotalDamage())
		{
			return dmgA;
		}
		else if (dmgA.getTotalDamage() < dmgB.getTotalDamage())
		{
			return dmgB;
		}
		return null;
	}
	/**
	 * Finds the highest damage output scenario in all scenarios.
	 * @return null - there are no scenarios.
	 */
	public UrgotScenario findLowestCost()
	{
		UrgotScenario lowestCost = null;
		int numbLowestCost = 0;
		for (UrgotScenario sce : listAllScenarios)
		{
			if (lowestCost == null)
			{
				lowestCost = sce;
				numbLowestCost = getScenarioCost(lowestCost);
			}
			else
			{
				int costA = getScenarioCost(sce);
				if (costA < numbLowestCost)
				{
					lowestCost = sce;
					numbLowestCost = costA;
				}
				else if (costA == numbLowestCost)
				{
					System.out.println("-----------------");
					System.out.println("Duplicate item set cost: " + numbLowestCost);
					System.out.println("Set 1: " + getScenarioItems(lowestCost));
					System.out.println("Set 2: " + getScenarioItems(sce));
				}
			}
		}
		return lowestCost;
	}
	
	/**
	 * Finds out which scenario does the most damage to a specific target.
	 * @param sceA
	 * @param sceB
	 * @param enemyArmor
	 * @param enemyMR
	 * @return null if the damage is equal.
	 */
	public DynamicCompleteDamage findRealDamage(
			UrgotScenario sceA,
			double enemyBaseArmor, double enemyBonusArmor, 
			double enemyBaseMR, double enemyBonusMR)
	{
		
		DynamicCompleteDamage dmgA = damageVsEnemy(sceA, 
				enemyBaseArmor, enemyBonusArmor, 
				enemyBaseMR, enemyBonusMR);
		return dmgA;
	}
	
	public String getAllScenarioItems()
	{
		StringBuilder builder = new StringBuilder();
		for (UrgotScenario currentScenario : getScenarios())
		{
			// TODO: If there is no name the default returns item list.
			// There will be duplicates here if the scenario doesn't have a name but has items...
			builder.append("Scenario Name: " + currentScenario.getScenarioName() + "\n");
			if (currentScenario.getUrgotItems().getItems().size() > 0)
			{
				builder.append("Items: ");
				for(Entry<String,Item> item: currentScenario.getUrgotItems().getItems().entrySet())
				{
					builder.append(item.getValue().getName() + " ");
				}
				builder.append("\n");
			}
			builder.append("\n");
		}
		return builder.toString();
	}
	

	
	public String getDefensiveStats(UrgotScenario sce)
	{
		StringBuilder defense = new StringBuilder();
		defense.append("HP: " + sce.getUrgotStats().getTotalHP() +  "\n");
		defense.append("True Physical HP: " + DefenseCalculator.findHealthVsPhysical(sce) +  "\n");
		defense.append("True Magic HP: " + DefenseCalculator.findHealthVsMagic(sce) +  "\n");
		defense.append("Armor: " + sce.getUrgotStats().getTotalArmor() +  "\n");
		defense.append("MR: " + sce.getUrgotStats().getTotalMR() +  "\n");
		return defense.toString();
	}
	
	public String getOffensiveStats(UrgotScenario sce)
	{
		StringBuilder offense = new StringBuilder();
		offense.append("AD: " + sce.getUrgotStats().getTotalAD() +  "\n");
		offense.append("Base AD: " + sce.getUrgotStats().getBaseADFromLevel() + "\n");
		offense.append("Bonus AD: " + sce.getUrgotStats().getBonusAD() + "\n");
		offense.append("Mana: " + sce.getUrgotStats().getTotalMana() +  "\n");
		offense.append("Flat Armor Pen: " + sce.getUrgotStats().getFlatArmorPen() + "\n");
		offense.append("Armor Reduction: " + sce.getUrgotStats().getPercentArmorReduc() + "\n");
		offense.append("Percent Armor Pen: " + sce.getUrgotStats().getPercentArmorPen() + "\n");
		offense.append("Bonus Armor Percent Pen: " + sce.getUrgotStats().getBonusPercentArmorPen() + "\n");
		offense.append("AS: " + sce.getUrgotStats().getTotalAS() + "\n");
		return offense.toString();
	}
	
	/**
	 * Accessor method to obtain Scenario's raw damage.
	 * NOTE: Currently only accounts for physical damage.
	 * @param sce
	 * @return
	 */
	public double getRawDamage(UrgotScenario sce)
	{
		return sce.getBattleStats().getTotalDamage();
	}

	// TODO: getTrueEnemyMR();
//	private double getTrueEnemyMRFromScenario(UrgotScenario sce,
//			double enemyBaseMR, double enemyTotalMR)
//	{
//		return 0;
//	}
	
	public int getScenarioCost(UrgotScenario sce)
	{
		int runningCost = 0;
		for(Entry<String,Item> item: sce.getUrgotItems().getItems().entrySet())
		{
			runningCost = runningCost + item.getValue().getCost();
		}
		return runningCost;
	}
	
	public String getScenarioItems(UrgotScenario sce)
	{

		if (sce.getUrgotItems().getItems().size() > 0)
		{
			StringBuilder builder = new StringBuilder();
			builder.append("Items: ");
			for(Entry<String,Item> item: sce.getUrgotItems().getItems().entrySet())
			{
				builder.append(item.getValue().getName() + " ");
			}
			return builder.toString();
		}
		return null;
	}
	public String getScenarioManagerName()
	{
		return scenarioManagerName;
	}
	
	public ArrayList<UrgotScenario> getScenarios()
	{
		return listAllScenarios;
	}
	
	
	public String getSustainStats(UrgotScenario sce)
	{
		StringBuilder sustain = new StringBuilder();
		sustain.append("Healing Done: " + sce.getBattleStats().getHealingDone() + "\n");
		sustain.append("Life Steal: " + sce.getUrgotStats().getLifeSteal() + "\n");
		sustain.append("Spell Vamp: " + sce.getUrgotStats().getSpellVamp() + "\n");
		sustain.append("HP Regen: " + sce.getUrgotStats().getTotalHPRegen() + "\n");
		sustain.append("Mana Regen: " + (sce.getUrgotStats().getTotalManaRegen()) + "\n");
		return sustain.toString();	
	}
	
	public DynamicResistModifier resistModFromScenario(UrgotScenario sce,
			DynamicDamageVSEnemy urgotVsEnemy)
	{
		HashMap<String,Double> modMap = getArmorandMRModifiersAsMap(sce);
		return urgotVsEnemy.resistModifierWithMap(sce.getScenarioName(), modMap);
	}
	
	public HashMap<String,Double> getArmorandMRModifiersAsMap(UrgotScenario sce)
	{
		double armorReduc_Flat = sce.getUrgotStats().getFlatArmorReduc();
		double armorReduc_Percent = sce.getUrgotStats().getPercentArmorReduc();
		double armorPen_Percent = sce.getUrgotStats().getPercentArmorPen();
		double armorPen_BonusPercent = sce.getUrgotStats().getBonusPercentArmorPen();
		double armorPen_Flat = sce.getUrgotStats().getFlatArmorPen();
		
		// TODO: Add magic penetration stats to UrgotStats.
		double magicReduc_Flat = 0;
		double magicReduc_Percent = 0;
		double magicPen_Percent = 0;
		double magicPen_Flat = 0;
		
		HashMap<String,Double> mapMod = new HashMap<String,Double>();
		mapMod.put("Flat Armor Reduction", armorReduc_Flat);
		mapMod.put("Percent Armor Reduction", armorReduc_Percent);
		mapMod.put("Percent Armor Penetration", armorPen_Percent);
		mapMod.put("Percent Bonus Armor Penetration", armorPen_BonusPercent);
		mapMod.put("Flat Armor Penetration", armorPen_Flat);
		
		mapMod.put("Flat Magic Reduction", magicReduc_Flat);
		mapMod.put("Percent Magic Reduction", magicReduc_Percent);
		mapMod.put("Percent Magic Reduction", magicPen_Percent);
		mapMod.put("Flat Magic Penetration", magicPen_Flat);
		return mapMod;
	}
	

	
	public String getUtilityStats(UrgotScenario sce)
	{
		StringBuilder utility = new StringBuilder();
		utility.append("Movement Speed: " + sce.getUrgotStats().getTotalMS() + "\n");
		utility.append("CDR: " + sce.getUrgotStats().getCDR() + "\n");
		utility.append("Tenacity: " + sce.getUrgotStats().getTenacity() + "\n");
		utility.append("Slow Resist: " + sce.getUrgotStats().getSlowResist() + "\n");
		return utility.toString();
	}
	
	/**
	 * Takes care of duplicate cases inserted into maps, by making them differentiate slightly.
	 * @param map
	 * @param key
	 * @return
	 */
	private double makeKeyUnique(Map<?,?> map, Double key)
	{
		boolean isUnique = false;
		double currentValue = key;
		while (!isUnique)
		{
			if (map.containsKey(currentValue))
			{
				currentValue = currentValue + 0.0001;
			}
			else
			{
				isUnique = true;
			}
		}
		return currentValue;

	}
	
	public void setScenarioManagerName(String name)
	{
		scenarioManagerName = name;
	}
	
	
	public Map<Double,UrgotScenario> sortArmor(SortRank rank)
	{
		HashMap<Double,UrgotScenario> map = new HashMap<Double,UrgotScenario>();
		for (UrgotScenario sce : listAllScenarios)
		{
			double trueHp = DefenseCalculator.findHealthVsPhysical(sce);
			map.put(makeKeyUnique(map,trueHp), sce);
		}
		Map<Double,UrgotScenario> newMap = null;
		if (rank == SortRank.ASCENDING)
		{
			newMap = new TreeMap<Double, UrgotScenario>(map);
		}
		newMap = new TreeMap<Double, UrgotScenario>(Collections.reverseOrder());
		newMap.putAll(map);
		return newMap;
	}
	
	public Map<Double,UrgotScenario> sortDamage(SortRank rank)
	{
		HashMap<Double,UrgotScenario> map = new HashMap<Double,UrgotScenario>();
		for (UrgotScenario sce : listAllScenarios)
		{
			double rawDmg = sce.getBattleStats().getTotalDamage();
			map.put(makeKeyUnique(map,rawDmg), sce);
		}
		Map<Double,UrgotScenario> newMap = null;
		if (rank == SortRank.ASCENDING)
		{
			newMap = new TreeMap<Double, UrgotScenario>(map);
			return newMap;
		}
		newMap = new TreeMap<Double, UrgotScenario>(Collections.reverseOrder());
		newMap.putAll(map);
		return newMap;
	}
	
	public Map<Double,UrgotScenario> sortMagicResist(SortRank rank)
	{
		HashMap<Double,UrgotScenario> map = new HashMap<Double,UrgotScenario>();
		for (UrgotScenario sce : listAllScenarios)
		{
			double trueHp = DefenseCalculator.findHealthVsMagic(sce);
			map.put(makeKeyUnique(map,trueHp), sce);
		}
		Map<Double,UrgotScenario> newMap = null;
		if (rank == SortRank.ASCENDING)
		{
			newMap = new TreeMap<Double, UrgotScenario>(map);
		}
		newMap = new TreeMap<Double, UrgotScenario>(Collections.reverseOrder());
		newMap.putAll(map);
		return newMap;
	}
	
	public Map<Double,UrgotScenario> sortRealDamage(SortRank rank,
			double enemyBaseArmor, double enemyBonusArmor, 
			double enemyBaseMR, double enemyBonusMR)
	{
		HashMap<Double,UrgotScenario> map = new HashMap<Double,UrgotScenario>();
		for (UrgotScenario sce : listAllScenarios)
		{
			double realDmg = findRealDamage(sce, enemyBaseArmor, enemyBonusArmor,
					enemyBaseMR, enemyBonusMR).getTotalDamage();
			map.put(makeKeyUnique(map,realDmg), sce);
		}
		Map<Double,UrgotScenario> newMap = null;
		if (rank == SortRank.ASCENDING)
		{
			newMap = new TreeMap<Double, UrgotScenario>(map);
			return newMap;
		}
		newMap = new TreeMap<Double, UrgotScenario>(Collections.reverseOrder());
		newMap.putAll(map);
		return newMap;
	}
	
	
	
	
}
