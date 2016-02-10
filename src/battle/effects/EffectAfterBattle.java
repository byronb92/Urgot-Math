package battle.effects;

import battle.Battle;
import urgot.UrgotStats;

public abstract class EffectAfterBattle extends Effect {

	public EffectAfterBattle() {
		super("After Battle");
	}
	
	public abstract void runEffectCalculations(Battle battle, UrgotStats urgot);

}
