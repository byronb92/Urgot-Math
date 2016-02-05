package battle.effects;

import battle.Battle;
import urgot.UrgotStats;

public class Thunderlords extends Effect {
	// TODO: Only make it proc after 3 attacks.s
	private boolean isProc = false;
	public Thunderlords() {
		super("After Action");
	}

	@Override
	public void runEffectCalculations(Battle battle, UrgotStats urgot) 
	{
		if (isProc == false)
		{
			double thunderDamage = (10 * (urgot.getLevel()) + 
					(0.30 * urgot.getBonusAD() + 
					(0.10 * urgot.getBonusAP())));
			battle.addMagicDamage(thunderDamage);
		}
		isProc = true;
	}

}
