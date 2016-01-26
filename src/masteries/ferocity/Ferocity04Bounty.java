package masteries.ferocity;

import masteries.Mastery;
import urgot.UrgotStats;

/** 
 * Bounty Hunter:
 * Grants 1% increased damage for each UNIQUE enemy champion you kill. 
 * (Your damage output increases by 1% each time you kill an 
 * enemy champion for the first time)
 */
public class Ferocity04Bounty extends Mastery {

	private int champsKilled = 1;
	public Ferocity04Bounty()
	{
		super(4);
	}
	public Ferocity04Bounty(int championsKilled) {
		super(4);
		champsKilled = championsKilled;
	}
	
	public void setChampionsKilled(int champs)
	{
		if (champsKilled >= 5)
		{
			champsKilled = 5;
		}
		else
		{
			champsKilled = champs;
		}
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		urgot.addDamageAmplification(0.01 * champsKilled);	
	}

}
