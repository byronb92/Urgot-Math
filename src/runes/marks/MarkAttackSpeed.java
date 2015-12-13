package runes.marks;

import runes.Rune;
import urgot.UrgotStats;

public class MarkAttackSpeed extends Rune {

	public MarkAttackSpeed() {
		super("Attack Speed");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusAS(0.017);
		
	}

}
