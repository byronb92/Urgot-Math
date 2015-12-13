package runes.seals;

import runes.Rune;
import urgot.UrgotStats;

public class SealHealth extends Rune{

	public SealHealth() {
		super("Health");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusHP(8.0);
		
	}

}
