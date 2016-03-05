package battle.actions.effects;

/** Effect that takes place from items/passives/masteries */
public class Effect {
	private String type;
	private double effectNumbers;
	private String effectName;
	
	public Effect(String effectNameType)
	{
		type = effectNameType;
	}

	public String getEffectType()
	{
		return type;
	}
	public double getEffectNumbers()
	{
		return effectNumbers;
	}
	
	public String getEffectName()
	{
		return effectName;
	}
	
	public void addEffectNumbers(double numbToAdd)
	{
		effectNumbers = effectNumbers + numbToAdd;
	}


	public void setEffectName(String name)
	{
		effectName = name;
	}

}
