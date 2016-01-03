package battle;
import scenario.StatSetup;

import java.util.Map.Entry;

import scenario.ScenarioManager;
import scenario.SortRank;
import scenario.UrgotScenario;



/**
 * Dumps output providing details from the specified UrgotScenario.
 * The ScenarioManager handles all the logic to obtain the scenario.
 * @author byronb92
 *
 */
public class OutputUrgotCompare {
	public ScenarioManager sceManager;

	public OutputUrgotCompare()
	{
		sceManager = new ScenarioManager();
	}

	// StatSetup enum located in scenario package.
	public void statCollection(StatSetup setupCode)
	{
		sceManager.setUpStatCollection(setupCode);
	}
	

	// Highest raw damage. This is the damage before any resistances are incorporated.
	public String outputHighestRawDamage()
	{
		StringBuilder rawDamageString = new StringBuilder();
		UrgotScenario highestDamage = sceManager.findHighestRawDamage();
		rawDamageString.append("Highest Raw Damage: ");
		rawDamageString.append(highestDamage.getBattleStats().getADDamage());
		rawDamageString.append("\n");
		if (sceManager.getScenarioItems(highestDamage) != null)
		{
			rawDamageString.append(sceManager.getScenarioItems(highestDamage));
		}
		rawDamageString.append(highestDamage.getMasteries().getKeyStone());
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
	

	// SortRank located in Scenario package. ASCENDING/DESCENDING
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
	
	/**
	 * Passive and actives include any extra item/mastery information.
	 * This will give an insight to how much utility is given by item/mastery builds.
	 * @return
	 */
	public String outputPassiveandActivies()
	{
		StringBuilder dmgString = new StringBuilder();
		for (UrgotScenario sce : sceManager.getScenarios())
		{
			// Items
			if (sceManager.getScenarioItems(sce) != null)
			{
				dmgString.append(sceManager.getScenarioItems(sce));
				dmgString.append("\n");
				dmgString.append(sce.getUrgotItems().getAllItemDetails());
				dmgString.append("\n");
				dmgString.append("----------");
				dmgString.append("\n");
			}
			
			// Masteries
			if (!sce.getMasteries().benefitsIsEmpty())
			{
				for (int i = 0; i < sce.getMasteries().getBenefitsList().size(); i++)
				{
					dmgString.append(sce.getMasteries().getBenefitsList().get(i));
					dmgString.append("\n");
					
				}
				dmgString.append("----------");
				dmgString.append("\n");
			}
		}
		
		System.out.println(dmgString.toString());
		return dmgString.toString();
	}
	//public void compareSustainability();
	//public void comparePassiveAndActives();
	//public void compareDamageVsArmor()

	
	
}
