package runes.quintessences;

import runes.Rune;
import urgot.UrgotStats;

public class QuintMana extends Rune {

	public QuintMana() {
		super("Mana");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusMana(37.5);		
	}

}
