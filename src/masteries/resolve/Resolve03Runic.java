package masteries.resolve;

import masteries.Mastery;
import urgot.UrgotStats;

/** Runic Armor: 8% stronger shields + healing. (lifesteal, hp regen) */
public class Resolve03Runic extends Mastery {

	public Resolve03Runic() {
		super(3);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		urgot.addBonusHealthRegen(urgot.getTotalHPRegen() * 0.08);
		urgot.addLifeSteal(urgot.getLifeSteal() * 0.08);
		urgot.addSpellVamp(urgot.getSpellVamp() * 0.08);
		urgot.addBonusHealthRegen(urgot.getTotalHPRegen() * 0.08);

		
	}

}
