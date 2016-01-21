package masteries.cunning;

import masteries.resolve.Mastery;
import urgot.UrgotStats;

/**  Savagery: 5 bonus damage to minions/monsters from autos/single target spells. */
public class Cunning01Savagery extends Mastery {

	public Cunning01Savagery() {
		super(1);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		setMasteryDetails("5 bonus damage to minions/monsters "
				+ "from autos/single target spells.");
	}

}
