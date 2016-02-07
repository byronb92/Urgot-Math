package battle.effects;

import battle.Battle;
import battle.BattleAction;
import battle.UrgotQ;
import battle.UrgotE;
import urgot.UrgotStats;

/** 
 * Deathfire Touch programmed specifically for Urgot 
 * Dealing ability damage to enemy champions applies a bleed, 
 * dealing 1 (+ 3.125% AP) (+ 7.5% bonus AD) magic damage 
 * every half-second for a duration based on their type.
 */
public class DeathfireAfterAction extends Effect {
	private double totalDeathFireCounter = 0;
	private boolean noECast = true;
	private boolean noQCast = true;
	public DeathfireAfterAction() {
		super("After Action");
	}

	@Override
	public void runEffectCalculations(Battle battle, BattleAction action, UrgotStats urgot) {
		if (action instanceof UrgotQ)
		{
			if (noECast && noQCast)
			{
				totalDeathFireCounter = 4;
			}
			else if (noECast && !noQCast)
			{
				UrgotQ urgQ = (UrgotQ)action;
				double urgQCDR = urgQ.getCdrCooldown(urgot.getCDR());
				totalDeathFireCounter = 4 + urgQCDR;
			}
			noQCast = false;
		}
		else if (action instanceof UrgotE)
		{
			totalDeathFireCounter = 6;
			noECast = false;
		}
	}
	
	public double getDFTCounter()
	{
		return totalDeathFireCounter;
	}
	
	


}
