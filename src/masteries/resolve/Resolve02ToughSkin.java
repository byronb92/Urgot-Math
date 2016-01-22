package masteries.resolve;

import masteries.Mastery;
import urgot.UrgotStats;

public class Resolve02ToughSkin extends Mastery {

	public Resolve02ToughSkin() {
		super(2);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		setMasteryDetails("Reduces damage from champ and monster by 2.");
		
	}

}
