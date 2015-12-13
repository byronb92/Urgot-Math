package runes.marks;

import runes.Rune;
import urgot.UrgotStats;

public class MarkAttackDamage extends Rune {

	public MarkAttackDamage() {
		super("Attack Damage");
	}

	@Override
	public void addRuneStat(UrgotStats urgot) {
		urgot.addBonusAD(0.95);
	}

}
