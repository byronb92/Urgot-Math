package battle.effects;

public abstract class Effect {
	private String type;
	
	public Effect(String effectName)
	{
		type = effectName;
	}

	public String getEffectType()
	{
		return type;
	}
	
	public abstract void runEffectCalculations();
}
