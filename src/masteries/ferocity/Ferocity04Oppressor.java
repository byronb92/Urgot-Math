package masteries.ferocity;

import urgot.UrgotStats;

/**  Oppressor:  Grants 2.5% increased damage against units with impaired movement  */
public class Ferocity04Oppressor extends Mastery {

	public Ferocity04Oppressor() {
		super(4);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		urgot.addDamageAmplification(0.025);
		
	}

}
