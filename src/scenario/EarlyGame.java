package scenario;

import masteries.MasterySet;

/**
 * @author byronb92
 * http://leagueoflegends.wikia.com/wiki/Experience_(champion)
 * http://mullinator.com/tools/cscore?c=46&t=6.0&p=80
 * Levels 1-9, first legendary item purchase, halfway 2nd item purchase.
 * 18 Waves must spawn for level 9. (10 minutes and 30 seconds of game time.)
 * 75% of creeps hit = 86/144.  --  1804 gold from minions.
 * Passive gold					--  1501 gold
 * Estimated total gold.		-- 	3305
 * 
 * 9 waves for level 6.
 * Level 6 at 6 minutes in the game.
 * 1700-2000 gold around 6 minutes.
 * 
 * Early Game Purchases and Combonents to Compare
 * Most efficient first components.
 * 1. Tear
 * 2. Sheen
 * 3. Caulfield's Warhammer
 * 4. Phage
 * 5. Serrated Dirk
 * 
 * Best starting item comparison.
 * 1. Manamune
 * 2. Iceborn Gauntlet
 * 3. Black Cleaver
 * 4. Youmuu's Ghostblade
 *
 *
 */
public class EarlyGame extends Phase {
	public EarlyGame()
	{
		
	
	}
	
	@Override
	public void runStatCollection(StatSetup setupCode)
	{
		switch (setupCode)
		{
			case STARTING_ITEMS: compareStartingItems();
			break;
			case MASTERIES_LEVEL1: compareLevelOneMasteries();
			break;
			case LEVEL6: compareLevelSix();
			break;
			
			default: 	System.out.println("Invalid stat collection code: " + setupCode);
						System.out.println("There will be errors");
			break;
		}
	}
	/**
	 * Tries to compare 
	 */
	public void compareLevelOneMasteries()
	{
		addBlankScenario(1, MasterySet.THUNDERLORD_BALANCED);
		addBlankScenario(1, MasterySet.DEATHFIRE_BALANCED);
		addBlankScenario(1, MasterySet.BOND_BALANCED);
	}
	/**
	 * Compares first-level component items before legendaries are built.
	 * Creates 5 scenarios and finds the highest raw damage output. 
	 * This does not take into account the opponent's armor value.
	 */
	public void compareLevelSix()
	{
		String tear = "Tear";
		String sheen = "Sheen";
		String hammer = "Caulfield's Warhammer";
		String dirk = "Serrated Dirk";
		String phage = "Phage";
		
		addScenarioLevel(tear, 6);
		addScenarioLevel(sheen, 6);
		addScenarioLevel(hammer, 6);
		addScenarioLevel(dirk, 6);
		addScenarioLevel(phage, 6);
	}
	
	
	public void compareStartingItems()
	{
		addScenarioLevel("Doran's Blade", 1);
		addScenarioLevel("Sapphire Crystal", 1);
		addScenarioLevel("Long Sword", 1);
		addScenarioLevel("Cloth Armor", 1);
	}

	

	

	
	

}
