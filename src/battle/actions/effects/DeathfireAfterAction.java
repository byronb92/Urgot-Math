package battle.actions.effects;

import battle.Battle;
import battle.actions.BattleAction;
import battle.actions.UrgotE;
import battle.actions.UrgotQ;
import urgot.UrgotStats;

/** Keeps track of Deathfire tick damage to be computed in DeathfireAfterBattle */
public class DeathfireAfterAction extends EffectAfterAction {
	private double totalDeathFireCounter = 0;
	private boolean noECast = true;
	private boolean noQCast = true;
	public DeathfireAfterAction() {
		super();
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
