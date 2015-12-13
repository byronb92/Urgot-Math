package runes.glyphs;

import runes.Rune;
import urgot.UrgotStats;

public class GlyphMana extends Rune {
	public GlyphMana()
	{
		super("Mana");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusMana(11.25);

	}

}
