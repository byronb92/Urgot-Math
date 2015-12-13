package runes.glyphs;

import runes.Rune;
import urgot.UrgotStats;

public class GlyphMR extends Rune {

	public GlyphMR() {
		super("Magic Resist");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusMR(1.34);
	}

}
