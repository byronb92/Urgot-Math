package output;
import scenario.StatSetup;

import java.util.Map.Entry;

import battle.BattleSetup;
import battle.SkillRankType;
import masteries.MasterySet;
import runes.RuneSetup;
import scenario.ScenarioManager;
import scenario.SortRank;
import scenario.UrgotScenario;



/**
 * Dumps output providing details from the specified UrgotScenario.
 * The ScenarioManager handles all the logic to obtain the scenario.
 * Set up stat collection, then run battle calculations.
 * @author byronb92
 *
 */
public class OutputUrgotCompare {
	public ScenarioManager sceManager;

	public OutputUrgotCompare()
	{
		sceManager = new ScenarioManager();
	}

	/**
	 * Adds and sets up UrgotScenarios to be analyzed.
	 * StatSetup enum located in scenario package.
	 * @param setupCode
	 */
	public void statCollection(StatSetup setupCode)
	{
		sceManager.setUpStatCollection(setupCode);
	}
	

	/** Provides ability to apply same runes and masteries across multiple scenarios.
	 * @param setupCode
	 */
	public void statCollection(StatSetup setupCode, 
			RuneSetup runes, MasterySet masteries)
	{
		sceManager.setUpStatCollection(setupCode);
		for (UrgotScenario sce : sceManager.getScenarios())
		{
			sce.setUpRunesAndMasteries(runes, masteries);
			sce.computeStats();
		}
	}
	
	public void battleCollection(BattleSetup battleSetup, SkillRankType rankType)
	{
		for (UrgotScenario sce : sceManager.getScenarios())
		{
			sce.computeBattleScenario(battleSetup, rankType);
		}
	}
	
	

			
	/**
	 * Outputs general statistics about every scenario added from statCollection.
	 * @return
	 */
	public String outputGeneral()
	{
		StringBuilder generalInfo = new StringBuilder();
		for (UrgotScenario sce : sceManager.getScenarios())
		{
			generalInfo.append(sceManager.getScenarioItems(sce));
			generalInfo.append("\n");
			generalInfo.append("Cost: " + sceManager.getScenarioCost(sce));
			generalInfo.append("\n");
			generalInfo.append("Raw Damage: " + sceManager.getRawDamage(sce) + "\n");
			generalInfo.append("Offense: \n");
			generalInfo.append(sceManager.getOffensiveStats(sce));
			generalInfo.append("Defense: \n");
			generalInfo.append(sceManager.getDefensiveStats(sce));
			generalInfo.append("Sustain: \n");
			generalInfo.append(sceManager.getSustainStats(sce));
			generalInfo.append("---------------");
			generalInfo.append("\n");
		}
		return generalInfo.toString();
	}
	// Highest raw damage. This is the damage before any resistances are incorporated.
	public String outputHighestRawDamage()
	{
		StringBuilder rawDamageString = new StringBuilder();
		UrgotScenario highestDamage = sceManager.findHighestRawDamage();
		rawDamageString.append("Highest Raw Damage: ");
		rawDamageString.append(highestDamage.getBattleStats().getPhysicalDamage());
		rawDamageString.append("\n");
		if (sceManager.getScenarioItems(highestDamage) != null)
		{
			rawDamageString.append(sceManager.getScenarioItems(highestDamage));
		}
//		if (highestDamage.getMasteries().getKeyStone() != null)
//		{
//			rawDamageString.append(highestDamage.getMasteries().getKeyStone());
//		}
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
//			if (!sce.getMasteries().benefitsIsEmpty())
//			{
//				for (int i = 0; i < sce.getMasteries().getBenefitsList().size(); i++)
//				{
//					dmgString.append(sce.getMasteries().getBenefitsList().get(i));
//					dmgString.append("\n");
//					
//				}
//				dmgString.append("----------");
//				dmgString.append("\n");
//			}
		}
		
		System.out.println(dmgString.toString());
		return dmgString.toString();
	}
	//public void compareSustainability();
	//public void comparePassiveAndActives();
	//public void compareDamageVsArmor()

	
	
}
