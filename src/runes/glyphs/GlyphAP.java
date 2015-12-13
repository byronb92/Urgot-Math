package runes.glyphs;

import runes.Rune;
import urgot.UrgotStats;

public class GlyphAP extends Rune {
	public GlyphAP()
	{
		super("Ability Power");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusAP(1.19);
		
	}

}
