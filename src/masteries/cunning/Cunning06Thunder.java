package masteries.cunning;

import battle.effects.Thunderlords;
import masteries.Mastery;
import urgot.UrgotStats;

public class Cunning06Thunder extends Mastery {

	public Cunning06Thunder() {
		super(6);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		double thunderDamage = (10 * (urgot.getLevel()) + 
					(0.30 * urgot.getBonusAD() + 
					(0.10 * urgot.getBonusAP())));
		Thunderlords thunder = new Thunderlords();
		urgot.addEffect(thunder);
		setMasteryDetails("Thunderlod's Decree damage: " + thunderDamage);
		
	}

}
