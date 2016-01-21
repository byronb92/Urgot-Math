package masteries.resolve;

import urgot.UrgotStats;

public abstract class Mastery {
	private String masteryDetails;
	private int masteryTier;
	
	public Mastery(int tier)
	{
		masteryTier = tier;
	}
	
	public int getTier()
	{
		return masteryTier;
	}

	
	public abstract void runMasteryCalculations(UrgotStats urgot);
	public void setMasteryDetails(String details)
	{
		masteryDetails = details;
	}
}
