package runes;

public class RuneSets {
	
	public RuneSets()
	{
		
	}
	
	
	/**
	 * AD Marks, Armor Seals, MR Glyphs, AD Quints.
	 * @param runes
	 */
	public void addStandardRunes(Runes runes)
	{
		int marks = 9;
		int seals = 9;
		int glyphs = 9;
		int quints = 3;
		while(marks > 0) { runes.addRune(RuneType.MARK, "Attack Damage"); marks--; }
		while(seals > 0) { runes.addRune(RuneType.SEAL, "Armor"); seals--; }
		while(glyphs > 0) { runes.addRune(RuneType.GLYPH, "Magic Resist"); glyphs--; }
		while(quints > 0) { runes.addRune(RuneType.QUINT, "Attack Damage"); quints--; }

	}
	
	public void addArmorPenMarks(Runes runes)
	{
		int marks = 9;
		int seals = 9;
		int glyphs = 9;
		int quints = 3;
		while(marks > 0) { runes.addRune(RuneType.MARK, "Armor Penetration"); marks--; }
		while(seals > 0) { runes.addRune(RuneType.SEAL, "Armor"); seals--; }
		while(glyphs > 0) { runes.addRune(RuneType.GLYPH, "Magic Resist"); glyphs--; }
		while(quints > 0) { runes.addRune(RuneType.QUINT, "Attack Damage"); quints--; }

	}
	
	/**
	 * AD Marks, Armor Seals, MR Glyphs, AD Quints.
	 * @param runes
	 */
	public void addArmorPenQuints(Runes runes)
	{
		int marks = 9;
		int seals = 9;
		int glyphs = 9;
		int quints = 3;
		while(marks > 0) { runes.addRune(RuneType.MARK, "Attack Damage"); marks--; }
		while(seals > 0) { runes.addRune(RuneType.SEAL, "Armor"); seals--; }
		while(glyphs > 0) { runes.addRune(RuneType.GLYPH, "Magic Resist"); glyphs--; }
		while(quints > 0) { runes.addRune(RuneType.QUINT, "Armor Penetration"); quints--; }
	}
	
	public void addArmorPenFull(Runes runes)
	{
		int marks = 9;
		int seals = 9;
		int glyphs = 9;
		int quints = 3;
		while(marks > 0) { runes.addRune(RuneType.MARK, "Armor Penetration"); marks--; }
		while(seals > 0) { runes.addRune(RuneType.SEAL, "Armor"); seals--; }
		while(glyphs > 0) { runes.addRune(RuneType.GLYPH, "Magic Resist"); glyphs--; }
		while(quints > 0) { runes.addRune(RuneType.QUINT, "Armor Penetration"); quints--; }
	}
	
	
}
