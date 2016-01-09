package calc;

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
		BattleCalculator calc = sce.getBattleStats();
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

}
