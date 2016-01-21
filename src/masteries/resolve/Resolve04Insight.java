package masteries.resolve;

import urgot.UrgotStats;

/** Insight: 15% reduced summoner spell cooldown. */
public class Resolve04Insight extends Mastery {

	public Resolve04Insight() {
		super(4);

	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		setMasteryDetails("Flash cooldown: 255 seconds (4 minutes 15 seconds)."
				+ "Does not count Ionian Boot reduction.");
	}

}
