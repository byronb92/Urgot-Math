package battle;

import urgot.UrgotStats;


/** Replicates an auto attack, given the total ad */
public class AutoAttack extends BattleAction {

	@Override
	public void runBattleCalculations(Battle battle, UrgotStats urgot) {
		battle.addPhysicalDamage(urgot.getTotalAD());
	}

}
