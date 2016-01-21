package masteries.cunning;

import masteries.resolve.Mastery;
import urgot.UrgotStats;

/** Grants 1.5% increased damage while no allied champions are nearby (800 range). */
public class Cunning02Assassin extends Mastery{

	private boolean isAllyInRange = false;
	public Cunning02Assassin() {
		super(2);
	}

	public void setAllyInRange(boolean bool)
	{
		isAllyInRange = bool;
	}
	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		if (isAllyInRange)
		{
			urgot.addDamageAmplification(1.5);
		}
		
	}

}
