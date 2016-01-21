package masteries.cunning;

import calc.UniqueCalculator;
import masteries.resolve.Mastery;
import urgot.UrgotStats;

/** Wanderer: 3% MS out of combat. */
public class Cunning01Wanderer extends Mastery {

	public Cunning01Wanderer() {
		super(1);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		UniqueCalculator msCalc = new UniqueCalculator();
		double wandererBonus = msCalc.getMSBonus(urgot, 0.03);
		setMasteryDetails("3% MS out of combat. (" + wandererBonus + ")");
	}

}
