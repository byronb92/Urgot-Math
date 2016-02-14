package runes;

import urgot.UrgotStats;

public class RuneManager {
	RuneSets runeSets;
	Runes runes;
	UrgotStats urgot;
	public RuneManager(UrgotStats urgot)
	{
		runes = new Runes();
		runeSets = new RuneSets();
		this.urgot = urgot;
	}
	
	public void setUpRunes(RuneSetup runeCode)
	{
		if (runeCode == RuneSetup.STANDARD)
		{
			runeSets.addStandardRunes(runes);
		}
		
		else if (runeCode == RuneSetup.ARMPENMARK)
		{
			runeSets.addArmorPenMarks(runes);
		}
		
		else if (runeCode == RuneSetup.ARMPENQUINT)
		{
			runeSets.addArmorPenQuints(runes);
		}
		
		else if (runeCode == RuneSetup.ARMPENFULL)
		{
			runeSets.addArmorPenFull(runes);
		}
	}

	public Runes getRunes()
	{
		return runes;
	}
	
	public void computeRuneStats()
	{
		getRunes().computeRuneStats(urgot);
	}

}
