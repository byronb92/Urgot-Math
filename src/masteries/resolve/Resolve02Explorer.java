package masteries.resolve;

import calc.UniqueCalculator;
import masteries.Mastery;
import urgot.UrgotStats;

/** +15 flat MS in brush and river.*/
public class Resolve02Explorer extends Mastery {

	public Resolve02Explorer() {
		super(1);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		double totalMS = UniqueCalculator.getMSBonus(urgot, 15);
		setMasteryDetails("Explorer: +15 MS in River/Brush. (" + totalMS + ")");
		
	}

}
