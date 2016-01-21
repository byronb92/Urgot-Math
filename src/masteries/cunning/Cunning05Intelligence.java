package masteries.cunning;

import masteries.resolve.Mastery;
import urgot.UrgotStats;

/** Intelligence: 45% CDR, 5% starting CDR. */
public class Cunning05Intelligence extends Mastery {

	public Cunning05Intelligence() {
		super(5);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		urgot.increaseCDRCap();
		urgot.addCDR(0.05);
	}

}
