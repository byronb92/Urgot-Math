package masteries.resolve;

import urgot.UrgotStats;

public class Resolve03Veteran extends Mastery {

	public Resolve03Veteran() {
		super(3);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		urgot.addBonusHP(45);
		
	}

}
