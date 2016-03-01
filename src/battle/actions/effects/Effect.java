package battle.actions.effects;

/** Effect that takes place from items/passives/masteries */
public class Effect {
	private String type;
	
	public Effect(String effectNameType)
	{
		type = effectNameType;
	}

	public String getEffectType()
	{
		return type;
	}
	

}
