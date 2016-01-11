package battle;

import calc.BattleCalculator;
import urgot.UrgotStats;

public abstract class BattleAction {
	public abstract void runBattleCalculations(BattleCalculator battle, UrgotStats urgot);

}
