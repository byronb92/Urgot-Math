package runes.marks;

import runes.Rune;
import urgot.UrgotStats;

public class MarkHybridPen extends Rune{

	public MarkHybridPen() {
		super("Hybrid Penetration");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addFlatArmorPen(0.9);
		urgot.addMagicPen(0.62);
		
	}

}
