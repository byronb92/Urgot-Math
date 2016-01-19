package masteries.ferocity;

import urgot.UrgotStats;

/** Deathfire Touch: Dealing ability damage to enemy champions applies a bleed, 
 * dealing 1 (+6.25% bonus AD) (+2.5% AP) magic damage every half-second for a
 * duration based on their type. 
 * 	Single Target: 4 seconds for a total of 8 (+50% bonus AD) (+20% AP) magic damage.
 * 	Area of effect: 2 seconds for a total of 4 (+25% bonus AD) (+10% AP) magic damage.
 * 	Damage over time: 1 second for a total of 2 (+12.5% bonus AD) (+5% AP) magic damage.--
 */

public class Ferocity06Deathfire extends Mastery {
	private double secs;
	public Ferocity06Deathfire() {
		super(6);
	}

	public void setSecondsBurned(double seconds)
	{
		secs = seconds;
	}
	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		double scalingAD = urgot.getBonusAD() * 0.0625;
		double scalingAP = urgot.getBonusAP() * 0.025;
		
		double decimalForm = secs - (int)secs;
		double burnSeconds = 0;
		if (decimalForm < 0.5)
		{
			burnSeconds = (int)secs;
		}
		else
		{
			burnSeconds = (int)secs + 0.5;
		}
		double deathfireDamage = burnSeconds * (1 + scalingAD + scalingAP);
		
		setMasteryDetails("Deathfire Touch damage across " + burnSeconds + " seconds: (" 
				+ deathfireDamage + ")");
		
	}

}
