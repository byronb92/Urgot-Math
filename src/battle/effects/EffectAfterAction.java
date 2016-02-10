package battle.effects;

import battle.Battle;
import battle.BattleAction;
import urgot.UrgotStats;

public abstract class EffectAfterAction extends Effect {
	public EffectAfterAction() {
		super("After Action");
	}

	public abstract void runEffectCalculations(Battle battle, 
			BattleAction action, UrgotStats urgot);

}
