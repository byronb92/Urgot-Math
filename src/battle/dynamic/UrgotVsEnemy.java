package battle.dynamic;

import scenario.UrgotScenario;

public class UrgotVsEnemy {
	/** 
	 * Order of Calculations:
	 * Armor reduction, flat
	 * Armor reduction, percentage
	 * Armor penetration, percentage
	 * Armor penetration, flat
	 */
	
	/**
	 * Total Raw Damage Dealt
	 * Total Magic Damage Dealt	   vs. Enemy MR
	 * Total Physical Damage Dealt vs. Enemy Armor
	 */
	public CompleteDamage damageVsCustomEnemy(UrgotScenario sce, double enemyArmor,
			double enemyMR, double enemyHP)
	{
		damageVsCustomEnemyWrapper(sce, enemyArmor, enemyMR, enemyHP);
		return null;
	}
	
	private void damageVsCustomEnemyWrapper(UrgotScenario sce, double enemyArmor,
			double enemyMr, double enemyHP)
	{
		double physicalDmgDone = sce.getBattleStats().getPhysicalDamage();
		double magicDmgDone = sce.getBattleStats().getMagicDamage();
		
		double armorReducPercent = sce.getUrgotStats().getArmorReduc();
		double armorPenPercent = sce.getUrgotStats().getPercentArmorPen();
		double armorPenFlat =  sce.getUrgotStats().getFlatArmorPen();
		
		damageVsCustomEnemy(physicalDmgDone, magicDmgDone, armorPenFlat, 
				armorPenPercent, armorReducPercent, enemyArmor, enemyMr, enemyHP);
	}
	
	

	public CompleteDamage damageVsCustomEnemy(double physicalDamage, double magicDamage,
			double armPenF, double armPenP, double armReducP,
			double enemyArmor, double enemyMR, double enemyHP)
	{
		// Armor reduction, percentage
		double trueEnemyArmor = enemyArmor - (enemyArmor * armReducP);
		// Armor penetration, percentage
		trueEnemyArmor = trueEnemyArmor - (trueEnemyArmor * armPenP);
		// Armor penetration, flat.
		trueEnemyArmor = trueEnemyArmor -  armPenF;
		
		
		double enemyPhysicalReduction = (100/(100+trueEnemyArmor));
		double enemyMagicReduction = (100/(100 + enemyMR));
		
		double realPhysicalDamageDone = physicalDamage * enemyPhysicalReduction;
		double realMagicDamageDone = magicDamage * enemyMagicReduction;
		
		return new CompleteDamage(realPhysicalDamageDone, realMagicDamageDone);
	}
	
	


	

}
