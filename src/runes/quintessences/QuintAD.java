package runes.quintessences;

import runes.Rune;
import urgot.UrgotStats;

public class QuintAD extends Rune {

	public QuintAD() {
		super("Attack Damage");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusAD(2.25);
		
	}

}
