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

	
	// TODO: Randuin's Omen
	// UNIQUE: Slows the movement speed of nearby enemy units by 35% for 4 seconds (60 second cooldown) (500 Range).
	// -10% damage taken from Critical strike icon Critical strikes.
	// TODO: Youmuu's Ghostblade
	// UNIQUE: Gain +40% attack speed and +20% movement speed for 6 seconds. 45 second cooldown.


}
