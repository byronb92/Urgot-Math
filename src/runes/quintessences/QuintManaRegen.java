package runes.quintessences;

import runes.Rune;
import urgot.UrgotStats;

public class QuintManaRegen extends Rune {

	public QuintManaRegen() {
		super("Mana Regeneration");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusManaRegen(1.25);
		
	}

}
