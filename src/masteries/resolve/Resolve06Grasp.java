package masteries.resolve;

import urgot.UrgotStats;

/** Grasp of the Undying: 3% max hp dealt to opponent (4 sec cd) (heals for 3%)
 * Ranged champions heal for 1.5% max hp.
 */
public class Resolve06Grasp extends Mastery {

	public Resolve06Grasp(int tier) {
		super(6);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		setMasteryDetails("Grasp of Undying Dead: Deal and heal " 
				+ urgot.getTotalHP() * 0.03);
	}

}
