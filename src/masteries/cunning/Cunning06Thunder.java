package masteries.cunning;

import masteries.Mastery;
import urgot.UrgotStats;

public class Cunning06Thunder extends Mastery {

	public Cunning06Thunder() {
		super(6);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		// TODO: Add thunderlord's decree damage to battle calculator.
		double thunderDamage = (10 * (urgot.getLevel()) + 
					(0.30 * urgot.getBonusAD() + 
					(0.10 * urgot.getBonusAP())));
	
		setMasteryDetails("Thunderlod's Decree damage: " + thunderDamage);
		
	}

}
