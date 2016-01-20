package masteries.cunning;

import urgot.UrgotStats;

/** Buffs granted by jungle monsters last 15% longer, including epic monsters. */
public class Cunning02Runic extends Mastery {

	public Cunning02Runic() {
		super(2);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		setMasteryDetails("Red, blue, and Rift Herald lasts 18 more seconds. (2 min 18)\n"
				+ "Dragon and Baron last 27 more seconds. (3 mins 27 seconds)");
		
	}

}
