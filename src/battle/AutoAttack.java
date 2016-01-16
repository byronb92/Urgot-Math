package battle;

import urgot.UrgotStats;

public class AutoAttack extends BattleAction {

	@Override
	public void runBattleCalculations(Battle battle, UrgotStats urgot) {
		battle.addPhysicalDamage(urgot.getTotalAD());
	}

}
