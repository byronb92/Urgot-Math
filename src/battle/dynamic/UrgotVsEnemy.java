package battle.dynamic;


public class UrgotVsEnemy {
	
	/**
	 * Computes real damage done to an enemy after resistances.
	 * @param name - gives an identity to the numbers assigned.
	 * @param physicalDamage
	 * @param trueEnemyArmor
	 * @param magicDamage
	 * @param trueEnemyMR
	 * @return
	 */
	public CompleteDamage damageVsEnemy(String name, 
			double physicalDamage, double trueEnemyArmor,
			double magicDamage, double trueEnemyMR)
	{
		double physicalReduction = 100 / (100 + trueEnemyArmor);
		double magicReduction = 100 / (100 + trueEnemyMR);
		
		double realPhysicalDamage = physicalDamage * physicalReduction;
		double realMagicDamage = magicDamage * magicReduction;
		
		return new CompleteDamage(name, realPhysicalDamage, realMagicDamage);
	}
	
	public CompleteDamage damageVsEnemy(ResistanceModifiers resistMod,
			double rawPhysicalDamage, double rawMagicDamage,
			double enemyBaseArmor, double enemyBonusArmor,
			double enemyBaseMR, double enemyBonusMR)
			
	{
		double realArmor = resistMod.getTrueEnemyArmor(enemyBaseArmor, enemyBonusArmor);
		double realMR = resistMod.getTrueEnemyMR(enemyBaseMR, enemyBonusMR);
		
		double realPhysicalDamageDealt = rawPhysicalDamage * (100 / (100 + realArmor));
		double realMagicDamageDealt = rawMagicDamage * (100 / (100 + realMR));
		return new CompleteDamage(resistMod.getName(),
				realPhysicalDamageDealt, realMagicDamageDealt, resistMod);
	}
	

	

	

	

	
	public CompleteDamage findHighestRealDamageFromTwoDamageObjects(
			CompleteDamage dmgA, CompleteDamage dmgB)
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
	
	
	
	
	

	
	
	
	public ResistanceModifiers aggregrateResistanceMods(String name,
			double armorReduc_Flat,double armorReduc_Percent,
			double armorPen_Percent, double armorPenBonus_Percent,
			double armorPen_Flat, 
			double magicReduc_Flat,double magicReduc_Percent,
			double magicPen_Percent, double magicPen_Flat)
	{
		ResistanceModifiers resistMod = new ResistanceModifiers(name);
		resistMod.setArmorModifications(armorReduc_Flat, armorReduc_Percent, 
				armorPen_Percent, armorPenBonus_Percent, armorPen_Flat);
		resistMod.setMagicResistanceModifications(
				magicReduc_Flat, magicReduc_Percent, magicPen_Percent, magicPen_Flat);
		return resistMod;
	}
	

	

	
	/**
	 * Calculates enemy armor after reductions and penetrations.
	 * Order of Calculations:
	 * Armor reduction, flat
	 * Armor reduction, percentage
	 * Armor penetration, percentage
	 * Armor penetration, flat
	 * @param armorReduc_Percent
	 * @param armorPen_Percent
	 * @param armorPen_Flat
	 * @param enemyArmor
	 */


}
