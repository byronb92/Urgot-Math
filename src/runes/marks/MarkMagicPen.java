package runes.marks;

import runes.Rune;
import urgot.UrgotStats;

public class MarkMagicPen extends Rune {

	public MarkMagicPen() {
		super("Magic Penetration");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addFlatMagicPen(0.87);	
	}

}
