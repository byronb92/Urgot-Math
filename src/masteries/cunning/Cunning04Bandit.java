package masteries.cunning;

import masteries.resolve.Mastery;
import urgot.UrgotStats;

/** Bandit: Gain 1 Gold for each nearby minion killed by an ally. 
 * 	Gain an additional 3 Gold (or 10 Gold if you're melee) when hitting an 
 * 	enemy champion with a basic attack or a spell that applies on-hit effect 
 * 	(5 second cooldown).
 */
public class Cunning04Bandit extends Mastery {

	public Cunning04Bandit() {
		super(4);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		setMasteryDetails("Gain 1 Gold for each nearby minion killed by an ally. "
				+ "Gain an additional 3 Gold (or 10 Gold if you're melee) "
				+ "when hitting an enemy champion with a basic attack or "
				+ "a spell that applies on-hit effect (5 second cooldown).");
		
	}

}
