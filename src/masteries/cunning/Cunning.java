package masteries.cunning;

import battle.Battle;
import calc.UniqueCalculator;
import urgot.UrgotStats;

public class Cunning {
	
	 
	public double wanderer(UrgotStats urgot)
	{
		return (urgot.getTotalMS() + (urgot.getTotalMR() * 0.03));
	}
	
	public String savagery()
	{
		return "5 bonus damage to minions/monsters from autos/single target spells.";
	}

	/** Runic Affinity: Jungle/Baron buffs last 15% longer.
	 *  Secret Stash: Potions 10% longer, Biscuits (+20hp +10 mana on use)
	 *  Assassin: 1.5% increased dmg with no allied champions near. (800 range)
	 */
	public String runicAffinity()
	{
		return "Jungle/Baron buffs last 15% longer";
	}
	
	public String secretStash()
	{
		return "Potions last 10% longer, health potions are biscuits that give +20 hp, +10 mana on use.)";
	}
	
	/** Merciless: 5% increased damage to champions below 40% hp.
	 
	 */
	// All damage dealt modifiers stack multiplicatively
	public void merciless(UrgotStats urgot)
	{
		urgot.addDamageAmplification(0.05);
	}

	public String meditation(UrgotStats urgot)
	{
		return "1.5% missing mana every 5 seconds. When OOM, returns (" + (urgot.getTotalMana() * 0.015)
				+ ") mana.";
	}
	
	/** Bandit: Gain 1 Gold for each nearby minion killed by an ally. 
	 * Gain an additional 3 Gold (or 10 Gold if you're melee) when hitting an 
	 * enemy champion with a basic attack or a spell that applies on-hit effect 
	 * (5 second cooldown).
	 * Dangerous Game: Champion kills and assists restore 5% of missing health and 5% of missing mana.
	 */
	public double banditGoldRanged(int minutesPassed)
	{
		double perMinute = 3 * (12);
		double allyPassiveGold = 6 * ((minutesPassed * 60) / 30);
		return (perMinute * minutesPassed) + allyPassiveGold;
	}
	
	public double banditGoldMelee(int minutesPassed)
	{
		double perMinute = 10 * (12);
		double allyPassiveGold = 6 * ((minutesPassed * 60) / 30);
		return (perMinute * minutesPassed) + allyPassiveGold;
	}
	
	public String dangerousGame()
	{
		return "Champion kills and assists restore 5% of missing health/5% of missing mana.";
	}
	/** Precision: 5+ (0.5 x level armor pen) or amgic pen:
	 *  Intelligence: 45% CDR, 5% starting CDR.
	 */
	public void addPrecisionPen(UrgotStats urgot)
	{
		double pen = 5 + (0.5 * urgot.getLevel());
		urgot.addArmorPen(pen);
		urgot.addMagicPen(pen);
	}
	
	public void intelligence(UrgotStats urgot)
	{
		urgot.increaseCDRCap();
		urgot.addCDR(0.05);
	}
	
	/** Stormraider's Surge: Dealing 30% of a champion's maximum health within 
	 *  2 seconds grants you 35% bonus movement speed for 3 seconds (10 second cooldown).
	 *  Thunderlord's Decree: Marked for 5 seconds each attack. proc at 3 stacks.
	 *  At 3 stacks, the target takes 10 - 180 (based on level) + (30% bonus AD) + (10% AP) magic damage. 
	 *  	10 x (level)
	 *  Thunderlord's Decree can only be triggered once every 20 seconds.
	 *  
	 *  Windspeaker's Blessing
	 *  Your heals and shields are 10% stronger. Additionally, heals and shields on allies 
	 *  increase your target's armor by 5 - 22 (based on level) and magic resistance by 2.5 - 11 (based on level) for 3 seconds.
	 */
	public String storm(UrgotStats urgot)
	{
		UniqueCalculator calc = new UniqueCalculator();
		double rawSpeed = urgot.getFlatMS() + (urgot.getFlatMS() * (0.30 + urgot.getPercentMS()));
		double trueMS = calc.moveSpeedCalculator(rawSpeed);
		return "Dealing 30% of a champion's max hp within 20 seconds grants 35% (" + trueMS + ") "
				+ "movement speed for 3 seconds.";
	}
	
	public String thunder(UrgotStats urgot, Battle calc)
	{
		// TODO: This is supposed to be magic damage, not ad damage!
		double thunderDamage = (10 * (urgot.getLevel()) + (0.30 * urgot.getBonusAD() + (0.10 * urgot.getBonusAP())));
		calc.adDamage(thunderDamage);
		return "Thunderlod's Decree damage: " + thunderDamage;
	}
	
	public double windspeaker(Battle calc)
	{
		return (calc.getShieldPoints() + (calc.getShieldPoints() * 0.10));
	}
}	
