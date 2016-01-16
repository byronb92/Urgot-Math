package scenario;


/**
 * Levels 10-15, second-third legendary item purchases.
 * Level 15 = 45 waves. (24 minutes)
 * 75% of creeps: 214/285 minions.		4855 gold
 * Total Gold:							7895 gold.
 * This class will help solve what's the best 2nd power
 * spike item for Urgot.
 * @author byronb92
 *
 */
public class MidGameScenarios extends Phase {
	
	
	public MidGameScenarios()
	{
		
	}
	
	@Override
	public void runStatCollection(StatSetup setupCode)
	{
		switch (setupCode)
		{
			case LEVEL9: compareLevelNine();
			break;
			
			default: 	System.out.println("Invalid stat collection code: " + setupCode);
						System.out.println("There will be errors");
			break;
		}
	}
	
	/**
	 * Level 9 can be achieved around 10 minutes/10 minutes 30 seconds.
	 * With 80% farming of lane minions, you should be around 3000-3300 gold.
	 * This is enough to buy 1 legendary item.
	 * Iceborn Gauntlet/Manamune/Black Cleaver/Youmuu's Ghostblade/Frozen Heart
	 */
	public void compareLevelNine()
	{
		String manamune = "Manamune350";
		String ibg = "Iceborn Gauntlet";
		String cleaver = "Black Cleaver";
		String ghostblade = "Youmuu's Ghostblade";
		String frozen = "Frozen Heart";
		
		addScenarioLevel(manamune, 9);
		addScenarioLevel(ibg, 9);
		addScenarioLevel(cleaver, 9);
		addScenarioLevel(ghostblade, 9);
		addScenarioLevel(frozen, 9);
	}
	
	// Tear --> Black Cleaver --> Iceborne Gauntlet
	// Tear --> Black Cleaver --> Frozen Heart
	// Tear --> Black Cleaver --> Manamune
	// Tear --> Black Cleaver --> Youmuu's Ghostblade	
	// Tear --> Iceborn Gauntlet --> Frozen Heart
	// Level 12 Comparison
	/**
	 * Analyzes possible mid-game item scenarios.
	 * Projections:
	 * 		Ahead Build: 	Tear --> Black Cleaver --> Youmuu's Ghostblade
	 * 						Mune --> Black Cleaver --> Serrated Dirk
	 * 		More Spells:	Tear --> Black Cleaver --> Iceborn Gauntlet
	 */
	public void compareBestThreeItems()
	{
		UrgotScenario thirdIG = new UrgotScenario(12);
		UrgotScenario thirdFH = new UrgotScenario(12);
		UrgotScenario thirdMune = new UrgotScenario(12);
		UrgotScenario thirdGhost = new UrgotScenario(12);
		UrgotScenario antiAD = new UrgotScenario(12);
		
		thirdIG.addItem("Tear700");
		thirdIG.addItem("Black Cleaver");
		thirdIG.addItem("Iceborn Gauntlet");
		thirdIG.computeStats();
		
		thirdFH.addItem("Tear700");
		thirdFH.addItem("Black Cleaver");
		thirdFH.addItem("Frozen Heart");
		thirdFH.computeStats();
		
		thirdMune.addItem("Manamune700");
		thirdMune.addItem("Black Cleaver");
		thirdMune.addItem("Serrated Dirk");
		thirdMune.computeStats();
		
		
		thirdGhost.addItem("Tear700");
		thirdGhost.addItem("Black Cleaver");
		thirdGhost.addItem("Youmuu's Ghostblade");
		thirdGhost.computeStats();
		
		antiAD.addItem("Tear700");
		antiAD.addItem("Iceborn Gauntlet");
		antiAD.addItem("Frozen Heart");
		antiAD.computeStats();
		
		
		
//		thirdIG.getUrgotCombos().lockOnNoUlt(12);
//		thirdFH.getUrgotCombos().lockOnNoUlt(12);
//		thirdMune.getUrgotCombos().lockOnNoUlt(12);
//		thirdGhost.getUrgotCombos().lockOnNoUlt(12);
//		antiAD.getUrgotCombos().lockOnNoUlt(12);
		
		addScenario(thirdIG);
		addScenario(thirdFH);
		addScenario(thirdMune);
		addScenario(thirdGhost);
		addScenario(antiAD);
	}
	
	// Level 12 Tank Builds
	// Righteous Glory --> 
	public void compareBruiser()
	{
		String[] vsAdOne = {"Black Cleaver", "Iceborn Gauntlet", "Randuin's Omen"};
		String[] vsAdTwo = {"Manamune700", "Iceborn Gauntlet", "Frozen Heart"};
		String[] vsApOne = {"Black Cleaver", "Manamune700", "Spirit Visage"};
		String[] vsApTwo = {"Righteous Glory", "Black Cleaver", "Spirit Visage"};
		
		String[] balanced = {"Frozen Heart", "Black Cleaver", "Righteous Glory"};
		String[] balancedTwo = {"Righteous Glory", "Zz'Rot Portal", "Black Cleaver"};
		
		String[] fullTank = {"Righteous Glory", "Death's Dance", "Spirit Visage"};
		String[] fullTankTwo = {"Frozen Heart", "Iceborn Gauntlet", "Randuin's Omen"};
		
		addScenarioLevel12(vsAdOne);
		addScenarioLevel12(vsAdTwo);
		addScenarioLevel12(vsApOne);
		addScenarioLevel12(vsApTwo);
		
		addScenarioLevel12(balanced);
		addScenarioLevel12(balancedTwo);
		
		addScenarioLevel12(fullTank);
		addScenarioLevel12(fullTankTwo);
		
	}
	
	/**
	 * Adds a level 12 scenario with no ult.
	 * @param itemNames
	 */
	private void addScenarioLevel12(String[] itemNames)
	{
		UrgotScenario currentScenario = new UrgotScenario(12);
		for (String item: itemNames)
		{
			currentScenario.addItem(item);
		}
		currentScenario.computeStats();
		//currentScenario.getUrgotCombos().lockOnNoUlt(12);
		addScenario(currentScenario);
	}
}
