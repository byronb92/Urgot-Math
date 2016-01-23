package masteries;

import masteries.cunning.Cunning;
import masteries.ferocity.Ferocity;
import masteries.resolve.Resolve;
import urgot.UrgotStats;

public class MasteryManager {
	private Ferocity ferocity;
	private Cunning cunning;
	private Resolve resolve;
	private UrgotStats urgot;
	
	
	public MasteryManager(UrgotStats urgot)
	{
		this.urgot = urgot;
	}
	public void masterySetup(MasterySet masterySet)
	{
		switch (masterySet)
		{
			case THUNDERLORD_BALANCED:
				thunderlordBalanced();
				break;
			case DEATHFIRE_BALANCED:
				deathfireBalanced();
				break;
			case BOND_BALANCED:
				bondBalanced();
				break;
			default:
				break;
		}
	}
	
	
	/**
	 * Thunderlord's Urgot Version 1.
	 * Cunning:
	 * Savagery, Secret Stash, Meditation, Dangerous Game, Intelligence, Thunderlord's
	 * Ferocity:
	 * Ferocity, Feast, Vampirism, Oppressor
	 */
	private void thunderlordBalanced()
	{
		ferocity.addMasteryByName("Feast");
		ferocity.addMasteryByName("Vampirism");
		ferocity.addMasteryByName("Oppressor");
		
	}
	
	private void deathfireBalanced()
	{
		
	}
	
	private void bondBalanced()
	{
		
	}

}
