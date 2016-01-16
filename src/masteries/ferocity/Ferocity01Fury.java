package masteries.ferocity;

import masteries.*;
import urgot.UrgotStats;

/**
 * Fury: Increases champion attack speed by 0.8 / 1.6 / 2.4 / 3.2 / 4%.
 * @author byronb92
 *
 */
public class Ferocity01Fury extends Mastery {

	public Ferocity01Fury()
	{
		super(1);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) 
	{
		urgot.addBonusAS(0.04);
	}

}
