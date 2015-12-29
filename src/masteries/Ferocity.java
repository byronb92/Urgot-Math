package masteries;

import calc.BattleCalculator;
import urgot.UrgotStats;

public class Ferocity {

	/** Fury or Ferocity 
	 * Fury: Increases champion attack speed by 0.8 / 1.6 / 2.4 / 3.2 / 4%.
	 * Ferocity: Increases ability and spell damage by 0.4 / 0.8 / 1.2 / 1.6 / 2%.
	 */
	private void fury(UrgotStats urgot)
	{
		urgot.addBonusAS(0.04);
	}
	// TODO: Does this increase Urgot Q damage? Spellblade damage?
	// This should be applied after all battle combinations have been output.
	private void ferocity(BattleCalculator calc)
	{
		double increasedDaamge = calc.getADDamage() * 0.02;
		calc.adDamage(increasedDaamge);
	}
	
	/** Double Edged Sword vs. Feast
	 * MELEE CHAMPIONS: You deal 3% increased damage, take 1.5% increased damage from all sources.
	 * RANGED CHAMPIONS: You deal and take 2% increased damage from all sources.
	 * Feast: Killing a unit restores 20 health (25 second cooldown).
	 */
	// Currently hard-coded to only account for Urgot.
	private void doubleEdged(BattleCalculator calc)
	{
		double increasedDaamge = calc.getADDamage() * 0.02;
		calc.adDamage(increasedDaamge);
	}
	// TODO: Factor this into new field sustain.
	private void feast(){};

	// TODO: Does this count level 1.
	/** Vampirism vs Natural Talent 
	 * Vampirism: 2% Lifesteal & Spellvamp
	 * Natural Talent: 
	 * 		 0.55 attack damage per level (10 at level 18) 
	 *		 0.83 ability power per level (15 at level 18).
	 */
	private void vampirism(UrgotStats urgot)
	{
		urgot.addLifeSteal(0.02);
		urgot.addSpellVamp(0.02);
	}
	private void naturalTalent(UrgotStats urgot)
	{
		urgot.addBonusAPPerLevel(0.83);
		urgot.addBonusADPerLevel(0.55);
	}

	/** Bounty Hunter vs. Oppressor
	 * Bounty Hunter: Grants 1% increased damage for each UNIQUE enemy champion you kill. 
	 * 	(Your damage output increases by 1% each time you kill an enemy champion for the first time)
	 * Oppressor:  Grants 2.5% increased damage against units with impaired movement 
	 * 		(Airborne icon airborne, Slow icon slow, Stun icon stun, Root icon snare, Taunt icon taunt, Suppression icon suppression).
	 */
	// Computing for max bounty damage.
	private void bounty(BattleCalculator calc)
	{
		double increasedDaamge = calc.getADDamage() * 0.05;
		calc.adDamage(increasedDaamge);
	}
	private void oppressor(BattleCalculator calc)
	{
		double increasedDaamge = calc.getADDamage() * 0.025;
		calc.adDamage(increasedDaamge);
	}

	/** Battering Blows vs. Piercing Thoughts
	 * Battering Blows: 7% Armor Penetration
	 * Piercing Thoughts: 7% Magic Penetration
	 */
	private void battering(UrgotStats urgot)
	{
		urgot.addPercentArmorPen(0.07);
	}
	private void piercing(UrgotStats urgot)
	{
		urgot.addPercentMagicPen(0.07);
	}

	
	private void bloodlust(){};
	private void fervor(){};
	private void deathfire(){};
	/** Warlord's Bloodlust vs. Fervor of Battle + Deathfire Touch
	 * Warlord's: Your critical strikes against enemy champions heal you for 15% of the damage dealt on-hit and grant you 20% attack speed for 4 seconds (2 second cooldown).
	 * Fervor: You gain stacks of Fervor for 6 seconds whenever you damage an enemy champion, stacking up to 10 stacks, based on the type:
	 *		1 stack for ranged basic attacks (on-hit).
	 *		2 stacks for melee basic attacks (on-hit).
	 *		2 stacks for ability damage (2 second cooldown).
	 *		Each stack of Fervor adds 1.32 - 8.46 (based on level) bonus physical damage on-hit against champions.
	 *			0.9 + (0.42 * level)
	 * Deathfire Touch: Dealing ability damage to enemy champions applies a bleed, 
	 * 		dealing 1 (+6.25% bonus AD) (+2.5% AP) magic damage every half-second for a 
	 * 		duration based on their type.
	 * 		Single Target: 4 seconds for a total of 8 (+50% bonus AD) (+20% AP) magic damage.
	 *		Area of effect: 2 seconds for a total of 4 (+25% bonus AD) (+10% AP) magic damage.
	 *		Damage over time: 1 second for a total of 2 (+12.5% bonus AD) (+5% AP) magic damage.
	 * 
	 */
	
	// Urgot deathfire touch.
	// 5 seconds from E. -- 10 (+60.25% bonus AD) (+20.5% AP)
}
