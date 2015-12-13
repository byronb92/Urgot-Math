package runes;

import runes.glyphs.Glyphs;
import runes.marks.Marks;
import runes.quintessences.Quintessences;
import runes.seals.Seals;

public class Runes {
	private BattleRune marks;
	private BattleRune seals;
	private BattleRune glyphs;
	private UtilityRune quints;
	private RuneFactory runeFactory;
	
	public Runes()
	{
		marks = new Marks();
		seals = new Seals();
		glyphs = new Glyphs();
		quints = new Quintessences();
		runeFactory = new RuneFactory();
	}
	
	public void addRune(RuneType rt, String rn)
	{
		if (rt == RuneType.MARK)
		{
			marks.addRune(runeFactory.getMark(rn));
		}
		else if (rt == RuneType.SEAL)
		{
			seals.addRune(runeFactory.getSeal(rn));
		}
		else if (rt == RuneType.GLYPH)
		{
			glyphs.addRune(runeFactory.getGlyph(rn));
		}
		else if (rt == RuneType.QUINT)
		{
			quints.addRune(runeFactory.getQuint(rn));
		}
	}

}
