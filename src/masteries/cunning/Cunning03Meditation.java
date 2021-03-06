package masteries.cunning;

import masteries.Mastery;
import urgot.UrgotStats;

/** Meditation: 1.5% missing mana every 5 seconds. */
public class Cunning03Meditation extends Mastery {

	public Cunning03Meditation() {
		super(3);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		setMasteryDetails("1.5% missing mana every 5 seconds. "
				+ "When OOM, returns (" + (urgot.getTotalMana() * 0.015)
				+ ") mana.");
	}

}
