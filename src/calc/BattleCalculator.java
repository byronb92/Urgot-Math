package calc;
import java.util.ArrayList;

public class BattleCalculator 
{
	private double spellDamage = 0;
	private double physicalDamage = 0;
	private double magicDamage = 0;
	private double spellCastTime = 0;
	private double shieldStrength = 0;
	private double healingDone = 0;
	// Spirit Visage/Hextech Gunblade/Windspeaker's Blessing
	private double healingModifier = 0; 
	private int manaUsage = 0;
	
	private ArrayList<Double> listDamageReduc;
	private ArrayList<Double> listArmReduc;
	private double armorPenetration;
	
	
	double opponentArmor;
	
	public BattleCalculator()
	{
		listDamageReduc = new ArrayList<Double>();
		listArmReduc = new ArrayList<Double>();
	}
	
	public void resetBattle()
	{
		manaUsage = 0;
		physicalDamage = 0;
		shieldStrength = 0;
		spellCastTime = 0;
		listArmReduc.clear();
		listDamageReduc.clear();
		
		armorPenetration = 0;
		opponentArmor = 0;
	}
	
	public void adDamage(double damage)
	{
		physicalDamage = physicalDamage + damage;
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
		spellDamage = spellDamage + damage;
	}
	public void shieldStrength(double strength)
	{
		shieldStrength = strength;
	}
	
	public void burnMana(int mana)
	{
		manaUsage = manaUsage + mana;
	}
	
	public void battleTimeFromCD(double spellTime)
	{
		spellCastTime = spellCastTime + spellTime;
	}
	
	
	
	public void addArmorReduction(double armorReducValue)
	{
		//Double reducObj = new Double(armorReducValue);
		listArmReduc.add(armorReducValue);
	}
	/**
	 * Armor reduction is calculated multiplicatively.
	 * @return adjusted armor reduction value.
	 */
	public double getArmorReduc()
	{
		double runningReductionTotal = 0;
		if (!listArmReduc.isEmpty())
		{
			for(Double reductionValue: listArmReduc){
				if (runningReductionTotal == 0) 
				{
					runningReductionTotal = reductionValue;
				}
				else
				{
					runningReductionTotal = runningReductionTotal * reductionValue;
				}
			}
		}
		return runningReductionTotal;
	}
	
	public void addDamageReduc(double value)
	{
		listDamageReduc.add(value);
	}
	
	/**
	 * Damage reduction is calculated multiplicatively.
	 * @return damage reduction value.
	 */
	public double calculateDmgReduc()
	{
		double runningReductionTotal = 0;
		if (!listDamageReduc.isEmpty())
		{
			for(Double reductionValue: listDamageReduc){
				if (runningReductionTotal == 0) 
				{
					runningReductionTotal = reductionValue;
				}
				else
				{
					runningReductionTotal = runningReductionTotal * reductionValue;
				}
			}
		}
		return runningReductionTotal;
	}
	
	
	public double getHealingDone() { return healingDone; }
	public double getArmorPen()	   { return armorPenetration; }
	public double getMagicDamage() { return magicDamage; }
	public double getSpellDamage() { return spellDamage; }
	public double getADDamage() { return physicalDamage; }
	public double getManaUsage() { return manaUsage; }
	public double getShieldPoints() { return shieldStrength; }
	public double getCastTime() { return spellCastTime; }

}
