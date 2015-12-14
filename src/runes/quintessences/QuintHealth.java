package runes.quintessences;

import runes.Rune;
import urgot.UrgotStats;

public class QuintHealth extends Rune {
	public QuintHealth()
	{
		super("Health");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusHP(26.0);
		
	}

}
