package battle.dynamic;

import java.util.HashMap;

/**
 * Class that handles the calculations to output damage to an enemy after resistances.
 * 
 * DamageVSEnemy collects all the values that affect enemy resistances.
 * These values are contained in a DynamicResistModifier class.
 * 
 * Using the DynamicResistModifier class, a CompleteDamage object is created
 * that will contain information about the reduced damage dealt.
 * @author bbeck799
 *
 */
public class DynamicDamageVSEnemy {
	

	public DynamicResistModifier resistModifierWithMap(String name, HashMap<String,Double> modMap)
	{
		DynamicResistModifier resistMod = new DynamicResistModifier(name);
		setArmorModificationsWithMap(resistMod, modMap);
		setMRModificationsWithMap(resistMod, modMap);
		return resistMod;
	}
	
	private void setArmorModificationsWithMap(DynamicResistModifier resistMod,
				HashMap<String,Double> modMap)
	{
		resistMod.setArmorModifications(modMap.get("Flat Armor Reduction"), 
				modMap.get("Percent Armor Reduction"), 
				modMap.get("Percent Armor Penetration"), 
				modMap.get("Percent Bonus Armor Penetration"), 
				modMap.get("Flat Armor Penetration"));
	}
	private void setMRModificationsWithMap(DynamicResistModifier resistMod, HashMap<String,Double> modMap)
	{
		resistMod.setMagicResistanceModifications(modMap.get("Flat Magic Reduction"), 
				modMap.get("Percent Magic Reduction"), 
				modMap.get("Percent Magic Reduction"), 
				modMap.get("Flat Magic Penetration"));

	}
	
	public DynamicResistModifier collectResistModifiers(String name,
			double armorReduc_Flat,double armorReduc_Percent,
			double armorPen_Percent, double armorPenBonus_Percent,
			double armorPen_Flat, 
			double magicReduc_Flat,double magicReduc_Percent,
			double magicPen_Percent, double magicPen_Flat)
	{
		DynamicResistModifier resistMod = new DynamicResistModifier(name);
		resistMod.setArmorModifications(armorReduc_Flat, armorReduc_Percent, 
				armorPen_Percent, armorPenBonus_Percent, armorPen_Flat);
		resistMod.setMagicResistanceModifications(
				magicReduc_Flat, magicReduc_Percent, magicPen_Percent, magicPen_Flat);
		return resistMod;
	}
	
	
	
	public DynamicCompleteDamage damageVsEnemy(DynamicResistModifier resistMod,
			double rawPhysicalDamage, double rawMagicDamage,
			double enemyBaseArmor, double enemyBonusArmor,
			double enemyBaseMR, double enemyBonusMR)
			
	{
		double realArmor = resistMod.getTrueEnemyArmor(enemyBaseArmor, enemyBonusArmor);
		double realMR = resistMod.getTrueEnemyMR(enemyBaseMR, enemyBonusMR);
		
		double realPhysicalDamageDealt = rawPhysicalDamage * (100 / (100 + realArmor));
		double realMagicDamageDealt = rawMagicDamage * (100 / (100 + realMR));
		return new DynamicCompleteDamage(resistMod.getName(),
				realPhysicalDamageDealt, realMagicDamageDealt, resistMod);
	}
	
	public DynamicCompleteDamage highestDamageAfterResists(
			DynamicCompleteDamage dmgA, DynamicCompleteDamage dmgB)
	{
		if (dmgA.getTotalDamage() > dmgB.getTotalDamage())
		{
			double comparedDamage = dmgA.getTotalDamage() - dmgB.getTotalDamage();
			String comparedWith = (dmgA.getName() + "(+" + comparedDamage +
					") over " + dmgB.getName());
			dmgA.setCompared(comparedWith, comparedDamage);
			return dmgA;
			
		}
		else if (dmgA.getTotalDamage() < dmgB.getTotalDamage())
		{
			double comparedDamage = dmgB.getTotalDamage() - dmgA.getTotalDamage();
			String comparedWith = dmgB.getName() + "(+" + comparedDamage +
					") over " + dmgA.getName();
			dmgB.setCompared(comparedWith, comparedDamage);
			return dmgB;
		}
		return null;
	}
	
	
	

}
