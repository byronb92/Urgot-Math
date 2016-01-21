package masteries.resolve;

import urgot.UrgotStats;

/** Swiftness: 15% Tenacity/Slow Resist
 * 		Crowd control reduction stacks multiplicatively
 */
public class Resolve05Swiftness extends Mastery {

	public Resolve05Swiftness() {
		super(5);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		urgot.addTenacity(0.15);
		urgot.addSlowResist(0.15);
	}

}
