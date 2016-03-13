package battle.actions.effects;

import battle.Battle;
import urgot.UrgotStats;

public class HextechAfterBattle extends EffectAfterBattle {
	
	public HextechAfterBattle()
	{
		setEffectName("Hextech Passive. *");
	}
	@Override
	public void runEffectCalculations(Battle battle, UrgotStats urgot) {
		double amountHealed = battle.getTotalDamage() * 0.15;
		battle.addHealing(amountHealed);
		addEffectNumbers(amountHealed);
		
	}



}
