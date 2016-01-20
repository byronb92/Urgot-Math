package masteries.ferocity;

import masteries.cunning.Mastery;
import urgot.UrgotStats;

public class Ferocity02Feast extends Mastery {

	public Ferocity02Feast() {
		super(2);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		setMasteryDetails("80 health per minute "
				+ "(when killing a unit every 25 seconds)");
		
	}

}
