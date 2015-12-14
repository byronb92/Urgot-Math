package runes.quintessences;

import runes.Rune;
import urgot.UrgotStats;

public class QuintArmor extends Rune {
	public QuintArmor()
	{
		super("Armor");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusArmor(4.26);
		
	}
	
}
