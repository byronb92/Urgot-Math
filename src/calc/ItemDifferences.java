package calc;

import urgot.UrgotStats;

public class ItemDifferences {
	public ItemDifferences()
	{
		
	}
	
	public double getResistanceReduction(double resistValue)
	{
		if (resistValue >= 0)
		{
			return (100) / (100 + resistValue);
		}
		else
		{
			return (2) - ((100)/(100 - resistValue));
		}
	}

}
