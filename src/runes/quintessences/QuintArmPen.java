package runes.quintessences;

import runes.Rune;
import urgot.UrgotStats;

public class QuintArmPen extends Rune {

	public QuintArmPen() {
		super("Armor Penetration");	
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addArmorPen(2.56);

	}

}
