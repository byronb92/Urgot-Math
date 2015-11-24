package battle;
import java.util.ArrayList;

public class BattleCalculator 
{
	
	double physicalDamage = 0;
	double spellCastTime = 0;
	double shieldStrength = 0;
	int manaUsage = 0;
	
	ArrayList<Double> listDamageReduc;
	ArrayList<Double> listArmReduc;
	double armorPenetration;
	
	
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
	
	
	
	
	public double getADDamage() { return physicalDamage; }
	public double getManaUsage() { return manaUsage; }
	public double getShieldPoints() { return shieldStrength; }
	public double getCastTime() { return spellCastTime; }

}
