package masteries.ferocity;

import masteries.cunning.Mastery;
import urgot.UrgotStats;

public class Ferocity04Bounty extends Mastery {

	private int champsKilled;
	public Ferocity04Bounty(int championsKilled) {
		super(4);
		champsKilled = championsKilled;
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		urgot.addDamageAmplification(0.01 * champsKilled);
		
	}

}
