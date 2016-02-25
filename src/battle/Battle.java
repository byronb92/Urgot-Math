package battle;

public class Battle 
{
	private int spellsCast = 0;
	private double spellCastTime = 0;
	private double battleTime = 0;
	private int physicalAttacksDone = 0;
	
	private double physicalDamage = 0;
	private double magicDamage = 0;
	private double totalSpellDamage = 0;

	private double shieldStrength = 0;
	private double healingDone = 0;
	private double healingModifier = 0;  
	
	
	
	
	
	
	public Battle()
	{

	}
	
	/**
	 * Keeps track of the number of spells casts.
	 * Helps to perform logic on masteries/effects that depend on number of spells cast.
	 */
	public void addSpellCast()
	{
		spellsCast++;
	}
	
	public void addBattleTime(double time)
	{
		battleTime = battleTime + time;
	}
	
	/**
	 * Keeps track of the number of physical attacks and physical damage done.
	 * @param damage
	 */
	public void addPhysicalDamage(double damage)
	{
		physicalDamage = physicalDamage + damage;
		physicalAttacksDone++;
	}
	
	public void addMagicDamage(double damage)
	{
		magicDamage = magicDamage + damage;
	}
	
	public void addHealing(double damage)
	{
		healingDone = (healingDone + (damage + (damage * healingModifier)));
	}
	
	/**
	 * Keeps into account effects that increase healing.
	 * This accounts for items that are added in random order.
	 * E.G. Death's dance is added (heal 15% of damage dealt), then
	 * Spirit Visage is added (increases 20% of all healing)
	 * @param mod
	 */
	public void addHealingModifier(double mod)
	{
		// Case A: There has already been healing, but no modifier.
		//		Aa: There has already been healing, but there modifier is not zero.
		// Case B: There has not been healing, but no modifier.
		// Case Bb: There has not been healing, but the modifier is not zero.
		if (healingDone > 0 && healingModifier == 0)
		{
			healingDone = healingDone + healingDone*mod;
			healingModifier = mod;
		}
		else if (healingDone > 0 && healingModifier > 0)
		{
			healingDone = healingDone + healingDone*mod;
			healingModifier = healingModifier + (healingModifier * mod);
		}
		
		else if (healingDone == 0 && healingModifier == 0)
		{
			healingModifier = mod;
		}
		else if (healingDone == 0 && healingModifier > 0)
		{
			healingModifier = healingModifier + (healingModifier * mod);
		}
		
	}
	public void addSpellDamage(double damage)
	{
		totalSpellDamage = totalSpellDamage + damage;
	}
	
	
	public void addShieldAmount(double shield)
	{
		shieldStrength = shieldStrength + shield;
	}
	
	
	public void battleTimeFromCD(double spellTime)
	{
		spellCastTime = spellCastTime + spellTime;
	}
	
	public int getSpellsCast() { return spellsCast; }
	public double getBattleTime() { return battleTime; }
	public int getPhysicalAttacks() { return physicalAttacksDone; }
	public double getTotalDamage() { return magicDamage + physicalDamage; }
	public double getPhysicalDamage() { return physicalDamage; }
	public double getMagicDamage() { return magicDamage; }
	public double getSpellDamage() { return totalSpellDamage; }
	
	
	public double getHealingDone() { return healingDone; }
	public double getShieldPoints() { return shieldStrength; }


	public double getCastTime() { return spellCastTime; }


}
