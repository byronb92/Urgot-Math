package masteries.resolve;

import masteries.Mastery;
import urgot.UrgotStats;

/* Perseverance: +50% base hp regen, 200% when below 25% hp */
public class Resolve04Perseverance extends Mastery {

	public Resolve04Perseverance() {
		super(4);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) 
	{
		// TODO: Re-do math for perservance.
		urgot.addBonusHealthRegen(0.50);
		setMasteryDetails("200% health regen when under 25% hp. (" +
		urgot.getBaseHPRegenFromLevel() * 1.50 + ")");
	}

}
