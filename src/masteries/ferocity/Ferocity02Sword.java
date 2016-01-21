package masteries.ferocity;

import masteries.resolve.Mastery;
import urgot.UrgotStats;

/** Double Edged Sword
 * MELEE CHAMPIONS: You deal 3% increased damage, take 1.5% increased damage from all sources.
 * RANGED CHAMPIONS: You deal and take 2% increased damage from all sources.
 */
public class Ferocity02Sword extends Mastery {

	public Ferocity02Sword() {
		super(2);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		// TODO Differentiate between melee and ranged.
		urgot.addDamageAmplification(0.02);
		urgot.addEnemyAmplification(0.02);
	}

}
