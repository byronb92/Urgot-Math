package masteries.ferocity;

import masteries.Mastery;
import urgot.UrgotStats;

/** Double-Edged Sword
 * MELEE CHAMPIONS: You deal 3% increased damage, take 1.5% increased damage from all sources.
 * RANGED CHAMPIONS: You deal and take 2% increased damage from all sources.
 */
public class Ferocity02Sword extends Mastery {

	private boolean isRanged = true;
	public Ferocity02Sword() {
		super(2);
	}

	public void setIsRanged(boolean bool)
	{
		isRanged = bool;
	}
	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		if (isRanged)
		{
			urgot.addDamageAmplification(0.02);
			urgot.addEnemyAmplification(0.02);
		}
		else
		{
			urgot.addDamageAmplification(0.03);
			urgot.addEnemyAmplification(0.015);
		}
	}

}
