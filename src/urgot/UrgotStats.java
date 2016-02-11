package urgot;

import battle.effects.Effect;
import battle.effects.EffectManager;
import calc.UniqueCalculator;

public class UrgotStats {
	
	private int currentLevel		= 1;


	private double baseAD			= 52.048;
	private double baseArmor		= 24.544;
	private double baseMR			= 30.0;
	private double baseAS			= 0.64443298969;
	
	private double baseHP			= 586.52;
	private double baseMana			= 312.4;
	private double baseHealthRegen  = 6.505;
	private double baseManaRegen	= 8.59; 	// 8.59 per 5 seconds, additive.

	private double adPerLevel				= 5.2048;
	private double armPerLevel				= 3.3;
	private double asPerLevel				= 0.029;
	
	private double hpPerLevel				= 89.0;
	private double manaPerLevel				= 55.0;
	private double baseManaRegenPerLevel 	= 0.65;
	private double baseHealthRegenPerLevel 	= 0.6;
		

	
	// Runes, masteries, items
	private double bonusAD			= 0;
	private double bonusAP			= 0;
	private double bonusArmor		= 0;
	private double bonusMR			= 0;
	private double bonusAS			= 0;
	
	private double bonusHP			= 0;
	private double bonusPercentHP 	= 0;
	private double bonusMana	 	= 0;

	private double flatHealthRegen  = 0;
	private double bonusHealthRegen = 0;
	private double bonusManaRegen 	= 0;
	private double bonusArmorPen 	= 0;		// Last Whisper changes in preseason.
	
	private double bonusBaseAD		= 0;		// Sterak's gage.
	private double bonusADPerLevel	= 0;
	private double bonusAPPerLevel	= 0;
	
	private double lifeSteal		= 0;
	private double spellVamp		= 0;
	private double critChance		= 0;

	private double flatMS			= 335;
	private double percentMS		= 0;

	
	private double healModifier 	= 0;
	private double shieldModifier	= 0;
	private double spellDamageAmp 	= 0;
	private double enemyDamageAmp	= 0;		// Double-edged Sword Mastery
	private double damageAmp		= 0;
	private double damageReduc		= 0.85;		// Urgot passive.
	private double flatArmorPen 	= 0;
	private double flatMagicPen		= 0;
	private double percentArmorPen  = 0;
	private double percentMagicPen	= 0;
	private double armorReduc		= 0;
	
	private double tenacity			= 0;
	private double slowResist		= 0;
	private double cdr				= 0;	
	private boolean intelligenceCDR = false;


	private EffectManager effects;

	public UrgotStats()
	{
		currentLevel = 1;
		effects = new EffectManager();
	}
	public UrgotStats(int initialLevel)
	{
		currentLevel = initialLevel;
		effects = new EffectManager();
	}
	public void setLevel(int level) { currentLevel = level; }	
	public int getLevel() { return currentLevel; }
	
	
	// Core bonus stats.
	public double getBonusAD()	{ return bonusAD; }
	public double getBonusAP() 	{ return bonusAP + (bonusAPPerLevel * (currentLevel - 1)); }
	public double getBonusArmor() { return bonusArmor; }
	public double getBonusMR() { return bonusMR; }
	public double getBonusAS() { return bonusAS; }
	

	// Base Stats
	public double getBaseAD() { return baseAD; }
	public double getBaseADFromLevel() { 
		return (baseAD + (adPerLevel * (currentLevel -1))) + 
			(baseAD + (adPerLevel * (currentLevel -1))) * bonusBaseAD; 
	}
	public double getBaseADFromItems() { return bonusBaseAD; }
	public double getBaseArmorFromLevel() { return baseArmor + (armPerLevel * (currentLevel - 1)); }
	public double getBaseAS() { return baseAS; }
	public double getBaseHPRegenFromLevel() { 
		return baseHealthRegen + (baseHealthRegenPerLevel * (currentLevel - 1));	
	}
	public double getBaseManaRegenFromLevel() { 
		return baseManaRegen + (baseManaRegenPerLevel * (currentLevel - 1));	
	}
	public double getBonusBaseAD() 	{ return bonusBaseAD; }

	// Total Stats

	public double getTotalAD() 	{ 
		return (baseAD + (adPerLevel * (currentLevel - 1)) + bonusAD + (bonusADPerLevel * (currentLevel - 1))); 
	}
	public double getTotalArmor() { return getBaseArmorFromLevel() + bonusArmor; }
	public double getTotalMR() { return baseMR + bonusMR; }
	public double getTotalAS() {
		return baseAS + (baseAS * (asPerLevel * (currentLevel - 1))) + (baseAS * bonusAS);
	}
	
	public double getTotalHP() { 
		return (baseHP + (hpPerLevel * (currentLevel - 1)) + bonusHP) + 
			(bonusPercentHP * (baseHP + (hpPerLevel * (currentLevel - 1)) + bonusHP)); 
	}
	public double getTotalMana() { return (baseMana + (manaPerLevel * (currentLevel - 1)) + bonusMana); }
	public double getTotalHPRegen() { 
		return getBaseHPRegenFromLevel() + bonusHealthRegen; 
	}
	public double getTotalManaRegen() { 
		return getBaseManaRegenFromLevel() + (getBaseManaRegenFromLevel() * bonusManaRegen);
	}
	public double getTotalMS() { 
		UniqueCalculator unique = new UniqueCalculator();
		return unique.moveSpeedCalculator((flatMS) + (flatMS * percentMS));
	}
	
	public double getLifeSteal() { return lifeSteal; } 
	public double getSpellVamp() { return spellVamp; }
	
