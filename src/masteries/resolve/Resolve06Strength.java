package masteries.resolve;

import masteries.Mastery;
import urgot.UrgotStats;

/** Strength of the Ages: +300 perm hp / +20 perm hp for siege kills. 
 * +10hp near siege minions */
public class Resolve06Strength extends Mastery {

	public Resolve06Strength(int tier) {
		super(6);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		setMasteryDetails("Strength of the Ages: +300 perm hp / +20 perm hp "
				+ "for siege kills. +10hp near siege minions");
		
	}

}
