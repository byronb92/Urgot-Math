package runes.quintessences;

import runes.Rune;
import urgot.UrgotStats;

public class QuintHealthRegen extends Rune {

	public QuintHealthRegen() {
		super("Health Regeneration");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusHealthRegen(2.7);
	}

}
