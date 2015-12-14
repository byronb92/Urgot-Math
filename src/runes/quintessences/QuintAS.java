package runes.quintessences;

import runes.Rune;
import urgot.UrgotStats;

public class QuintAS extends Rune {

	public QuintAS() {
		super("Attack Speed");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusAS(0.045);
		
	}

}
