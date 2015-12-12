package battle;
import scenario.StatSetup;

import java.util.Map.Entry;

import calc.BattleCalculator;
import items.Item;
import items.Items;
import scenario.Phase;
import scenario.ScenarioManager;
import scenario.SortRank;
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
	
	public String outputSortedDamage(SortRank rank)
	{
		StringBuilder dmgString = new StringBuilder();
		
		for (Entry<Double, UrgotScenario> entry : sceManager.sortDamage(rank).entrySet())
		{
			dmgString.append("Raw Damage: " + entry.getKey());
			dmgString.append(" " + sceManager.getScenarioItems(entry.getValue()));
			dmgString.append("\n");
		}
		System.out.println(dmgString.toString());
		return dmgString.toString();
	}

	
	public String outputSortedArmor(SortRank rank)
	{
		StringBuilder dmgString = new StringBuilder();
		
		for (Entry<Double, UrgotScenario> entry : sceManager.sortArmor(rank).entrySet())
		{
			dmgString.append("True HP: " + entry.getKey());
			dmgString.append(" " + sceManager.getScenarioItems(entry.getValue()));
			dmgString.append("\n");
		}
		System.out.println(dmgString.toString());
		return dmgString.toString();
	}
	
	
	public String outputPassiveandActivies()
	{
		StringBuilder dmgString = new StringBuilder();
		
		for (UrgotScenario sce : sceManager.getScenarios())
		{
			dmgString.append(sceManager.getScenarioItems(sce));
			dmgString.append("\n");
			dmgString.append(sce.getUrgotItems().getAllItemDetails());
			dmgString.append("\n");
			dmgString.append("----------");
			dmgString.append("\n");
		}
		System.out.println(dmgString.toString());
		return dmgString.toString();
	}
	//public void compareSustainability();
	//public void comparePassiveAndActives();
	//public void compareDamageVsArmor()

	
	
}
