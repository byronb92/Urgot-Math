package masteries.resolve;

import masteries.Mastery;
import urgot.UrgotStats;

/** Legendary Guardian 
 * Grants 0.6 / 1.2 / 1.8 / 2.4 / 3 armor and magic resistance for each nearby enemy champion. 
 */
public class Resolve05Guardian extends Mastery {

	private int alliesNear = 0;
	public Resolve05Guardian() {
		super(5);
	}

	public void setAlliesNear(int allies)
	{
		alliesNear = allies;
	}
	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		setMasteryDetails("Guardian Mastery Resistant Boost: "
				+ "Armor (" + (urgot.getTotalArmor() + (alliesNear * 3)) + 
				") MR (" + (urgot.getTotalMR() + (alliesNear*3)));
	}

}
