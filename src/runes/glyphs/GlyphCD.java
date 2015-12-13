package runes.glyphs;

import runes.Rune;
import urgot.UrgotStats;

public class GlyphCD extends Rune {
	public GlyphCD()
	{
		super("Cooldown Reduction");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addCDR(0.83);
		
	}

}
