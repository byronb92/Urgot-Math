package battle.actions.effects;

import battle.Battle;
import urgot.UrgotStats;

public class PassiveDeathDance extends EffectAfterBattle {

	@Override
	public void runEffectCalculations(Battle battle, UrgotStats urgot) {
		battle.addHealing(battle.getPhysicalDamage() * 0.15);

		
	}

}
