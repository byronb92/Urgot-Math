package runes;

import runes.glyphs.Glyphs;
import runes.marks.Marks;
import runes.quintessences.Quintessences;
import runes.seals.Seals;
import urgot.UrgotStats;

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
	
	public String getRunesAsString()
	{
		StringBuilder runeString = new StringBuilder();
		runeString.append("Marks" + "\n");
		runeString.append(marks.getRuneTypes());
		
		runeString.append("Seals" + "\n");
		runeString.append(seals.getRuneTypes());
		
		runeString.append("Glyphs" + "\n");
		runeString.append(glyphs.getRuneTypes());
		
		runeString.append("Quints" + "\n");
		runeString.append(quints.getRuneTypes());
		return runeString.toString();
	}
	
	public void computeRuneStats(UrgotStats urgot)
	{
		for (int i = 0 ; i < marks.getRunes().size() ; i++)
		{
			marks.getRunes().get(i).addRuneStat(urgot);
		}
		
		for (int i = 0 ; i < seals.getRunes().size() ; i++)
		{
			seals.getRunes().get(i).addRuneStat(urgot);
		}
		
		for (int i = 0 ; i < glyphs.getRunes().size() ; i++)
		{
			glyphs.getRunes().get(i).addRuneStat(urgot);
		}
		
		for (int i = 0 ; i < quints.getRunes().size() ; i++)
		{
			quints.getRunes().get(i).addRuneStat(urgot);
		}
	}

}
