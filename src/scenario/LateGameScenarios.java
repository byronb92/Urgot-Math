package scenario;

import battle.BattleSetup;
import battle.SkillRankType;

/**
 * Level 13-18 4-5th item purchases. 
 * Full build comparisons.
 * https://docs.google.com/document/d/1ubpEPaYxwOA02NtEOEFRouxlbDoHz0dnHaqB9FzV9FQ/edit
 * @author byronb92
 *
 */
public class LateGameScenarios extends Phase {
	@Override
	public void runStatCollection(StatSetup setupCode)
	{
		switch (setupCode)
		{
			case LEVEL18: compareLevel18();
			break;
			
			default: 	System.out.println("Invalid stat collection code: " + setupCode);
						System.out.println("There will be errors");
			break;
		}
	}
	
	@Override
	public void runStatCollectionAndBattle(StatSetup setupCode, BattleSetup battleSetup, SkillRankType rankType)
	{
		switch (setupCode)
		{
			case LEVEL18: compareLevel18AndBattle(battleSetup, rankType);
			break;
			
			default: 	System.out.println("Invalid stat collection code: " + setupCode);
						System.out.println("There will be errors");
			break;
		}
	}
	
	public void compareLevel18()
	{
		String[] fullBuild = {"Muramana", "Black Cleaver", "Youmuu's Ghostblade", 
				"Maw of Malmortius", "Death's Dance", "Mercury's Treads"};
		String[] ghostTwo = {"Muramana", "Black Cleaver", "Youmuu's Ghostblade", 
				"Lord Dominik's Regards", "Death's Dance", "Mercury's Treads"};
		String[] fullBuildTwo = {"Muramana", "Black Cleaver", "Sterak's Gage", 
				"Iceborn Gauntlet", "Maw of Malmortius"};
		String[] fullBuildThree = {"Muramana", "Black Cleaver", "Sterak's Gage", 
				"Iceborn Gauntlet", "Lord Dominik's Regards"};
		
		String[] threeAD = {"Iceborn Gauntlet", "Black Cleaver", "Randuin's Omen", 
				"Maw of Malmortius", "Death's Dance", "Ninja Tabi"};
		String[] threeADTwo = {"Iceborn Gauntlet", "Muramana", "Frozen Heart", 
				"Randuin's Omen", "Dead Man's Plate", "Ninja Tabi"};
		
		String[] vsAP = {"Muramana", "Black Cleaver", "Spirit Visage", 
				"Death's Dance", "Maw of Malmortius", "Mercury's Treads"};
		String[] vsAP2 = {"Righteous Glory", "Black Cleaver", "Spirit Visage", 
				"Death's Dance", "Maw of Malmortius", "Mercury's Treads"};
		
		String[] balanced = {"Frozen Heart", "Black Cleaver", "Righteous Glory", 
				"Banshee's Veil", "Randuin's Omen", "Mercury's Treads"};
		String[] balancedTwo = {"Righteous Glory", "Zz'Rot Portal", "Black Cleaver", 
				"Banshee's Veil", "Randuin's Omen", "Mercury's Treads"};
		
		String[] fullTankAP = {"Righteous Glory", "Mercury's Treads", "Spirit Visage",
				"Death's Dance", "Maw of Malmortius"};
		String[] fullTankAP2 = {"Righteous Glory", "Mercury's Treads", "Spirit Visage",
				"Banshee's Veil", "Maw of Malmortius"};
		String[] fullTankAD = {"Frozen Heart", "Iceborn Gauntlet", "Randuin's Omen",
				"Dead Man's Plate", "Sunfire Cape"};
		
		
		addScenarioLevel(fullBuild, 18);
		addScenarioLevel(ghostTwo, 18);
		addScenarioLevel(fullBuildTwo, 18);
		addScenarioLevel(fullBuildThree, 18);
		addScenarioLevel(threeAD, 18);
		addScenarioLevel(threeADTwo, 18);
		addScenarioLevel(vsAP, 18);
		addScenarioLevel(vsAP2, 18);
		addScenarioLevel(balanced, 18);
		addScenarioLevel(balancedTwo, 18);
		addScenarioLevel(fullTankAP, 18);
		addScenarioLevel(fullTankAD, 18);
		addScenarioLevel(fullTankAP2, 18);
		}
	
	
	public void compareLevel18AndBattle(BattleSetup battleSetup, SkillRankType rankType)
	{
		String[] fullBuild = {"Muramana", "Black Cleaver", "Youmuu's Ghostblade", 
				"Maw of Malmortius", "Death's Dance", "Mercury's Treads"};
		String[] ghostTwo = {"Muramana", "Black Cleaver", "Youmuu's Ghostblade", 
				"Lord Dominik's Regards", "Death's Dance", "Mercury's Treads"};
		String[] fullBuildTwo = {"Muramana", "Black Cleaver", "Sterak's Gage", 
				"Iceborn Gauntlet", "Maw of Malmortius"};
		String[] fullBuildThree = {"Muramana", "Black Cleaver", "Sterak's Gage", 
				"Iceborn Gauntlet", "Lord Dominik's Regards"};
		
		String[] threeAD = {"Iceborn Gauntlet", "Black Cleaver", "Randuin's Omen", 
				"Maw of Malmortius", "Death's Dance", "Ninja Tabi"};
		String[] threeADTwo = {"Iceborn Gauntlet", "Muramana", "Frozen Heart", 
				"Randuin's Omen", "Dead Man's Plate", "Ninja Tabi"};
		
		String[] vsAP = {"Muramana", "Black Cleaver", "Spirit Visage", 
				"Death's Dance", "Maw of Malmortius", "Mercury's Treads"};
		String[] vsAP2 = {"Righteous Glory", "Black Cleaver", "Spirit Visage", 
				"Death's Dance", "Maw of Malmortius", "Mercury's Treads"};
		
		String[] balanced = {"Frozen Heart", "Black Cleaver", "Righteous Glory", 
				"Banshee's Veil", "Randuin's Omen", "Mercury's Treads"};
		String[] balancedTwo = {"Righteous Glory", "Zz'Rot Portal", "Black Cleaver", 
				"Banshee's Veil", "Randuin's Omen", "Mercury's Treads"};
		
		String[] fullTankAP = {"Righteous Glory", "Mercury's Treads", "Spirit Visage",
				"Death's Dance", "Maw of Malmortius"};
		String[] fullTankAP2 = {"Righteous Glory", "Mercury's Treads", "Spirit Visage",
				"Banshee's Veil", "Maw of Malmortius"};
		String[] fullTankAD = {"Frozen Heart", "Iceborn Gauntlet", "Randuin's Omen",
				"Dead Man's Plate", "Sunfire Cape"};
		
		
		addScenarioLevelAndBattle(fullBuild, 18, battleSetup, rankType);
		addScenarioLevelAndBattle(ghostTwo, 18,  battleSetup, rankType);
		addScenarioLevelAndBattle(fullBuildTwo, 18,  battleSetup, rankType);
		addScenarioLevelAndBattle(fullBuildThree, 18,  battleSetup, rankType);
		addScenarioLevelAndBattle(threeAD, 18,  battleSetup, rankType);
		addScenarioLevelAndBattle(threeADTwo, 18,  battleSetup, rankType);
		addScenarioLevelAndBattle(vsAP, 18,  battleSetup, rankType);
		addScenarioLevelAndBattle(vsAP2, 18,  battleSetup, rankType);
		addScenarioLevelAndBattle(balanced, 18,  battleSetup, rankType);
		addScenarioLevelAndBattle(balancedTwo, 18,  battleSetup, rankType);
		addScenarioLevelAndBattle(fullTankAP, 18,  battleSetup, rankType);
		addScenarioLevelAndBattle(fullTankAD, 18,  battleSetup, rankType);
		addScenarioLevelAndBattle(fullTankAP2, 18,  battleSetup, rankType);
		}
}
