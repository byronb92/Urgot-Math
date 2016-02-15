package scenario;

import masteries.MasterySet;
import runes.RuneSetup;

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
public class EarlyGameScenarios extends Phase {
	public EarlyGameScenarios()
	{
		
	
	}
	
	@Override
	public void runStatCollection(StatSetup setupCode)
	{
		switch (setupCode)
		{
			case LEVEL4: compareLevelFour_ArmorPenVsAD();
			break;
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
	
	public void compareLevelFour_ArmorPenVsAD()
	{
		UrgotScenario thunderlordLong_AD = new UrgotScenario(4);
		UrgotScenario thunderlordLong_PEN = new UrgotScenario(4);
		UrgotScenario deathfireLong_AD = new UrgotScenario(4);
		UrgotScenario deathfireLong_PEN = new UrgotScenario(4);
		
		
		thunderlordLong_AD.setUpRunesAndMasteries(RuneSetup.STANDARD, 
				MasterySet.THUNDERLORD_BALANCED);
		thunderlordLong_PEN.setUpRunesAndMasteries(RuneSetup.ARMPENQUINT, 
				MasterySet.THUNDERLORD_BALANCED);
		deathfireLong_AD.setUpRunesAndMasteries(RuneSetup.STANDARD, 
				MasterySet.DEATHFIRE_BALANCED);
		deathfireLong_PEN.setUpRunesAndMasteries(RuneSetup.ARMPENQUINT, 
				MasterySet.DEATHFIRE_BALANCED);
		
		thunderlordLong_AD.addItem("Long Sword");
		thunderlordLong_PEN.addItem("Long Sword");
		deathfireLong_AD.addItem("Long Sword");
		deathfireLong_PEN.addItem("Long Sword");
		
		addScenario(thunderlordLong_AD, "Thunderlord + AD Runes");
		addScenario(thunderlordLong_PEN, "Thunderlord + Armor Pen Runes");
		addScenario(deathfireLong_AD, "Deathfire + AD Runes");
		addScenario(deathfireLong_PEN, "Deathfire + Armor Pen Runes");
	}
	/**
	 * Tries to compare 
	 */
	public void compareLevelOneMasteries()
	{
		UrgotScenario thunderlord = new UrgotScenario(1);
		UrgotScenario deathfire = new UrgotScenario(1);
		UrgotScenario bond = new UrgotScenario(1);
		thunderlord.addMasteries(MasterySet.THUNDERLORD_BALANCED);
		deathfire.addMasteries(MasterySet.DEATHFIRE_BALANCED);
		bond.addMasteries(MasterySet.BOND_BALANCED);
		
		addScenario(thunderlord, "Thunderlord Mastery Start");
		addScenario(deathfire, "Deathfire Mastery Start");
		addScenario(bond, "Bond of Stone Start");
		

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
		
		addScenarioLevel(tear, 6, "Tear");
		addScenarioLevel(sheen, 6, "Sheen");
		addScenarioLevel(hammer, 6, "Caulfield's Warhammer");
		addScenarioLevel(dirk, 6, "Serrated Dirk");
		addScenarioLevel(phage, 6, "Phage");
	}
	
	
	public void compareStartingItems()
	{
		addScenarioLevel("Doran's Blade", 1, "Doran's Blade");
		addScenarioLevel("Sapphire Crystal", 1, "Sapphire Crystal");
		addScenarioLevel("Long Sword", 1, "Long Sword");
		addScenarioLevel("Cloth Armor", 1, "Cloth Armor");
	}

	

	

	
	

}
