package runes.seals;

import runes.Rune;
import urgot.UrgotStats;

public class SealManaRegen extends Rune {
	public SealManaRegen()
	{
		super("Mana Regeneration");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusManaRegen(0.41);
		
	}
	

}
