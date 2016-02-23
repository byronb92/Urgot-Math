package scenario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import battle.dynamic.CompleteDamage;
import battle.dynamic.UrgotVsEnemy;
import calc.DefenseCalculator;

import java.util.TreeMap;

import items.Item;

/** 
 * ScenarioManager gives the ability to aggregate data 
 * about Urgot builds/stats/calculations.
 * @author byronb92
 *
 */
public class ScenarioManager {
	
	private EarlyGameScenarios early;
	private MidGameScenarios mid;
	private LateGameScenarios late;
	private ArrayList<UrgotScenario> listAllScenarios;
	
	
	public ScenarioManager()
	{
		listAllScenarios = new ArrayList<UrgotScenario>();
	}
	
	public void setUpStatCollection(StatSetup setupCode)
	{
		
		if (setupCode == StatSetup.LEVEL4 || setupCode == StatSetup.LEVEL6 || 
				setupCode == StatSetup.MASTERIES_LEVEL1 || setupCode == StatSetup.STARTING_ITEMS)
		{
			early = new EarlyGameScenarios();
			setUpPhase(early, setupCode);
		}
		else if (setupCode == StatSetup.LEVEL9 || setupCode == StatSetup.LEVEL12)
		{
			mid = new MidGameScenarios();
			setUpPhase(mid, setupCode);
		}
		else if (setupCode == StatSetup.LEVEL15 || setupCode == StatSetup.LEVEL18)
		{
			late = new LateGameScenarios();
			setUpPhase(late, setupCode);
		}
	}
	
	
	
	/**
	 * Preps output by grabbing the relevant item sets, based on phase and code passed in.
	 * @param phase, early, mid, late game setup.
	 * @param code - dependent on phase. Each Phase object has it's own outputs.
	 */
	private void setUpPhase(Phase phase, StatSetup setupCode)
	{
		phase.runStatCollection(setupCode);
		addAllScenarios(phase.getScenarios());
		
	}
	

	public ArrayList<UrgotScenario> getScenarios()
	{
		return listAllScenarios;
	}

