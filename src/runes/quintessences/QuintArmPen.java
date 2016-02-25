package runes.quintessences;

import runes.Rune;
import urgot.UrgotStats;

public class QuintArmPen extends Rune {

	public QuintArmPen() {
		super("Armor Penetration");	
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addFlatArmorPen(2.56);

	}

}
