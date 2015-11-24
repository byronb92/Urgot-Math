package battle;


import java.util.Map.Entry;

import battle.scenario.EarlyGame;
import battle.scenario.LateGame;
import battle.scenario.MidGame;
import battle.scenario.ScenarioManager;
import battle.scenario.UrgotScenario;
import items.Item;
import items.Items;
import urgot.UrgotStats;

public class OutputUrgotCompare {
	ScenarioManager sceManager;

	public OutputUrgotCompare()
	{
		sceManager = new ScenarioManager();
	}
	
	/**
	 * Create UrgotScenario.
	 * Use EarlyGame/MidGame/lateGame to setup the Scenario.
	 * 		Call UrgotScenario(level)
	 * 		Add an item to the scenario
	 * 		Compute the stats
	 * Use ScenarioManager to add the Scenario into the listUrgots
	 * 
	 */
	
	
	/**
	 * Total damage dealt.
	 * Compares spell rotations.
	 * Durability
	 * Cost
	 */
	/**
	 * general setup
	 * 		for (UrgotScenario sce : sceManager.getScenarios())
		{
			BattleCalculator currentManager = sce.getBattleStats();
			UrgotStats currentUrgot = sce.getUrgotStats();
			Items currentItems = sce.getUrgotItems();
			outputTotalCosts(currentItems);		
		}
	 */
	public void outputEarlyItemCosts()
	{
		sceManager.earlySetup();
		for (UrgotScenario sce : sceManager.getScenarios())
		{
			BattleCalculator currentManager = sce.getBattleStats();
			UrgotStats currentUrgot = sce.getUrgotStats();
			Items currentItems = sce.getUrgotItems();
			outputTotalCosts(currentItems);		
		}
	}
	
	
	private void outputTotalCosts(Items urgotItems)
	{
		int runningCost = 0;
		StringBuilder builder = new StringBuilder();
		builder.append("Items: ");
		for(Entry<String,Item> item: urgotItems.getItems().entrySet())
		{
			builder.append(item.getValue().getName() + " ");
			runningCost = runningCost + item.getValue().getCost();
		}
		System.out.println(builder.toString());
		System.out.println("Combined Item Cost: " + runningCost);
	}

}
