package scenario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
		
		if (setupCode == StatSetup.LEVEL6 || setupCode == StatSetup.MASTERIES_LEVEL1
				|| setupCode == StatSetup.STARTING_ITEMS)
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
		return sce.getBattleStats().getPhysicalDamage();
	}
	
	
	public String getOffensiveStats(UrgotScenario sce)
	{
		StringBuilder offense = new StringBuilder();
		offense.append("AD: " + sce.getUrgotStats().getTotalAD() +  "\n");
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
