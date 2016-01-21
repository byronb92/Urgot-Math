	package masteries.resolve;

import urgot.UrgotStats;

public class Resolve06Bond extends Mastery {

	public Resolve06Bond() {
		super(6);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		urgot.addDamageReduc(0.04);
		setMasteryDetails("Grants 4% reduced damage. In addition to that, "
				+ "6% of the damage that allied champions "
				+ "would take from enemy champions is dealt to you instead "
				+ "(cannot reduce you below 5% health).");
	}

}
