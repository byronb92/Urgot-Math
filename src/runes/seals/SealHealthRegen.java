package runes.seals;

import runes.Rune;
import urgot.UrgotStats;

public class SealHealthRegen extends Rune {
	public SealHealthRegen()
	{
		super("Health Regeneration");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusHealthRegen(0.56);
		
	}
	

}
