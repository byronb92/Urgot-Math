package urgot;

public class UrgotStats {
	
	private int currentLevel		= 1;

	private double baseHP			= 586.52;
	private double baseAD			= 52.048;
	private double bonusBaseAD		= 0;
	private double baseArmor		= 24.544;
	private double baseMR			= 30.0;
	private double baseAS			= 0.64443298969;
	private double baseMana			= 312.4;
	private double baseManaRegen	= 8.59; // 8.59 per 5 seconds, additive.
	// TODO: Check over basemanaregen per level;

	private double baseHealthRegen  = 6.505;
	
	private double hpPerLevel		= 89.0;
	private double adPerLevel		= 5.2048;
	private double armPerLevel		= 3.3;
	private double asPerLevel		= 0.29;
	private double manaPerLevel		= 55.0;
	private double baseManaPerLevel = 0.65;
	private double baseHealthPerLevel = 0.6;
	
	// Runes, masteries, items
	private double bonusHP			= 0;
	private double bonusAD			= 0;
	private double bonusAP			= 0;
	private double bonusArmor		= 0;
	private double bonusMR			= 0;
	private double bonusAS			= 0;
	private double bonusManaRegen 	= 0;
	private double bonusMana	 	= 0;
	private double bonusHealthRegen = 0;
	

	private double moveSpeed		= 335;
	private double cdr;
	private double armorPen 		= 0;
	private double bonusArmorPen 	= 0;
	private double armorReduc		= 0;

	
	public UrgotStats()
	{
		
	}
	public UrgotStats(int initialLevel)
	{
		currentLevel = initialLevel;
	}
	

	public int getLevel() { return currentLevel; }
	public void setLevel(int level) { currentLevel = level; }	
	
	public double getBaseAD() { return baseAD; }
	public double getADPerLevel() { return adPerLevel; }
	public double getBaseADFromLevel() { return baseAD + (adPerLevel * (currentLevel -1)); }
	public double getBaseADFromItems() { return bonusBaseAD; }
	public double getBaseHPRegenFromLevel() { 
		return baseHealthRegen + (baseHealthPerLevel * (currentLevel - 1));	
	}
	public double getTotalHP() { return baseHP + (hpPerLevel * (currentLevel - 1)) + bonusHP; }
	public double getTotalAD() 	{ return (baseAD + (adPerLevel * (currentLevel - 1)) + bonusAD); }
	public double getTotalMR() { return baseMR + bonusMR; }
	public double getTotalAS() {
		return baseAS * (1 + (asPerLevel * (currentLevel - 1)) / 100);
	}
	public double getTotalMana() { return (baseMana + (manaPerLevel * (currentLevel - 1)) + bonusMana); }
	public double getCDR() 		{ return cdr; }
	
	public double getBonusAD()	{ return bonusAD; }
	public double getBonusAP() 	{ return bonusAP; }
	public double getBonusArmor() { return bonusArmor; }
	public double getBonusBaseAD() 	{ return bonusBaseAD; }
	public double getArmorPen() 	{ return armorPen; }
	public double getArmorReduc() 	{ return armorReduc; }

	public void addBonusAD(double value) { bonusAD = bonusAD + value; }
	public void addBonusArmor(double value) { bonusArmor = bonusArmor + value; }
	public void addBonusHP(double value) { bonusHP = bonusHP + value; }
	public void addBonusMR(double value) { bonusMR = bonusMR + value; }
	public void addBonusMana(double value) { bonusMana = bonusMana + value;}
	public void addCDR(double value) { cdr = cdr + value; }
	public void addBonusManaRegen(double value) { 
		bonusManaRegen = bonusManaRegen + value; 
	}
	public void addBonusHealthRegen(double value) { 
		bonusHealthRegen = bonusHealthRegen + value;
	}
	public void addArmReduc(double value) {
		if (armorReduc == 0)
		{
			armorReduc = 1 - value;
		}
		else
		{
			armorReduc = armorReduc * (1-value);
		}
	}
	public void addArmorPen(double value) { armorPen = armorPen + value; }
	public void addBonusArmorPen(double value) { bonusArmorPen = bonusArmorPen + value; }
	public void addBonusBaseAD(double value) { 
		bonusBaseAD = getBaseADFromLevel() + (getBaseADFromLevel() * value);
	}
}
