package masteries.cunning;

import masteries.resolve.Mastery;
import urgot.UrgotStats;

/** Precision: 3.0 + (0.3 x level) armor pen and magic pen: */
public class Cunning05Precision extends Mastery {

	public Cunning05Precision() {
		super(5);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		double levelScaling = 0.3 * urgot.getLevel();
		urgot.addArmorPen(3 + levelScaling);
		urgot.addMagicPen(3 + levelScaling);
		
		
	}

}
