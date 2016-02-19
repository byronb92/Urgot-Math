package battle.dynamic;

import scenario.UrgotScenario;

public class UrgotVsEnemy {
	
	/**
	 * Computes real damage dealt to enemy after resistances.
	 * @param name
	 * @param armReduc_Percent
	 * @param armPen_Percent
	 * @param armPen_Flat
	 * @param enemyArmor
	 * @param enemyMR
	 * @param physicalDamage
	 * @param magicDamage
	 * @return
	 */
	public CompleteDamage damageVsEnemy(String name, double armReduc_Percent,
			double armPen_Percent, double armPen_Flat,
			double enemyArmor, double enemyMR, double physicalDamage, double magicDamage)
	{
		double trueEnemyArmor = getTrueEnemyArmor(armReduc_Percent, armPen_Percent,
				armPen_Flat, enemyArmor);
		return damageVsEnemy(name, physicalDamage, trueEnemyArmor, magicDamage, enemyMR);
	}
	
	public CompleteDamage damageVsEnemy(UrgotScenario sce, double enemyArmor,
			double enemyMR)
	{
		return collectPreDamageStatsFromScenario(sce, enemyArmor, enemyMR);
	}
	
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
	
	/**
	 * Finds out which scenario does the most damage to a specific target.
	 * @param sceA
	 * @param sceB
	 * @param enemyArmor
	 * @param enemyMR
	 * @return null if the damage is equal.
	 */
	public CompleteDamage findHighestRealDamageFromTwoScenarios(
			UrgotScenario sceA, UrgotScenario sceB,
			double enemyArmor, double enemyMR)
	{
		CompleteDamage dmgA = damageVsEnemy(sceA, enemyArmor, enemyMR);
		CompleteDamage dmgB = damageVsEnemy(sceB, enemyArmor, enemyMR);
		if (dmgA.getTotalDamage() > dmgB.getTotalDamage())
		{
			return dmgA;
		}
		else if (dmgA.getTotalDamage() < dmgB.getTotalDamage())
		{
			return dmgB;
		}
		return null;
	}
	
	
	/** Current assumption, no magic penetration. */
	private CompleteDamage collectPreDamageStatsFromScenario(UrgotScenario sce, 
			double enemyArmor, double enemyMR)
	{
		String scenarioName = sce.getScenarioName();
		double rawPhysicalDamage = sce.getBattleStats().getPhysicalDamage();
		double rawMagicDamage = sce.getBattleStats().getMagicDamage();
		
		double armorReduc_Percent = sce.getUrgotStats().getArmorReduc();
		double armorPen_Percent = sce.getUrgotStats().getPercentArmorPen();
		double armorPen_Flat = sce.getUrgotStats().getFlatArmorPen();
		
		double enemyTrueArmor = getTrueEnemyArmor(armorReduc_Percent,
				armorPen_Percent, armorPen_Flat, enemyArmor);
		double enemyTrueMR = enemyMR; // Magic penetration not yet incorporated.

		return damageVsEnemy(scenarioName, rawPhysicalDamage, enemyTrueArmor,
				rawMagicDamage, enemyTrueMR);
				
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
	private double getTrueEnemyArmor(double armorReduc_Percent,
			double armorPen_Percent, double armorPen_Flat, double enemyArmor)
	{

		double trueEnemyArmor = enemyArmor * armorReduc_Percent;
		trueEnemyArmor = trueEnemyArmor - (trueEnemyArmor * armorPen_Percent);
		trueEnemyArmor = trueEnemyArmor -  armorPen_Flat;
		double enemyPhysicalReduction = (100/(100+trueEnemyArmor));
		return enemyPhysicalReduction;
	}

}
