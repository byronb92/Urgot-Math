package masteries.ferocity;

import masteries.Mastery;
import urgot.UrgotStats;

/** Grants 1.4 / 2.8 / 4.2 / 5.6 / 7% armor penetration. */
public class Ferocity05Blows extends Mastery {

	public Ferocity05Blows() {
		super(5);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		urgot.addPercentArmorPen(0.07);
		
	}

}
