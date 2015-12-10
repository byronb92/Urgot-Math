package calc;

import scenario.UrgotScenario;
import urgot.UrgotStats;

public class PassiveCalculator {
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



}
