package masteries.ferocity;

import masteries.resolve.Mastery;
import urgot.UrgotStats;

public class Ferocity05Thoughts extends Mastery {

	public Ferocity05Thoughts() {
		super(5);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		urgot.addPercentMagicPen(0.07);
		
	}

}