	public double getFlatMS() { return flatMS; }
	public double getPercentMS() { return percentMS; }
	
	public double getArmorReduc() 	{ return armorReduc; }
	public double getDamageAmp()	{ return damageAmp; }
	public double getDamageReduc() 	{ return damageReduc; }
	public double getFlatArmorPen() 	{ return flatArmorPen; }
	public double getPercentArmorPen() { return percentArmorPen; }
	public double getBonusCrit()	{ return critChance; }
	public double getResistanceReduction(double resistValue)
	{
		if (resistValue >= 0)
		{
			return (100) / (100 + resistValue);
		}
		else
		{
			return (2) - ((100)/(100 - resistValue));
		}
	}


	public double getTenacity() { return tenacity; }
	public double getSlowResist() { return slowResist; }	
	public double getCDR() 		{ return cdr; }
	// Intelligence mastery gives you a max of 45% cdr.
	public void increaseCDRCap() { intelligenceCDR = true; }
	
	
	
	
	
	
	// Priority Stats.
	public void addBonusAD(double value) { bonusAD = bonusAD + value; }
	public void addBonusAP(double value) { bonusAP = bonusAP + value; }
	public void addBonusArmor(double value) { bonusArmor = bonusArmor + value; }
	public void addBonusMR(double value) { bonusMR = bonusMR + value; }
	public void addBonusAS(double value) { bonusAS = bonusAS + value; }
	
	public void addBonusHP(double value) { bonusHP = bonusHP + value; }
	public void addBonusMana(double value) { bonusMana = bonusMana + value;}
	public void addFlatBonusHealthRegen(double value) { flatHealthRegen = flatHealthRegen + value; }
	public void addBonusHealthRegen(double value) { bonusHealthRegen = bonusHealthRegen + value; }
	public void addBonusManaRegen(double value) { bonusManaRegen = bonusManaRegen + value; }
	public void addBonusPercentHP(double value) { bonusPercentHP = bonusPercentHP + value; }
	
	// As of patch 5.24, Sterak's Gauge only affects this.
	public void addBonusBaseAD(double value) { bonusBaseAD = getBaseADFromLevel() + (getBaseADFromLevel() * value);}
	public void addBonusADPerLevel(double value) { bonusADPerLevel = bonusADPerLevel + value; }
	public void addBonusAPPerLevel(double value) { bonusAPPerLevel = bonusAPPerLevel + value; }

	
	public void addHealModifier(double modify) { 
		if (healModifier == 0)
		{
			healModifier = 1 - modify;
		}
		else
		{
			healModifier= healModifier* (1-modify);
		}
	}
	
	public void addShieldModifier(double modify) { 
		if (shieldModifier == 0)
		{
			shieldModifier = 1 - modify;
		}
		else
		{
			shieldModifier= shieldModifier * (1-modify);
		}
	}
	public void addLifeSteal(double value) { lifeSteal = lifeSteal + value; }
	public void addSpellVamp(double value) { spellVamp = spellVamp + value; }
	public void addBonusCritChance(double value) { critChance = critChance + value; }
	public void addFlatMoveSpeed(double value) { flatMS = flatMS + value; }
	public void addPercentMoveSpeed(double value) { percentMS = percentMS + value; }
	
	// Damage Amplification/Reduction
	public void addBonusArmorPen(double value) { bonusArmorPen = bonusArmorPen + value; }
	public void addPercentArmorPen(double value) { percentArmorPen = percentArmorPen + value; }
	public void addPercentMagicPen(double value) { percentMagicPen = percentMagicPen + value; }
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
	public void addArmorPen(double value) { flatArmorPen = flatArmorPen + value; }
	public void addMagicPen(double value) { flatMagicPen = flatMagicPen + value; }
	public void addDamageReduc(double value) {
		if (damageReduc == 0)
		{
			damageReduc  = 1 - value;
		}
		else
		{
			damageReduc  = damageReduc  * (1-value);
		}
	}
	// TODO: Test math of damage amplifcation.
	public void addEnemyAmplification(double value)
	{
		if (enemyDamageAmp == 0)
		{
			enemyDamageAmp = 1 - (1-value);
		}
		else
		{
			enemyDamageAmp = (1 - enemyDamageAmp) * (1-value);
		}
	}
	
	public void addDamageAmplification(double value)
	{
		if (damageAmp == 0)
		{
			damageAmp = 1 - (1-value);
		}
		else
		{
			damageAmp = (1 - damageAmp) * (1-value);
		}
	}
	
	public void addSpellAmplification(double value)
	{
		if (spellDamageAmp == 0)
		{
			spellDamageAmp = 1 - (1-value);
		}
		else
		{
			spellDamageAmp = (1 - spellDamageAmp) * (1-value);
		}
	}
	
	public void addTenacity(double value)
	{
		if (tenacity == 0)
		{
			tenacity = value;
		}
		else 
		{
			tenacity = tenacity + (tenacity * value);
		}
	}
	public void addSlowResist(double value)
	{
		if (slowResist == 0)
		{
			slowResist = value;
		}
		else 
		{
			slowResist = slowResist + (slowResist * value);
		}
	}
	
	public void addCDR(double value) { 
		cdr = cdr + value; 
		if (cdr > 0.45 && intelligenceCDR)
		{
			cdr = 0.45;
		}
		else if (cdr > 0.40 && !intelligenceCDR)
		{
			cdr = 0.40;
		}
	}
	
	
	public void addEffect(Effect effect)
	{
		effects.addEffect(effect);
	}
	
	public EffectManager getEffects()
	{
		return effects;
	}

}
