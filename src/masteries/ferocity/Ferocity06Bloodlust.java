package masteries.ferocity;

import masteries.cunning.Mastery;
import urgot.UrgotStats;

/** Warlord's: Your critical strikes against enemy champions 
 * heal you for 15% of the damage dealt on-hit and 
 * grant you 20% attack speed for 4 seconds (2 second cooldown).
 * @author byronb92
 *
 */
public class Ferocity06Bloodlust extends Mastery {

	public Ferocity06Bloodlust() {
		super(6);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		double warlordAtkSpeedIncrease = urgot.getBaseAS() * 0.20;
		double totalWarlordAtkSpeedInc = urgot.getTotalAS() + warlordAtkSpeedIncrease;
		setMasteryDetails("Critical strikes on enemy champs heal for 15% damage"
				+ "and grant 20% attack speed. (" + totalWarlordAtkSpeedInc + ")");
		
		
		
	}

}
