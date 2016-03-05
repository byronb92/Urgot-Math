package battle.actions.effects;

import battle.Battle;
import battle.actions.BattleAction;
import urgot.UrgotStats;

public class Thunderlords extends EffectAfterAction {
	// TODO: Only make it proc after 3 attacks.s
	private boolean isProc = false;
	public Thunderlords() {
		super();
		setEffectName("Thunderlord's");
	}

	@Override
	public void runEffectCalculations(Battle battle, BattleAction action, UrgotStats urgot) 
	{
		if (isProc == false)
		{
			double thunderDamage = (10 * (urgot.getLevel()) + 
					(0.30 * urgot.getBonusAD() + 
					(0.10 * urgot.getBonusAP())));
			battle.addMagicDamage(thunderDamage);
			addEffectNumbers(thunderDamage);
		}
		isProc = true;
	}

}
