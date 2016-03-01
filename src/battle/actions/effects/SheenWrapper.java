package battle.actions.effects;

public class SheenWrapper {
	
	private final static double SHEEN_COEFFICIENT = 1.0;
	private final static double TRINITY_COEFFICIENT = 2.0;
	private final static double ICEBORN_COEFFICIENT = 1.5;
	private final static double LICHBANE_COEFFICIENT = 1.0;
	
	private double sheenCoefficient = 0;
	
	public enum SheenVariation
	{
		SHEEN, TRINITY, ICEBORN, LICHBANE
	}
	
	public SheenWrapper(SheenVariation sheenType)
	{
		if (sheenType == SheenVariation.SHEEN)
		{
			sheenCoefficient = SHEEN_COEFFICIENT;
		}
		else if (sheenType == SheenVariation.TRINITY)
		{
			sheenCoefficient = TRINITY_COEFFICIENT;
		}
		else if (sheenType == SheenVariation.ICEBORN)
		{
			sheenCoefficient = ICEBORN_COEFFICIENT;
		}
		else if (sheenType == SheenVariation.LICHBANE)
		{
			sheenCoefficient = LICHBANE_COEFFICIENT;
		}
	}
	
	public double getSheenCoefficient()
	{
		return sheenCoefficient;
	}

}
