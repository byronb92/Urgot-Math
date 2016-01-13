package battle;

import calc.BattleCalculator;
import urgot.UrgotStats;

public class AutoAttack extends BattleAction {

	@Override
	public void runBattleCalculations(BattleCalculator battle, UrgotStats urgot) {
		battle.addPhysicalDamage(urgot.getTotalAD());
	}

}
