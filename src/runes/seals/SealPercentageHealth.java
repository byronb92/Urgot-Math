package runes.seals;

import runes.Rune;
import urgot.UrgotStats;

public class SealPercentageHealth extends Rune {

	public SealPercentageHealth() {
		super("Percentage Health");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusPercentHP(0.05);
		
	}

}
