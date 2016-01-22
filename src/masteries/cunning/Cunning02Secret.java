package masteries.cunning;

import masteries.Mastery;
import urgot.UrgotStats;

/** Potions and elixirs last 10% longer. */
public class Cunning02Secret extends Mastery {

	public Cunning02Secret() {
		super(2);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		setMasteryDetails("Potions and elixirs last 10% longer. "
				+ "Potions turn into biscuits.\n"
				+ "Biscuits award 20 health and 10 mana on consumption.");
		
	}

}
