package masteries.ferocity;

import urgot.UrgotStats;

public class Ferocity05Blows extends Mastery {

	public Ferocity05Blows() {
		super(5);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		urgot.addPercentArmorPen(0.07);
		
	}

}
