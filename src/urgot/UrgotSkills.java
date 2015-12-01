package urgot;
import calc.BattleCalculator;

public class UrgotSkills 
{

	BattleCalculator battleManager;
	UrgotStats urgot;
	private int qSpellCasts = 0;
	private int wSpellCasts = 0;
	private int eSpellCasts = 0;
	//private int rSpellCasts = 0;
	private int numbOfAttacks = 0;
	
	public void clearSkillCasts()
	{
		qSpellCasts = 0;
		wSpellCasts = 0;
		eSpellCasts = 0;
		//rSpellCasts = 0;
		numbOfAttacks = 0;
	}
	
	public int getQCasts()
	{
		return qSpellCasts;
	}
	public UrgotSkills(BattleCalculator manager, UrgotStats urgot)
	{
		battleManager = manager;
		this.urgot = urgot;
	}
	/**
	 * Urgot's basic attacks and Acid Hunter reduce the 
	 * damage dealt by his target by 15% for 2.5 seconds.
	 */
	public void passiveZaunTouchedBoltAugmenter()
	{
		// Assumption: Default Urgot damage reduction is 15%.
	}
	
	/**
	 * ACTIVE: Urgot fires a missile in a line, dealing physical damage to the 
	 * first enemy it hits and refunding 20 mana if it kills its target.
	 * RANGE: 1000 / 1200 
	 * SPEED: 1550 
	 * COST: 40 MANA 
	 * COOLDOWN: 2
	 * PHYSICAL DAMAGE: 10 / 40 / 70 / 100 / 130 (+ 85% AD)
	 */
	public void qAcidHunter(int level)
	{
		battleManager.burnMana(40);
		if (qSpellCasts > 0)
		{
			battleManager.battleTimeFromCD(2 * (1-urgot.getCDR()));
		}
		qSpellCasts++;
		// +30 dmg per level.
		battleManager.adDamage((10 + (30*(level - 1)) ) +
				(urgot.getTotalAD() * 0.85));
		numbOfAttacks++;
	
	}
	
	/**
	 * ACTIVE: Urgot shields himself for up to 7 seconds, also causing his 
	 * basic attacks and Acid Hunter to Slow icon slow his target for 1.5 seconds 
	 * while the shield holds.
	 * COST: 55 / 60 / 65 / 70 / 75 MANA 
	 * COOLDOWN: 16 / 15 / 14 / 13 / 12
	 * SHIELD STRENGTH: 60 / 100 / 140 / 180 / 220 (+ 80% AP) (+ 8% maximum mana)
	 * SLOW: 20 / 25 / 30 / 35 / 40%
	 */
	public void wTerrorCapacitor(int level)
	{
		// Starting mana 55, Starting CD 16, Starting Shield Strength 60
		// +5 mana cost per level, -1 second CD per level, +40 Shield Per level

		battleManager.burnMana(55 + (5*(level - 1)));
		if (wSpellCasts > 0)
		{
			battleManager.battleTimeFromCD(
				(16 - (level - 1)) * (1-urgot.getCDR()) );
		}
		wSpellCasts++;
		battleManager.shieldStrength(60 + (40*(level - 1)) +
				(urgot.getBonusAP() * 0.8) + 
				(urgot.getTotalMana() * (0.08)));


	}
	
	/**
	 * ACTIVE: Urgot launches a corrosive charge to the target location, 
	 * dealing physical damage to all enemies hit over 5 seconds and reducing 
	 * their armor for the duration.
	 * RANGE: 900 / 150 
	 * COST: 50 / 55 / 60 / 65 / 70 MANA 
	 * COOLDOWN: 15 / 14 / 13 / 12 / 11
	 * PHYSICAL DAMAGE PER SECOND: 15 / 26 / 37 / 48 / 59 (+ 12% bonus AD)
	 * TOTAL PHYSICAL DAMAGE: 75 / 130 / 185 / 240 / 295 (+ 60% Bonus AD)
	 * ARMOR REDUCTION: 12 / 14 / 16 / 18 / 20% of target's armor
	 */
	public void eNoxianCorrosiveCharge(int level)
	{
		// Per Level Changes
		// +55 AD, +5 Mana, -1 CD, 0.02 Armor Reduction 
		battleManager.adDamage((75 + (55*(level - 1))) + 
				(urgot.getBonusAD() * 0.60));
		battleManager.burnMana(50 + (5*(level - 1)));
		if (eSpellCasts > 0)
		{
			battleManager.battleTimeFromCD((15 - (level - 1))
					* (1-urgot.getCDR()));
		}
		eSpellCasts++;
		numbOfAttacks = numbOfAttacks + 5; // DOT Damage, 1 tick per second.
		urgot.addArmReduc(0.12 + (0.02*(level - 1)));
	}
	
	
	/**
	 * ACTIVE: Urgot grants himself damage reduction for 5 seconds and channels 
	 * for 1 second, Suppression icon suppressing the target enemy champion 
	 * for the duration. Upon completing the channel, Urgot and his target 
	 * blink to each other's locations, allowing Urgot to ignore 
	 * unit collision for 1 second and Slow icon slowing the target by 40% for 3 seconds.
	 * RANGE: 550 / 700 / 850 
	 * COST: 100 MANA 
	 * COOLDOWN: 120 / 100 / 80
	 * DAMAGE REDUCTION: 30 / 40 / 50%
	 */
	public void rHyperKineticPositionReverser(int level)
	{
		battleManager.burnMana(100);
		urgot.addDamageReduc(0.30 + (0.10*(level - 1)));
	}
}
