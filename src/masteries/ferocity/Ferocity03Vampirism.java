package masteries.ferocity;

import urgot.UrgotStats;

/** Vampirism: 2% Lifesteal & Spellvamp */
public class Ferocity03Vampirism extends Mastery {

	public Ferocity03Vampirism() {
		super(3);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		urgot.addLifeSteal(0.02);
		urgot.addSpellVamp(0.02);
		
	}

}
