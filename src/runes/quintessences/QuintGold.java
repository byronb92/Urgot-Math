package runes.quintessences;

import runes.Rune;
import urgot.UrgotStats;

public class QuintGold extends Rune {
	private double goldPerTen = 1;
	public QuintGold()
	{
		super("Gold");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusGoldPerTen(goldPerTen);
		
	}
}
