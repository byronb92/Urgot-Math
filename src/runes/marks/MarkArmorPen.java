package runes.marks;

import runes.Rune;
import urgot.UrgotStats;

public class MarkArmorPen extends Rune {
	
	public MarkArmorPen() {
		super("Armor Penetration");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusArmorPen(1.28);
	}
	
}
