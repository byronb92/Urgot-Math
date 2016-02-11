package masteries.ferocity;

import battle.effects.DeathfireAfterAction;
import battle.effects.DeathfireAfterBattle;
import masteries.Mastery;
import urgot.UrgotStats;

/** Deathfire Touch: Dealing ability damage to enemy champions applies a bleed, 
 * dealing 1 (+6.25% bonus AD) (+2.5% AP) magic damage every half-second for a
 * duration based on their type. 
 * 	Single Target: 4 seconds for a total of 8 (+50% bonus AD) (+20% AP) magic damage.
 * 	Area of effect: 2 seconds for a total of 4 (+25% bonus AD) (+10% AP) magic damage.
 * 	Damage over time: 1 second for a total of 2 (+12.5% bonus AD) (+5% AP) magic damage.--
 */

public class Ferocity06Deathfire extends Mastery {
	public Ferocity06Deathfire() {
		super(6);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		
		
		DeathfireAfterAction deathfire = new DeathfireAfterAction();
		DeathfireAfterBattle deathfireBattle = new DeathfireAfterBattle();
		urgot.addEffect(deathfire);
		urgot.addEffect(deathfireBattle);
		setMasteryDetails("Dealing ability damage to enemy champions applies a bleed,\n "
				+ "    dealing 1 (+ 3.125% AP) (+ 7.5% bonus AD) magic damage "
				+ "\n     every half-second for a duration based on their type.");
		
	}

}
