package masteries.cunning;

import masteries.resolve.Mastery;
import urgot.UrgotStats;

public class Cunning06Wind extends Mastery {

	public Cunning06Wind() {
		super(6);	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		urgot.addShieldModifier(0.10);
		urgot.addHealModifier(0.10);
		
	}

}
