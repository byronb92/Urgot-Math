package masteries.cunning;

import urgot.UrgotStats;

public class Cunning03Merciless extends Mastery {

	private boolean isOpponentLow = true;
	public Cunning03Merciless() {
		super(3);
	}

	public void setIsOpponentLow(boolean bool)
	{
		isOpponentLow = bool;
	}
	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		if (isOpponentLow)
		{
			urgot.addDamageAmplification(0.05);
		}
		setMasteryDetails("Merciless: 5% increased damage to champions below 40% hp");
		
	}

}
