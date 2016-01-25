package masteries;

import java.util.ArrayList;

import masteries.cunning.Cunning;
import masteries.ferocity.Ferocity;
import masteries.resolve.Resolve;
import urgot.UrgotStats;


/**
 * Handles addition of masteries.
 * @author byronb92
 *
 */
public class MasteryManager {
	private Masteries masteries;
	private ArrayList<Mastery> listCurrentMasteries;
	private ArrayList<String> masteryBenefits;
	private UrgotStats urgot;
	
	
	public MasteryManager(UrgotStats urgot)
	{
		masteries = new Masteries();
		masteryBenefits = new ArrayList<String>();
		listCurrentMasteries = new ArrayList<Mastery>();
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
	 * Sorcery, Feast, Vampirism, Oppressor
	 */
	public void thunderlordBalanced()
	{
		masteries.getCunning().addMasteryByName("Savagery");
		masteries.getCunning().addMasteryByName("Secret Stash");
		masteries.getCunning().addMasteryByName("Meditation");
		masteries.getCunning().addMasteryByName("Dangerous Game");
		masteries.getCunning().addMasteryByName("Intelligence");
		masteries.getCunning().addMasteryByName("Thunderlord's Decree");
		
		masteries.getFerocity().addMasteryByName("Sorcery");
		masteries.getFerocity().addMasteryByName("Feast");
		masteries.getFerocity().addMasteryByName("Vampirism");
		masteries.getFerocity().addMasteryByName("Oppressor");
		
	}
	
	/**
	 * Deathfire Touch Balanced
	 * Ferocity:
	 * Sorcery, Feast, Vampirism, Oppressor, Battering Blows, Deathfire Touch
	 * Cunning:
	 * Savagery, Secret Stash, Meditation, Dangerous Game
	 */ 
	public void deathfireBalanced()
	{
		masteries.getFerocity().addMasteryByName("Sorcrery");
		masteries.getFerocity().addMasteryByName("Feast");
		masteries.getFerocity().addMasteryByName("Vampirism");
		masteries.getFerocity().addMasteryByName("Oppressor");
		masteries.getFerocity().addMasteryByName("Battering Blows");
		masteries.getFerocity().addMasteryByName("Deathfire Touch");
		
		masteries.getCunning().addMasteryByName("Savagery");
		masteries.getCunning().addMasteryByName("Secret Stash");
		masteries.getCunning().addMasteryByName("Meditation");
		masteries.getCunning().addMasteryByName("Dangerous Game");
		
	}
	
	public void bondBalanced()
	{
		
	}
	
	
	/**
	 * Method should be used after masteries have been successfully added.
	 */
	private void aggregateAllMasteries()
	{
		listCurrentMasteries.addAll(masteries.getCunning().getListTreeMasteries());
		listCurrentMasteries.addAll(masteries.getFerocity().getListTreeMasteries());
		listCurrentMasteries.addAll(masteries.getResolve().getListTreeMasteries());
		
	}
	
	public void computeMasteryStats()
	{
		aggregateAllMasteries();
		for (Mastery mastery : listCurrentMasteries)
		{
			mastery.runMasteryCalculations(urgot);
		}
	}
	
	public ArrayList<String> getBenefitsList() { return masteryBenefits; }
	public boolean benefitsIsEmpty() { return masteryBenefits.isEmpty(); }
	


}
