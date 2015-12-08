package battle;


import java.util.Map.Entry;

import calc.BattleCalculator;
import items.Item;
import items.Items;
import scenario.ScenarioManager;
import scenario.UrgotScenario;
import urgot.UrgotStats;

public class OutputUrgotCompare {
	private ScenarioManager sceManager;

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
	
	
	// Early Game Comparisons
	public void outputAllLevel6Items()
	{
		sceManager.earlySetup();
		for (UrgotScenario sce : sceManager.getScenarios())
		{
			BattleCalculator calc = sce.getBattleStats();
			UrgotStats urgot = sce.getUrgotStats();
			Items urgItems = sce.getUrgotItems();
			printAllItems(urgItems);
			outputTotalCostsNoName(urgItems);
			System.out.println("Raw Spell Damage: " + calc.getADDamage());
			System.out.println("Battle Time: " + calc.getCastTime());
			System.out.println("Armor Pen: " + urgot.getArmorPen());
			System.out.println("Armor Reduction: " + urgot.getArmorReduc());
			System.out.println("Spell Rotations: " + 
					(int)(urgot.getTotalMana() / calc.getManaUsage()));
			System.out.println("------------------");
			
		}
	}
	public void outputGhostbladeVsCleaver()
	{
		sceManager.GhostbladeVsClear();
		UrgotScenario sce = sceManager.getScenarios().get(0);
		UrgotScenario sce2 = sceManager.getScenarios().get(1);
		
		String itemOne = sce.getUrgotItems().getItems().
				get("Youmuu's Ghostblade").getName();
		String itemTwo = sce2.getUrgotItems().getItems().
				get("Black Cleaver").getName();
		
		
		BattleCalculator calcBlade = sce.getBattleStats();
		UrgotStats urgotBlade = sce.getUrgotStats();
		
		BattleCalculator calcCleaver = sce2.getBattleStats();
		UrgotStats urgotCleaver = sce2.getUrgotStats();
		
		System.out.println(itemOne);
		System.out.println("Raw Spell Damage: " + calcBlade.getADDamage());
		System.out.println("Battle Time: " + calcBlade.getCastTime());
		System.out.println("Armor Pen: " + sce.getUrgotStats().getArmorPen());
		System.out.println("Armor Reduction: " + sce.getUrgotStats().getArmorReduc());
		System.out.println("-------------");
		
		System.out.println(itemTwo);
		System.out.println("Raw Spell Damage: " + calcCleaver.getADDamage());
		System.out.println("Battle Time: " + calcCleaver.getCastTime());
		System.out.println("Armor Pen: " + sce2.getUrgotStats().getArmorPen());
		System.out.println("Armor Reduction: " + sce2.getUrgotStats().getArmorReduc());
		System.out.println("-------------");
		
		
	}
	public void outputSheenDamage()
	{
		sceManager.sheenDamage();
		UrgotScenario sce = sceManager.getScenarios().get(0);
		BattleCalculator calc = sce.getBattleStats();
		UrgotStats urgot = sce.getUrgotStats();
		
		System.out.println("Raw Spell Damage: " + calc.getADDamage());
		System.out.println("Battle Time: " + calc.getCastTime());
		System.out.println("Q Casts: " + sce.getUrgotCombos().getSkills().getQCasts());
		System.out.println("Attack Speed: " + urgot.getTotalAS());
		System.out.println("Number of Autos: " + (int)(calc.getCastTime() / urgot.getTotalAS()));
		// Sheen proc has 1.5 second cooldown.
		System.out.println("Sheen empowered Autos: " + (int)(calc.getCastTime() / 1.5));
		System.out.println("Base AD: " + urgot.getBaseADFromLevel());
		System.out.println("Sheen Auto Attack Damage: " + (urgot.getTotalAD() + urgot.getBaseADFromLevel()));
		System.out.println("----------------------");
		int normalAutos = ((int)(calc.getCastTime() / urgot.getTotalAS())) - ((int)(calc.getCastTime() / 1.5));
		int sheenAutos = (int)(calc.getCastTime() / 1.5);
		double autoDmg = (normalAutos * urgot.getTotalAD());
		double sheenDmg = sheenAutos * (urgot.getTotalAD() + urgot.getBaseADFromLevel());
		double normalAutoDmg = ((int)(calc.getCastTime() / urgot.getTotalAS())) * urgot.getTotalAD();
		System.out.println("Pure Auto Attack Damage: " + normalAutoDmg);
		System.out.println("Sheen Combo Difference: " + (autoDmg + sheenDmg));
		System.out.println("Sheen Total Damage: " + (autoDmg + sheenDmg + calc.getADDamage()));
	}
	public void outputCaulfieldVsDirk()
	{
		sceManager.armorPenVSAD();
		for (UrgotScenario sce : sceManager.getScenarios())
		{
			BattleCalculator currentManager = sce.getBattleStats();
			UrgotStats currentUrgot = sce.getUrgotStats();
			Items currentItems = sce.getUrgotItems();
			printAllItems(currentItems);
			System.out.println("Raw damage: " + currentManager.getADDamage());
			System.out.println("Armor pen: " + currentUrgot.getArmorPen());
			System.out.println("Armor reduction: " + currentUrgot.getArmorReduc());
			
		}
	}
	public void outputEarlyHighestRaw()
	{
		sceManager.earlySetup();
		double highestDamage = 0;
		Items highestItems = null;
		for (UrgotScenario sce : sceManager.getScenarios())
		{
			BattleCalculator currentManager = sce.getBattleStats();
			UrgotStats currentUrgot = sce.getUrgotStats();
			Items currentItems = sce.getUrgotItems();
			if (currentManager.getADDamage() > highestDamage)
			{
				highestDamage = currentManager.getADDamage();
				highestItems = currentItems;
			}	
		}
		System.out.println("Highest Raw Damage Build:");
		System.out.println("Damage Done: " + highestDamage);
		printAllItems(highestItems);
	}
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
	
	
	// Mid Game Comparisons
	public void outputLevel12Three()
	{
		sceManager.midSetup();
		for (UrgotScenario sce : sceManager.getScenarios())
		{
			BattleCalculator calc = sce.getBattleStats();
			UrgotStats urgot = sce.getUrgotStats();
			Items urgItems = sce.getUrgotItems();
			printAllItems(urgItems);
			outputTotalCostsNoName(urgItems);
			System.out.println("Raw Spell Damage: " + calc.getADDamage());
			System.out.println("Battle Time: " + calc.getCastTime());
			System.out.println("Total AD: " + urgot.getTotalAD());
			System.out.println("Health: " + urgot.getTotalHP());
			System.out.println("Armor: " + urgot.getTotalArmor());
			System.out.println("Armor Pen: " + urgot.getArmorPen());
			System.out.println("Armor Reduction: " + urgot.getArmorReduc());
			System.out.println("Spell Rotations: " + 
					(int)(urgot.getTotalMana() / calc.getManaUsage()));
			System.out.println("------------------");
			
		}
	}
	
	
	// Late game Comparisons
	public void outputFullBuild()
	{
		sceManager.lateSetup();
		for (UrgotScenario sce : sceManager.getScenarios())
		{
			BattleCalculator calc = sce.getBattleStats();
			UrgotStats urgot = sce.getUrgotStats();
			Items urgItems = sce.getUrgotItems();
			printAllItems(urgItems);
			outputTotalCostsNoName(urgItems);
			System.out.println("Raw Spell Damage: " + calc.getADDamage());
			System.out.println("Battle Time: " + calc.getCastTime());
			System.out.println("Total AD: " + urgot.getTotalAD());
			System.out.println("Health: " + urgot.getTotalHP());
			System.out.println("Armor: " + urgot.getTotalArmor());
			System.out.println("Magic Resistance: " + urgot.getTotalMR());
			System.out.println("Armor Pen: " + urgot.getArmorPen());
			System.out.println("Armor Reduction: " + urgot.getArmorReduc());
			System.out.println("Spell Rotations: " + 
					(int)(urgot.getTotalMana() / calc.getManaUsage()));
			System.out.println("------------------");
			
		}
	}
	
	// Utility functions.
	private void printAllItems(Items urgotItems)
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Items: ");
		for(Entry<String,Item> item: urgotItems.getItems().entrySet())
		{
			builder.append(item.getValue().getName() + " ");
		}
		System.out.println(builder.toString());
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
	private void outputTotalCostsNoName(Items urgotItems)
	{
		int runningCost = 0;
		StringBuilder builder = new StringBuilder();
		for(Entry<String,Item> item: urgotItems.getItems().entrySet())
		{
			runningCost = runningCost + item.getValue().getCost();
		}
		System.out.println("Combined Item Cost: " + runningCost);
	}

}
