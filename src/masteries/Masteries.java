package masteries;

import java.util.ArrayList;

import calc.BattleCalculator;
import urgot.UrgotStats;

public class Masteries {
	
	Ferocity ferocity;
	Cunning cunning;
	Resolve resolve;
	
	ArrayList<String> masteryBenefits;
	public String keystone;
	
	
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
	 *
	 * Cunning:
	 * Savagery, Secret Stash, Meditation, Dangerous Game
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
			cunning.meditation(urgot);
			masteryBenefits.add(cunning.dangerousGame());
			
			
		}
	}
	
	/**
	 * List of masteries that are applied before any items should be applied.
	 * Cunning Tree: Wanderer
	 * Resolve Tree: Unyielding, Explorer, Perseverence(2nd Half), Grasp of the Undying Dead
	 * 		
	 */
	public void applyUrgotMasteryAfterItems(MasterySet mastery)
	{
		
	}
	
	/**
	 * Ferocity Tree: Ferocity, Oppressor, Deathfire Touch
	 * Resolve Tree: Runic Armor
	 * @param mastery
	 * @param battle
	 */
	public void applyUrgotMasteryAfterBattle(MasterySet mastery, UrgotStats urgot,
			BattleCalculator battle)
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
	
	public ArrayList<String> getBenefitsList()
	{
		return masteryBenefits;
	}
	
	public boolean benefitsIsEmpty()
	{
		return masteryBenefits.isEmpty();
	}

}
