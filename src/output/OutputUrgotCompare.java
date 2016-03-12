package output;

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

	/** Provides ability to apply same runes and masteries across multiple scenarios.
	 * @param setupCode StatSetup enum specifying scenarios to be added.
	 * @param runes RuneSetup enum specifying runes to be added.
	 * @param masteries MasterySet enum specifying masteries to be added.
	 */
	public void statCollection(RuneSetup runes, MasterySet masteries)
	{
		// TODO: Should work if scenarios are already setup.
		for (UrgotScenario sce : sceManager.getScenarios())
		{
			sce.setUpRunesAndMasteries(runes, masteries);
			sce.computeStats();
		}
	}
	
	/**
	 * Designates the combo that will be normalized acrossed all scenarios.
	 * @param battleSetup BattleSetup enum.
	 * @param rankType SkilLRankType enum specifying ability ranks based on Urgot's level.
	 */
	public void battleCollection(BattleSetup battleSetup, SkillRankType rankType)
	{
		for (UrgotScenario sce : sceManager.getScenarios())
		{
			sce.computeBattleScenario(battleSetup, rankType);
		}
	}
	
	

			
	/** @return string containing statical overview of a scenario. */
	public String outputGeneral()
	{
		StringBuilder generalInfo = new StringBuilder();
		for (UrgotScenario sce : sceManager.getScenarios())
		{
			generalInfo.append(sce.getScenarioName() + "\n");
			generalInfo.append(sceManager.getScenarioItems(sce));
			generalInfo.append("\n");
			generalInfo.append("Cost: " + sceManager.getScenarioCost(sce));
			generalInfo.append("\n");
			generalInfo.append("Raw Damage: " + sceManager.getRawDamage(sce) + "\n");
			generalInfo.append("Physical Damage: " + sce.getBattleStats().getPhysicalDamage() + "\n");
			generalInfo.append("Magic Damage Damage: " + sce.getBattleStats().getMagicDamage() + "\n");
			generalInfo.append("\nOffense: \n");
			generalInfo.append(sceManager.getOffensiveStats(sce));
			generalInfo.append("\nDefense: \n");
			generalInfo.append(sceManager.getDefensiveStats(sce));
			generalInfo.append("\nSustain: \n");
			generalInfo.append(sceManager.getSustainStats(sce));
			generalInfo.append("---------------");
			generalInfo.append("\n");
		}
		return generalInfo.toString();
	}

	/**
	 * @return Highest raw damage before resistances are applied.
	 */
	public String outputHighestRawDamage()
	{
		StringBuilder rawDamageString = new StringBuilder();
		UrgotScenario highestDamage = sceManager.findHighestRawDamage();
		rawDamageString.append("Highest Raw Damage: ");
		rawDamageString.append(highestDamage.getBattleStats().getTotalDamage());
		rawDamageString.append("\n");
		if (sceManager.getScenarioItems(highestDamage) != null)
		{
			rawDamageString.append(sceManager.getScenarioItems(highestDamage));
		}
//		if (highestDamage.getMasteries().getKeyStone() != null)
//		{
//			rawDamageString.append(highestDamage.getMasteries().getKeyStone());
//		}
		return rawDamageString.toString();
	}
	
	/**
	 * @return Highest real damage, the damage calculated AFTER resistances.
	 * @param enemyBaseArmor Enemy armor growth per level.
	 * @param enemyBonusArmor Armor from runes/masteries/items/abilities
	 * @param enemyBonusMR Magic Resistance from runes/masteries/items/abilities
	 */
	public String outputHighestRealDamage(double enemyBaseArmor, double enemyBonusArmor,
			double enemyBaseMR, double enemyBonusMR)
	{
		StringBuilder rawDamageString = new StringBuilder();
		UrgotScenario highestDamage = sceManager.findHighestRealDamage(
				enemyBaseArmor, enemyBonusArmor, enemyBaseMR, enemyBonusMR);
		rawDamageString.append("Highest Real Damage: ");
		rawDamageString.append(highestDamage.getScenarioName());
		rawDamageString.append("\n");
		return rawDamageString.toString();
	}
	
	/** @return Cheapest item build contained in the scenario list. */
	public String outputLowestCost()
	{
		StringBuilder costString = new StringBuilder();
		UrgotScenario lowestCost = sceManager.findLowestCost();
		costString.append("Cheapest Full Build: ");
		costString.append(sceManager.getScenarioCost(lowestCost));
		costString.append("\n");
		costString.append(sceManager.getScenarioItems(lowestCost));
		return costString.toString();
	}
	

	/** 
	 * Sorts all scenarios by highest or lowest RAW damage.
	 * @param rank SortRank enum that sorts in ascending or descending order
	 * @return String of sorted scenarios by raw damage.
	 */
	public String outputSortedDamage(SortRank rank)
	{
		StringBuilder dmgString = new StringBuilder();
		for (Entry<Double, UrgotScenario> entry : sceManager.sortDamage(rank).entrySet())
		{
			dmgString.append("Raw Damage: " + entry.getKey());
			dmgString.append(" " + entry.getValue().getScenarioName());
			dmgString.append("\n");
		}
		return dmgString.toString();
	}
	
	/** 
	 * Sorts all scenarios by highest or lowest REAL damage.
	 * @param rank SortRank enum that sorts in ascending or descending order
	 * @return String of sorted scenarios by raw damage.
	 */
	public String outputSortedRealDamage(SortRank rank, double enemyBaseArmor, double enemyBonusArmor, 
			double enemyBaseMR, double enemyBonusMR)
	{
		StringBuilder dmgString = new StringBuilder();
		
		for (Entry<Double, UrgotScenario> entry : sceManager.sortRealDamage(rank,
				enemyBaseArmor, enemyBonusArmor, enemyBaseMR, enemyBonusMR).entrySet())
		{
			dmgString.append("Real Damage: " + entry.getKey());
			dmgString.append(" " + entry.getValue().getScenarioName());
			dmgString.append("\n");
		}
		return dmgString.toString();
	}


	/** 
	 * Sorts all scenarios by highest armor.
	 * @param rank SortRank enum that sorts in ascending or descending order.
	 * @return String of sorted armor values.
	 */
	public String outputSortedArmor(SortRank rank)
	{
		StringBuilder dmgString = new StringBuilder();
		
		for (Entry<Double, UrgotScenario> entry : sceManager.sortArmor(rank).entrySet())
		{
			dmgString.append("True HP: " + entry.getKey());
			dmgString.append(" " + sceManager.getScenarioItems(entry.getValue()));
			dmgString.append("\n");
		}
		return dmgString.toString();
	}
	
	/**
	 * Outputs passive and actives including any extra item/mastery information.
	 * @return String of informationa bout passive and actives.
	 */
	public String outputPassiveandActivies()
	{
		StringBuilder dmgString = new StringBuilder();
		for (UrgotScenario sce : sceManager.getScenarios())
		{
			dmgString.append(sce.getScenarioName() + "\n");
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
			
			//Masteries
	
			dmgString.append(sce.getMasteryManager().collectMasteryDetails());
			dmgString.append("\n");
		}
		
		return dmgString.toString();
	}
	//public void compareSustainability();
	//public void comparePassiveAndActives();
	//public void compareDamageVsArmor()

	
	
}
