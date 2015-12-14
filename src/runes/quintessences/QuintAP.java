package runes.quintessences;

import runes.Rune;
import urgot.UrgotStats;

public class QuintAP extends Rune {
	public QuintAP()
	{
		super("Ability Power");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusAP(4.95);
		
	}

}
