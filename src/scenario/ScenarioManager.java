package scenario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

import calc.CompareDefense;
import items.Item;
import items.Items;

public class ScenarioManager {
	
	EarlyGame early;
	MidGame mid;
	LateGame late;
	
	/**
	 * Create UrgotScenario.
	 * Use EarlyGame/MidGame/lateGame to setup the Scenario.
	 * 		Call UrgotScenario(level)
	 * 		Add an item to the scenario
	 * 		Compute the stats
	 * Use ScenarioManager to add the Scenario into the listUrgots
	 * 
	 */
	private ArrayList<UrgotScenario> listAllScenarios;
	
	public ScenarioManager()
	{
		listAllScenarios = new ArrayList<UrgotScenario>();
	}
	
	public void setUpStatCollection(StatSetup setupCode)
	{
		
		if (setupCode == StatSetup.LEVEL6 || setupCode == StatSetup.MASTERIES_LEVEL1)
		{
			early = new EarlyGame();
			setUpPhase(early, setupCode);
		}
		else if (setupCode == StatSetup.LEVEL9 || setupCode == StatSetup.LEVEL12)
		{
			mid = new MidGame();
			setUpPhase(mid, setupCode);
		}
		else if (setupCode == StatSetup.LEVEL15 || setupCode == StatSetup.LEVEL18)
		{
			late = new LateGame();
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
	

	// ---------- Accessor Methods ----------
	public ArrayList<UrgotScenario> getScenarios()
	{
		return listAllScenarios;
	}
	// ---------- Helper Methods ----------
	private void addAllScenarios(ArrayList<UrgotScenario> smallList)
	{
		listAllScenarios.addAll(smallList);
	}

	
	// --------- Stat Collection --------
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
				double rawDamageA = sce.getBattleStats().getADDamage();
				double rawDamageB = highestDamageSce.getBattleStats().getADDamage();
				if (rawDamageA > rawDamageB)
				{
					highestDamageSce = sce;
				}
				else if (rawDamageA == rawDamageB)
				{
					System.out.println("-----------------");
					System.out.println("Duplicate raw damage: " + rawDamageA);
					System.out.println("Set 1: " + getScenarioItems(highestDamageSce));
					System.out.println("Set 2: " + getScenarioItems(sce));
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
			double rawDmg = sce.getBattleStats().getADDamage();
			map.put(makeKeyUnique(map,rawDmg), sce);
		}
		Map<Double,UrgotScenario> newMap = null;
		if (rank == SortRank.ASCENDING)
		{
			newMap = new TreeMap(map);
			return newMap;
		}
		newMap = new TreeMap(Collections.reverseOrder());
		newMap.putAll(map);
		return newMap;
	}
	
	
	public Map<Double,UrgotScenario> sortArmor(SortRank rank)
	{
		HashMap<Double,UrgotScenario> map = new HashMap<Double,UrgotScenario>();
		CompareDefense compareObject = new CompareDefense();
		for (UrgotScenario sce : listAllScenarios)
		{
			double trueHp = compareObject.findHealthVsPhysical(sce);
			map.put(makeKeyUnique(map,trueHp), sce);
		}
		Map<Double,UrgotScenario> newMap = null;
		if (rank == SortRank.ASCENDING)
		{
			newMap = new TreeMap(map);
		}
		newMap = new TreeMap(Collections.reverseOrder());
		newMap.putAll(map);
		return newMap;
	}
	
	
	public Map<Double,UrgotScenario> sortMagicResist(SortRank rank)
	{
		HashMap<Double,UrgotScenario> map = new HashMap<Double,UrgotScenario>();
		CompareDefense compareObject = new CompareDefense();
		for (UrgotScenario sce : listAllScenarios)
		{
			double trueHp = compareObject.findHealthVsMagic(sce);
			map.put(makeKeyUnique(map,trueHp), sce);
		}
		Map<Double,UrgotScenario> newMap = null;
		if (rank == SortRank.ASCENDING)
		{
			newMap = new TreeMap(map);
		}
		newMap = new TreeMap(Collections.reverseOrder());
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
	
	
	
	
	
}
