package masteries.ferocity;

import masteries.Mastery;
import urgot.UrgotStats;

/** Piercing Thougths: Grants 1.4 / 2.8 / 4.2 / 5.6 / 7% magic penetration. */
public class Ferocity05Thoughts extends Mastery {

	public Ferocity05Thoughts() {
		super(5);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		urgot.addPercentMagicPen(0.07);
		
	}

}
