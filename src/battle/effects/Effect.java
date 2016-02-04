package battle.effects;

import battle.Battle;
import urgot.UrgotStats;

public abstract class Effect {
	private String type;
	
	public Effect(String effectNameType)
	{
		type = effectNameType;
	}

	public String getEffectType()
	{
		return type;
	}
	
	public abstract void runEffectCalculations(Battle battle, UrgotStats urgot);
}
