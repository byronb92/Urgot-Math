package battle.actions;

import battle.Battle;
import urgot.UrgotStats;


/** Object representation of an Auto Attack. */
public class AutoAttack extends BattleAction {

	@Override
	public void runBattleCalculations(Battle battle, UrgotStats urgot) {
		battle.addPhysicalDamage(urgot.getTotalAD());
	}

}
