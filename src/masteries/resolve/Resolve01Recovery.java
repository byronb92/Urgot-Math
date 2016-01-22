package masteries.resolve;

import masteries.Mastery;
import urgot.UrgotStats;

/** Recovery: flat2hp per 5 */
public class Resolve01Recovery extends Mastery {

	public Resolve01Recovery() {
		super(1);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		urgot.addFlatBonusHealthRegen(2);
	}

}
