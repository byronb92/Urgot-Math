package masteries;

import java.util.ArrayList;

import battle.Battle;
import urgot.UrgotStats;

/**
 * The masteries object will be attached to every UrgotScenario object.
 * There are several types of masteries that should be applied before any items are added,
 * right after items are added, and right after battle scenarios. This is due to the fact
 * that some stats need to be applied before others to correctly compute damage output.
 * @author byronb92
 *
 */
public class Masteries {
	
	private Ferocity ferocity;
	private Cunning cunning;
	private Resolve resolve;
	
	private ArrayList<String> masteryBenefits;
	private String keystone;
	
	
	public Masteries()
	{
		ferocity = new Ferocity();
		cunning = new Cunning();
		resolve = new Resolve();
		masteryBenefits = new ArrayList<String>();
	}
	
	/**
	 * Thunderlord's Urgot Version 1.
	 * Cunning:
	 * Savagery, Secret Stash, Meditation, Dangerous Game, Intelligence, Thunderlord's
	 * Ferocity:
	 * Ferocity, Feast, Vampirism, Oppressor
	 * 
	 * Deathfire Touch Balanced
	 * Ferocity:
	 * Ferocity, Feast, Vampirism, Oppressor, Battering Blows, Deathfire Touch
	 * Cunning:
	 * Savagery, Secret Stash, Meditation, Dangerous Game
	 * 
	 * Tanky Urgot
	 */
	
	

	/**
	 * List of masteries that are applied before any items should be applied.
	 * Ferocity Tree: Feast, Vampirism, Natural Talent, Battering Blows/Percing Thoughts
	 * Cunning Tree: Savagery, Runic Affinity/Secret Stash, Meditation, Bandit,
	 * 		Precision/Intelligence.
	 * Resolve Tree: Recovery, Tough Skin, Veteran's Scars, Insight, Perseverence(1st Half)
	 * 		Swiftness, Guardian, Strength of the Ages, Bond of Stone
	 * @param mastery
	 * @param urgot
	 */
	public void applyUrgotMastery(MasterySet mastery, UrgotStats urgot)
	{
		if (mastery == MasterySet.THUNDERLORD_BALANCED)
		{
			ferocity.vampirism(urgot);
			masteryBenefits.add(cunning.savagery());
			masteryBenefits.add(cunning.secretStash());
			cunning.meditation(urgot);
			masteryBenefits.add(cunning.dangerousGame());
			cunning.intelligence(urgot);
			masteryBenefits.add(ferocity.feast());	
		}
		
		if (mastery == MasterySet.DEATHFIRE_BALANCED)
		{
			masteryBenefits.add(ferocity.feast());
			ferocity.vampirism(urgot);
			ferocity.battering(urgot);
			
			masteryBenefits.add(cunning.savagery());
			masteryBenefits.add(cunning.secretStash());
			masteryBenefits.add(cunning.meditation(urgot));
			masteryBenefits.add(cunning.dangerousGame());
			
			
		}
		
		if (mastery == MasterySet.BOND_BALANCED)
		{
			masteryBenefits.add(resolve.toughSkin());
			resolve.veterans(urgot);
			resolve.perseveranceBeforeItems(urgot);
			resolve.swiftness(urgot);
			masteryBenefits.add(resolve.stoneBond());
			
			masteryBenefits.add(cunning.savagery());
			masteryBenefits.add(cunning.secretStash());
			masteryBenefits.add(cunning.meditation(urgot));
			masteryBenefits.add(cunning.dangerousGame());
		}
	}
	
	/**
	 * List of masteries that are applied before any items should be applied.
	 * Cunning Tree: Wanderer
	 * Resolve Tree: Unyielding, Explorer, Perseverence(2nd Half), Grasp of the Undying Dead
	 * 		
	 */
	public void applyUrgotMasteryAfterItems(MasterySet mastery, UrgotStats urgot)
	{
		if (mastery == MasterySet.BOND_BALANCED)
		{
			resolve.unyieldingArmor(urgot);
			resolve.unyieldingMR(urgot);
			resolve.perseveranceAfterItems(urgot);
		}
	}
	
	/**
	 * Ferocity Tree: Ferocity, Oppressor, Deathfire Touch
	 * Resolve Tree: Runic Armor
	 * @param mastery
	 * @param battle
	 */
	public void applyUrgotMasteryAfterBattle(MasterySet mastery, UrgotStats urgot,
			Battle battle)
	{
		if (mastery == MasterySet.THUNDERLORD_BALANCED)
		{
			ferocity.ferocity(battle);
			ferocity.oppressor(battle);
			masteryBenefits.add(cunning.thunder(urgot, battle));
			keystone = "Thunderlord's Decree";
		}
		if (mastery == MasterySet.DEATHFIRE_BALANCED)
		{
			ferocity.ferocity(battle);
			ferocity.oppressor(battle);
			
			masteryBenefits.add(ferocity.deathfireString(battle.getCastTime(), urgot));
			keystone = "Deathfire Touch";
			battle.adDamage(ferocity.deathfireDamage(battle.getCastTime(), urgot, battle));
		}	
	}
	
	public String getKeyStone() { return keystone; }
	public ArrayList<String> getBenefitsList() { return masteryBenefits; }
	public boolean benefitsIsEmpty() { return masteryBenefits.isEmpty(); }

}
