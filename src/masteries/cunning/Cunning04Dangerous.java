package masteries.cunning;

import masteries.Mastery;
import urgot.UrgotStats;

public class Cunning04Dangerous extends Mastery {

	public Cunning04Dangerous() {
		super(4);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		double maxHealthRegen = urgot.getTotalHP();
		double maxManaRegen = urgot.getTotalMana();
		setMasteryDetails("Champion kills and assists restore 5% of missing health/"
				+ "5% of missing mana.\n"
				+ "Max mana regen: " + maxManaRegen
				+ " Mana hp regen: " + maxHealthRegen);
		
	}

}
