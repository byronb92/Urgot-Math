package runes.quintessences;

import runes.Rune;
import urgot.UrgotStats;

public class QuintPercentHealth extends Rune {

	public QuintPercentHealth() {
		super("Percent Health");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusPercentHP(0.0125);
		
	}

}
