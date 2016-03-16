package battle.actions.effects;

import battle.Battle;
import battle.actions.BattleAction;
import battle.dynamic.DynamicEnemyResistances;
import urgot.UrgotStats;

public abstract class EffectAfterAction extends Effect {
	
	public EffectAfterAction() {
		super("After Action");
	}

	public abstract void runEffectCalculations(Battle battle, 
			BattleAction action, UrgotStats urgot);
	
	public void runDynamicEffectCalculations(Battle battle, 
			BattleAction action, UrgotStats urgot, DynamicEnemyResistances enemy)
	{
		
	}

}
