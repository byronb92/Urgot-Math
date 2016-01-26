package masteries.ferocity;

import masteries.Mastery;
import urgot.UrgotStats;


/** Feast: Killing a unit restores 20 health (25 second cooldown). */
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
