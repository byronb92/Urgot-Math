package runes.marks;

import runes.Rune;
import urgot.UrgotStats;

public class RuneArmPen extends Rune {
	private double penValue = 1.28;
	public RuneArmPen(String name) {
		super(name);
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusArmorPen(penValue);
		
	}

}
