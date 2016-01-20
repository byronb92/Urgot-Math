package masteries.ferocity;

import masteries.cunning.Mastery;
import urgot.UrgotStats;

/**
 * Sorcery: Increases ability and spell damage by 0.4 / 0.8 / 1.2 / 1.6 / 2%.
 * @author byronb92
 *
 */
public class Ferocity01Sorcery extends Mastery
{

	
	public Ferocity01Sorcery()
	{
		super(1);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		urgot.addSpellAmplification(0.02);
		
	}

}
