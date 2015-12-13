package runes.marks;

import runes.Rune;
import urgot.UrgotStats;

public class MarkCritChance extends Rune {

	public MarkCritChance() {
		super("Critical Chance");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusCritChance(0.93);
		
	}

}
