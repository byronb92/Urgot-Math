package masteries;

import calc.BattleCalculator;
import calc.UniqueCalculator;
import urgot.UrgotStats;

public class Resolve {
	/** Recovery: flat2hp per 5
	 *  Unyielding: 5% bonus armor and 5% bonus MR.
	 *  
	 */
	public void recovery(UrgotStats urgot)
	{
		urgot.addBonusHealthRegen(2);
	}
	
	public double unyieldingArmor(UrgotStats urgot)
	{
		return (urgot.getBonusArmor() + (urgot.getBonusArmor() * 0.05)); 
	}
	
	public double unyieldingMR(UrgotStats urgot)
	{
		return (urgot.getBonusMR() + (urgot.getBonusMR() * 0.05)); 
	}
	
	/** Explorer: +15 flat MS in brush and river.
	 *  Tough Skin: Reduces damage from champ and monster by 2.
	 */
	// Apply this after item stats applied.
	public double explorer(UrgotStats urgot)
	{
		UniqueCalculator calc = new UniqueCalculator();
		double rawSpeed = (urgot.getFlatMS() + 15) + (urgot.getFlatMS() * (0.30 + urgot.getPercentMS()));
		return calc.moveSpeedCalculator(rawSpeed);

	}
	
	public String toughSkin()
	{
		return "Reduces damage from champ and monster by 2.";
	}
	
	/** Runic Armor: 8% stronger shields + healing. (lifesteal, hp regen)
	 *  Veteran's Scars: Grants 45 bonus hp.
	 */
	public void runicArmor(UrgotStats urgot, BattleCalculator calc)
	{
		urgot.addBonusHealthRegen(urgot.getTotalHPRegen() * 0.08);
		urgot.addLifeSteal(urgot.getLifeSteal() * 0.08);
		urgot.addSpellVamp(urgot.getSpellVamp() * 0.08);
		urgot.addBonusHealthRegen(urgot.getTotalHPRegen() * 0.08);
	}
	
	public void veterans(UrgotStats urgot)
	{
		urgot.addBonusHP(45);
	}
	
	/** Insight: 15% reduced summoner spell cooldown.
	 *  Perseverance: +50% base hp regen, 200% when below 25% hp
	 */
	public String insight()
	{
		return "Flash cooldown: 255 seconds (4 minutes 15 seconds)."
				+ "Does not count Ionian Boot reduction.";
	}
	
	public void perseveranceBeforeItems(UrgotStats urgot)
	{
		urgot.addBonusHealthRegen(0.50);

	}
	
	public String perseveranceAfterItems(UrgotStats urgot)
	{
		return " 200% health regen when under 25% hp. (" +
				urgot.getBaseArmorFromLevel() * 1.50 + ")";
	}
	
	/** Swiftness: 15% Tenacity/Slow Resist
	 * 		Crowd control reduction stacks multiplicatively.
	 *  Guardian: Grants 0.6 / 1.2 / 1.8 / 2.4 / 3 armor and 
	 *  	magic resistance for each nearby enemy champion.
	 */
	public void swiftness(UrgotStats urgot)
	{
		urgot.addTenacity(0.15);
		urgot.addSlowResist(0.15);
	}
	
	public String guardian(UrgotStats urgot, int nearbyChamps)
	{
		return "Guardian Mastery Resistant Boost: Armor (" +
				(urgot.getTotalArmor() + (nearbyChamps * 3)) + 
				") MR (" + (urgot.getTotalMR() + (nearbyChamps*3));
	}
	

	/** Grasp of the Undying: 3% max hp dealt to opponent (4 sec cd) (heals for 3%)
	 * 		Ranged champions heal for 1.5% max hp.
	 *  Strength of the Ages: +300 perm hp / +20 perm hp for siege kills. +10hp near siege minions
	 *  Bond of Stone: Grants 3% reduced damage.
	 * 
	 */
	public double undyingGrasp(UrgotStats urgot)
	{
		return urgot.getTotalHP() * 0.03;
	}
	
	// ASSUMPTION: You kill every siege minion.
	// This 
	public int agesStrength(UrgotStats urgot, double gameTimeAfterFirstSiege)
	{
		double siegeMath = 0;
		siegeMath = (gameTimeAfterFirstSiege / 75);
		int siegeMinionsKilled = (int)siegeMath;
		return (siegeMinionsKilled * 30);
	}
	
	public String stoneBond()
	{
		return "3% reduced damage, 6% reduced damage with allies near.";
	}
}
