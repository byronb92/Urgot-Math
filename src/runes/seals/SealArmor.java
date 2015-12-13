package runes.seals;

import runes.Rune;
import urgot.UrgotStats;

public class SealArmor extends Rune {

	public SealArmor() {
		super("Armor");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusArmor(1.0);
		
	}

}
