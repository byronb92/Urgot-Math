package battle;
import scenario.StatSetup;

import java.util.Map.Entry;

import calc.BattleCalculator;
import items.Item;
import items.Items;
import scenario.Phase;
import scenario.ScenarioManager;
import scenario.UrgotScenario;
import urgot.UrgotStats;

public class OutputUrgotCompare {
	public ScenarioManager sceManager;

	public OutputUrgotCompare()
	{
		sceManager = new ScenarioManager();
	}

	// Codes: LEVEL6, LEVEL9, LEVEL12, LEVEL15, LEVEL18
	public void statCollection(StatSetup setupCode)
	{
		sceManager.setUpStatCollection(setupCode);
	}

	/** Uses ScenarioManager method findHighestRawDamage()
	 * To find the build which has the highest combo damage output.
	 * @return
	 */
	public String outputHighestRawDamage()
	{
		StringBuilder rawDamageString = new StringBuilder();
		UrgotScenario highestDamage = sceManager.findHighestRawDamage();
		rawDamageString.append("Highest Raw Damage: ");
		rawDamageString.append(highestDamage.getBattleStats().getADDamage());
		rawDamageString.append("\n");
		rawDamageString.append(sceManager.getScenarioItems(highestDamage));
		System.out.println(rawDamageString.toString());
		return rawDamageString.toString();
	}
	
	public String outputLowestCost()
	{
		StringBuilder costString = new StringBuilder();
		UrgotScenario lowestCost = sceManager.findLowestCost();
		costString.append("Cheapest Full Build: ");
		costString.append(sceManager.getScenarioCost(lowestCost));
		costString.append("\n");
		costString.append(sceManager.getScenarioItems(lowestCost));
		System.out.println(costString.toString());
		return costString.toString();
	}
	
	public String outputSortedDamage()
	{
		StringBuilder dmgString = new StringBuilder();
		
		for (Entry<Double, UrgotScenario> entry : sceManager.sortDamage().entrySet())
		{
			dmgString.append("Raw Damage: " + entry.getKey());
			dmgString.append(" " + sceManager.getScenarioItems(entry.getValue()));
			dmgString.append("\n");
		}
		System.out.println(dmgString.toString());
		return dmgString.toString();
	}
	//public void compareHighestRawDamage()
	//public void compareCost();
	//public void compareDurability();
	//public void compareSustainability();
	//public void comparePassiveAndActives();
	//public void compareDamageVsArmor()
	
	// Mid Game Comparisons
//	public void outputLevel12Three()
//	{
//		sceManager.midSetup();
//		for (UrgotScenario sce : sceManager.getScenarios())
//		{
//			BattleCalculator calc = sce.getBattleStats();
//			UrgotStats urgot = sce.getUrgotStats();
//			Items urgItems = sce.getUrgotItems();
//			printAllItems(urgItems);
//			outputTotalCostsNoName(urgItems);
//			System.out.println("Raw Spell Damage: " + calc.getADDamage());
//			System.out.println("Battle Time: " + calc.getCastTime());
//			System.out.println("Total AD: " + urgot.getTotalAD());
//			System.out.println("Health: " + urgot.getTotalHP());
//			System.out.println("Armor: " + urgot.getTotalArmor());
//			System.out.println("Armor Pen: " + urgot.getArmorPen());
//			System.out.println("Armor Reduction: " + urgot.getArmorReduc());
//			System.out.println("Spell Rotations: " + 
//					(int)(urgot.getTotalMana() / calc.getManaUsage()));
//			System.out.println("------------------");
//			
//		}
//	}
	
	
	// Late game Comparisons
//	public void outputFullBuild()
//	{
//		sceManager.lateSetup();
//		for (UrgotScenario sce : sceManager.getScenarios())
//		{
//			BattleCalculator calc = sce.getBattleStats();
//			UrgotStats urgot = sce.getUrgotStats();
//			Items urgItems = sce.getUrgotItems();
//			printAllItems(urgItems);
//			outputTotalCostsNoName(urgItems);
//			System.out.println("Raw Spell Damage: " + calc.getADDamage());
//			System.out.println("Battle Time: " + calc.getCastTime());
//			System.out.println("Total AD: " + urgot.getTotalAD());
//			System.out.println("Health: " + urgot.getTotalHP());
//			System.out.println("Armor: " + urgot.getTotalArmor());
//			System.out.println("Magic Resistance: " + urgot.getTotalMR());
//			System.out.println("Armor Pen: " + urgot.getArmorPen());
//			System.out.println("Armor Reduction: " + urgot.getArmorReduc());
//			System.out.println("Spell Rotations: " + 
//					(int)(urgot.getTotalMana() / calc.getManaUsage()));
//			System.out.println("------------------");
//			
//		}
//	}
	
	
}
