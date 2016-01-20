package masteries.cunning;

import calc.UniqueCalculator;
import urgot.UrgotStats;

/** Dealing 30% of a champion's maximum health within 2.5 seconds 
 * grants you 40% bonus movement speed and 75% slow resist for 3 seconds 
 * (10 second cooldown). 
 */
public class Cunning06Storm extends Mastery {

	public Cunning06Storm() {
		super(6);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		UniqueCalculator calc = new UniqueCalculator();
		double bonusMS = calc.getMSBonus(urgot, 0.40);
		
		double bonusSlowResist = urgot.getSlowResist()  + (urgot.getSlowResist() *0.75);
		setMasteryDetails("Stormraider's Surge: Grants 40% bonus movement speed (" + bonusMS 
				+ ") and 75% slow resist (" + bonusSlowResist + ")");
				
		
	}

}
