package runes;

import urgot.UrgotStats;

public abstract class Rune {
	private String runeName;
	public Rune(String name)
	{
		runeName = name;
	}
	public String getRuneName() {
		return runeName;
	}

	
	public abstract void addRuneStat(UrgotStats urgot);
	
}
