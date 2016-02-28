package scenario;


/**
 * Level 13-18 4-5th item purchases. 
 * Full build comparisons.
 * @author byronb92
 *
 */
public class LateGameScenarios extends Phase {
	@Override
	public void runStatCollection(StatSetup setupCode)
	{
		// TODO: Rename setup codes.
		switch (setupCode)
		{
			case LEVEL18: compareNoTearBuild();
				break;	
			default: 	System.out.println("Invalid stat collection code: " + setupCode);
						System.out.println("There will be errors");
				break;
		}
	}
	

	/**
	 * Sets up comparison between Muramana builds.
	 */
	public void compareFullBuildMuramana()
	{
		String[] duskbladeDamage = {"Duskblade of Draktharr", "Black Cleaver", "Youmuu's Ghostblade", 
				"Maw of Malmortius", "Muramana", "Mercury's Treads"};
		String[] deathDanceDamage = {"Muramana", "Black Cleaver", "Youmuu's Ghostblade", 
				"Maw of Malmortius", "Death's Dance", "Mercury's Treads"};
		String[] dominikDamage = {"Muramana", "Black Cleaver", "Youmuu's Ghostblade", 
				"Lord Dominik's Regards", "Death's Dance", "Mercury's Treads"};
		String[] sterakMaw = {"Muramana", "Black Cleaver", "Sterak's Gage", 
				"Iceborn Gauntlet", "Maw of Malmortius"};
		String[] sterakDominik = {"Muramana", "Black Cleaver", "Sterak's Gage", 
				"Iceborn Gauntlet", "Lord Dominik's Regards"};
		String[] tankAP = {"Muramana", "Black Cleaver", "Spirit Visage", 
				"Death's Dance", "Maw of Malmortius", "Mercury's Treads"};
		
		String[] tankIceborn = {"Iceborn Gauntlet", "Muramana", "Frozen Heart", 
				"Randuin's Omen", "Dead Man's Plate", "Ninja Tabi"};
		addScenarioLevel(duskbladeDamage, 18);
		addScenarioLevel(deathDanceDamage, 18);
		addScenarioLevel(dominikDamage, 18);
		addScenarioLevel(sterakMaw, 18);
		addScenarioLevel(sterakDominik, 18);
		addScenarioLevel(tankAP, 18);
		addScenarioLevel(tankIceborn, 18);
		
	}
	
	/** Sets up scenario and item sets that aren't influenced by Muramana. */
	public void compareNoTearBuild()
	{
		
		String[] threeAD = {"Iceborn Gauntlet", "Black Cleaver", "Randuin's Omen", 
				"Maw of Malmortius", "Death's Dance", "Ninja Tabi"};
		
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
		
		

		addScenarioLevel(threeAD, 18);
		addScenarioLevel(vsAP2, 18);
		addScenarioLevel(balanced, 18);
		addScenarioLevel(balancedTwo, 18);
		addScenarioLevel(fullTankAP, 18);
		addScenarioLevel(fullTankAD, 18);
		addScenarioLevel(fullTankAP2, 18);
		}
	
	
}