	private void addAllScenarios(ArrayList<UrgotScenario> smallList)
	{
		listAllScenarios.addAll(smallList);
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
				// TODO: Add MR into equation.
				CompleteDamage dmgA = damageVsEnemy(sce, 
						enemyBaseArmor, enemyBonusArmor, enemyBaseMR, enemyBonusMR);
				CompleteDamage dmgB = damageVsEnemy(highestDamageSce, 
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
	public CompleteDamage findHighestRealDamageFromTwoScenarios(
			UrgotScenario sceA, UrgotScenario sceB,
			double enemyBaseArmor, double enemyBonusArmor, 
			double enemyBaseMR, double enemyBonusMR)
	{
		CompleteDamage dmgA = damageVsEnemy(sceA, 
				enemyBaseArmor, enemyBonusArmor, 
				enemyBaseMR, enemyBonusMR);
		CompleteDamage dmgB = damageVsEnemy(sceB, 
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
	
	public CompleteDamage damageVsEnemy(UrgotScenario sce, 
			double enemyBaseArmor, double enemyBonusArmor,
			double enemyBaseMR, double enemyBonusMR)
	{
		return collectPreDamageStatsFromScenario(sce, 
				enemyBaseArmor, enemyBonusArmor, enemyBaseMR, enemyBonusMR);
	}
	

	
	// TODO: Move into scenario manager.
	private CompleteDamage collectPreDamageStatsFromScenario(UrgotScenario sce, 
			double enemyBaseArmor, double enemyBonusArmor, 
			double enemyBaseMR, double enemyBonusMR)
	{
		String scenarioName = sce.getScenarioName();
		double rawPhysicalDamage = sce.getBattleStats().getPhysicalDamage();
		double rawMagicDamage = sce.getBattleStats().getMagicDamage();
		

		
		double enemyTrueArmor = getTrueEnemyArmorFromScenario(sce,
				enemyBaseArmor, enemyBonusArmor);
		double enemyTrueMR = getTrueEnemyMRFromScenario(sce,
				enemyBaseMR, enemyBonusMR); 
		UrgotVsEnemy urgVsEnemy = new UrgotVsEnemy();
		return urgVsEnemy.damageVsEnemy(scenarioName, rawPhysicalDamage, enemyTrueArmor,
				rawMagicDamage, enemyTrueMR);
				
	}
	
	private double getTrueEnemyArmorFromScenario(UrgotScenario sce,
			double enemyBaseArmor, double enemyBonusArmor)
	
	{
		double armorReduc_Flat = 0; // Urgot has no flat armor reduction.
		double armorReduc_Percent = sce.getUrgotStats().getArmorReduc();
		double armorPen_Percent = sce.getUrgotStats().getPercentArmorPen();
		double armorPen_Flat = sce.getUrgotStats().getFlatArmorPen();
		
		// Armor reduction is split between base and bonus armor.
		double trueEnemyBaseArmor = enemyBaseArmor - (armorReduc_Flat/2);
		double trueEnemyBonusArmor = enemyBonusArmor - (armorReduc_Flat/2);


		trueEnemyBaseArmor = trueEnemyBaseArmor * (armorReduc_Percent);
		trueEnemyBonusArmor = trueEnemyBonusArmor * armorReduc_Percent;

		trueEnemyBaseArmor = trueEnemyBaseArmor - (trueEnemyBaseArmor * armorPen_Percent);
		trueEnemyBonusArmor = trueEnemyBonusArmor - (trueEnemyBonusArmor * armorPen_Percent);
		// TODO: Add last whisper incorpration into Urgot Stats
		//trueEnemyBonusArmor = trueEnemyBonusArmor - (trueEnemyBonusArmor * armorPenBonus_Percent);


		double enemyTrueArmor = trueEnemyBaseArmor + trueEnemyBonusArmor;
		enemyTrueArmor = enemyTrueArmor - armorPen_Flat;
		return enemyTrueArmor;
	}
	
	private double getTrueEnemyMRFromScenario(UrgotScenario sce,
			double enemyBaseMR, double enemyBonusMR)
	
	{
		double magicReduc_Flat = 0; 
		double magicReduc_Percent = 0;
		double magicPen_Percent = 0;
		double magicrPen_Flat = 0;
		
		// Armor reduction is split between base and bonus armor.
		double trueEnemyBaseMR = enemyBaseMR - (magicReduc_Flat/2);
		double trueEnemyBonusMR = enemyBonusMR - (magicReduc_Flat/2);


		trueEnemyBaseMR = trueEnemyBaseMR * (magicReduc_Percent);
		trueEnemyBonusMR = trueEnemyBonusMR * magicReduc_Percent;

		trueEnemyBaseMR = trueEnemyBaseMR - (trueEnemyBaseMR * magicPen_Percent);
		trueEnemyBonusMR = trueEnemyBonusMR - (trueEnemyBonusMR * magicPen_Percent);
;


		double enemyTrueMR = trueEnemyBaseMR + trueEnemyBonusMR;
		enemyTrueMR = enemyTrueMR - magicrPen_Flat;
		return enemyTrueMR;
	}

	// TODO: getTrueEnemyMR();
//	private double getTrueEnemyMRFromScenario(UrgotScenario sce,
//			double enemyBaseMR, double enemyTotalMR)
//	{
//		return 0;
//	}
	
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
	
	
	public Map<Double,UrgotScenario> sortArmor(SortRank rank)
	{
		HashMap<Double,UrgotScenario> map = new HashMap<Double,UrgotScenario>();
		DefenseCalculator compareObject = new DefenseCalculator();
		for (UrgotScenario sce : listAllScenarios)
		{
			double trueHp = compareObject.findHealthVsPhysical(sce);
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
	
	
	public Map<Double,UrgotScenario> sortMagicResist(SortRank rank)
	{
		HashMap<Double,UrgotScenario> map = new HashMap<Double,UrgotScenario>();
		DefenseCalculator compareObject = new DefenseCalculator();
		for (UrgotScenario sce : listAllScenarios)
		{
			double trueHp = compareObject.findHealthVsMagic(sce);
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
	
	public int getScenarioCost(UrgotScenario sce)
	{
		int runningCost = 0;
		for(Entry<String,Item> item: sce.getUrgotItems().getItems().entrySet())
		{
			runningCost = runningCost + item.getValue().getCost();
		}
		return runningCost;
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
	
	
	public String getOffensiveStats(UrgotScenario sce)
	{
		StringBuilder offense = new StringBuilder();
		offense.append("AD: " + sce.getUrgotStats().getTotalAD() +  "\n");
		offense.append("Bonus AD: " + sce.getUrgotStats().getBonusAD() + "\n");
		offense.append("Mana: " + sce.getUrgotStats().getTotalMana() +  "\n");
		offense.append("Flat Armor Pen: " + sce.getUrgotStats().getFlatArmorPen() + "\n");
		offense.append("Armor Reduction: " + sce.getUrgotStats().getArmorReduc() + "\n");
		offense.append("Percent Armor Pen: " + sce.getUrgotStats().getPercentArmorPen() + "\n");
		offense.append("AS: " + sce.getUrgotStats().getTotalAS() + "\n");
		return offense.toString();
	}
	
	public String getDefensiveStats(UrgotScenario sce)
	{
		StringBuilder defense = new StringBuilder();
		defense.append("HP: " + sce.getUrgotStats().getTotalHP() +  "\n");
		defense.append("Armor: " + sce.getUrgotStats().getTotalArmor() +  "\n");
		defense.append("MR: " + sce.getUrgotStats().getTotalMR() +  "\n");
		return defense.toString();
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
	
	public String getUtilityStats(UrgotScenario sce)
	{
		StringBuilder utility = new StringBuilder();
		utility.append("Movement Speed: " + sce.getUrgotStats().getTotalMS() + "\n");
		utility.append("CDR: " + sce.getUrgotStats().getCDR() + "\n");
		utility.append("Tenacity: " + sce.getUrgotStats().getTenacity() + "\n");
		utility.append("Slow Resist: " + sce.getUrgotStats().getSlowResist() + "\n");
		return utility.toString();
	}
	
	
	
	
}
