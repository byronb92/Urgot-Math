package battle.actions;

import battle.Battle;
import urgot.UrgotStats;

/** Abstract class representing an action to be computed and recorded for Battle class */
public abstract class BattleAction {
	public abstract void runBattleCalculations(Battle battle, UrgotStats urgot);

}
