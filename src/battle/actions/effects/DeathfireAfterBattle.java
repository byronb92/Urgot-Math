package battle.actions.effects;

import battle.Battle;
import urgot.UrgotStats;

/** Interactions with DeathfireAfterAction to compute Deathfire Touch damage */
public class DeathfireAfterBattle extends EffectAfterBattle {

	private DeathfireAfterAction dftAfterAction;
	
	public DeathfireAfterBattle() {
		super();
	}

	@Override
	public void runEffectCalculations(Battle battle, UrgotStats urgot) {
		updateDeathfireStats(urgot);
		double deathDamage = computeDeathFireDamage(urgot);
		battle.addMagicDamage(deathDamage);
		addEffectNumbers(deathDamage);
		setEffectName("Deathfire Touch");
	}

	private void updateDeathfireStats(UrgotStats urgot)
	{
		dftAfterAction = (DeathfireAfterAction)urgot.getEffects().
				getEffectByClassName("Deathfire After Action");
	}
	
	private double computeDeathFireDamage(UrgotStats urgot)
	{
		double scalingAD = urgot.getBonusAD() * 0.075;
		double scalingAP = urgot.getBonusAP() * 0.03125;
		
		double decimalForm = dftAfterAction.getDFTCounter() - (int)dftAfterAction.getDFTCounter();
		double burnSeconds = 0;
		if (decimalForm < 0.5)
		{
			burnSeconds = (int)dftAfterAction.getDFTCounter();
		}
		else
		{
			burnSeconds = (int)dftAfterAction.getDFTCounter() + 0.5;
		}
		return (burnSeconds * (1 + scalingAD + scalingAP));
	}

}
