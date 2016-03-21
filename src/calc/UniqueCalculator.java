package calc;

import battle.Battle;
import scenario.UrgotScenario;
import urgot.UrgotStats;

public class UniqueCalculator {
	
	
	/**
	 * Each scenario is based on a typical urgot E-Q combo.
	 * Computes enhanced damage of sheen usage.=
	 * Auto weaves are calculated by collective cast time.
	 * Cast time can be found in the BattleCalculator class.
	 * @param sce
	 * @param sheenVariation - "Sheen", "Iceborn Gauntlet", or "Trinity Force"
	 * Sheen = 100% Base Ad, Iceborn = 125% Base AD, Trinity = 200% Base AD
	 * @return
	 */
	public double computeSheenDamage(UrgotScenario sce, String sheenVariation)
	{
		Battle calc = sce.getBattleStats();
		UrgotStats urgot = sce.getUrgotStats();
		
		double battleTime = calc.getCastTime();
		double attackSpeed = urgot.getTotalAS();
		double baseAD = urgot.getBaseADFromLevel();
		double totalAD = urgot.getTotalAD();
		
		int autoWeaves = (int)(battleTime / attackSpeed);
		int sheenWeaves = (int)(calc.getCastTime() / 1.5);
		double sheenAutoDamage = 0;
		if (sheenVariation.equals("Sheen"))
		{
			sheenAutoDamage = (urgot.getTotalAD() + baseAD);
		}
		else if (sheenVariation.equals("Iceborn Gauntlet"))
		{
			sheenAutoDamage = (urgot.getTotalAD() + (1.25 * baseAD));
		}
		else if (sheenVariation.equals("Trinity Force"))
		{
			sheenAutoDamage = (urgot.getTotalAD() + (2 * baseAD));
		}
		double scenarioSheenDamage = (autoWeaves * totalAD) + (sheenWeaves * sheenAutoDamage);
		return scenarioSheenDamage;
	}
	public double getEnemyArmorAfterReductions(double enemyBaseArmor, double enemyBonusArmor,
			double armorReduc_Flat,
			double armorReduc_Percent, 
			double armorPen_Percent,
			double armorPenBonus_Percent,
			double armorPen_Flat
			)
	{
		double trueEnemyBaseArmor = enemyBaseArmor - (armorReduc_Flat/2);
		double trueEnemyBonusArmor = enemyBonusArmor - (armorReduc_Flat/2);

		trueEnemyBaseArmor = trueEnemyBaseArmor * (armorReduc_Percent);
		trueEnemyBonusArmor = trueEnemyBonusArmor * armorReduc_Percent;

		trueEnemyBaseArmor = trueEnemyBaseArmor - (trueEnemyBaseArmor * armorPen_Percent);
		trueEnemyBonusArmor = trueEnemyBonusArmor - (trueEnemyBonusArmor * armorPen_Percent);
		trueEnemyBonusArmor = trueEnemyBonusArmor - (trueEnemyBonusArmor * armorPenBonus_Percent);


		double enemyTrueArmor = trueEnemyBaseArmor + trueEnemyBonusArmor;
		enemyTrueArmor = enemyTrueArmor - armorPen_Flat;
		return enemyTrueArmor;
	}			
	
	public double getEnemyArmorLost(double enemyBaseArmor, double enemyBonusArmor,
			double armorReduc_Flat,
			double armorReduc_Percent, 
			double armorPen_Percent,
			double armorPenBonus_Percent,
			double armorPen_Flat
			)
	{
		double previousEnemyArmor = enemyBaseArmor + enemyBonusArmor;
		return previousEnemyArmor - getEnemyArmorAfterReductions(enemyBaseArmor, enemyBonusArmor,
				armorReduc_Flat, armorReduc_Percent, armorPen_Percent, armorPenBonus_Percent,
				armorPen_Flat);
	}

	
	/**
	 * Performs math for various passive movement speed increases.
	 * @param urgot
	 * @param moveSpeedIncrease
	 * @return
	 */
	public double getMSBonus(UrgotStats urgot, double moveSpeedIncrease)
	{
		double percentBonus = urgot.getPercentMS() + moveSpeedIncrease;
		return urgot.getFlatMS() + (urgot.getFlatMS() * percentBonus);
	}
	
	/**
	 * Performs math for various passive movement speed increases. (Flat)
	 * @param urgot
	 * @param moveSpeedIncrease
	 * @return
	 */
	public double getMSBonus(UrgotStats urgot, int moveSpeedIncrease)
	{
		double newFlatMS = urgot.getFlatMS() + 15;
		return newFlatMS  + (newFlatMS * urgot.getTotalMS());
	}
	
	public double moveSpeedCalculator(double rawSpeed)
	{
		if (rawSpeed >= 415 && rawSpeed  <= 490)
		{
			return rawSpeed * 0.8 + 83;
		}
		else if (rawSpeed > 490 )
		{
			return rawSpeed * 0.5 + 230;
		}
		
		else if (rawSpeed < 220)
		{
			return rawSpeed * 0.5 + 110;
		}
			
		return rawSpeed;
	}
	
	/**
	 * Calculates movement speed increase. Accounts for movement speed cap.
	 * @param speedToAdd
	 * @param currentSpeed
	 * @return
	 */
	public double moveSpeedCalculator(double speedToAdd, double currentSpeed)
	{
		double rawSpeed = speedToAdd + currentSpeed;
		if (rawSpeed >= 415 && rawSpeed  <= 490)
		{
			return rawSpeed * 0.8 + 83;
		}
		else if (rawSpeed > 490 )
		{
			return rawSpeed * 0.5 + 230;
		}
		
		else if (rawSpeed < 220)
		{
			return rawSpeed * 0.5 + 110;
		}
			
		return rawSpeed;
	}
	
	/**
	 * Calculates attack speed boost given by Youmuu's Ghostblade.
	 * @param baseAS
	 * @param bonusAS
	 * @return
	 */
	public double youmuuCalculatorAS(double baseAS, double bonusAS)
	{
		double youmuuAS = baseAS + (baseAS * (bonusAS+(0.40)));
		return youmuuAS;
	}

	
	/**
	 * Caclulates movement speed boost given by Youmuu's Ghostblade
	 * @param baseAS
	 * @param bonusAS
	 * @return
	 */
	public double youmuuCalculatorMS(double flatSpeed, double bonusSpeed)
	{
		// Youmuu's gives 20% increase in moveemnt speed.
		double rawSpeed = flatSpeed + (flatSpeed * (bonusSpeed + 0.20));
		double youmuuMS = moveSpeedCalculator(rawSpeed);
		return youmuuMS;
				
	}

}
