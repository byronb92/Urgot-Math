package masteries.ferocity;

import masteries.cunning.Mastery;
import urgot.UrgotStats;

/** Natural Talent: 
 * 	0.55 attack damage per level (10 at level 18) 
 * 	0.83 ability power per level (15 at level 18).
 */
public class Ferocity03NaturalTalent extends Mastery {

	public Ferocity03NaturalTalent() {
		super(3);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		urgot.addBonusAPPerLevel(0.83);
		urgot.addBonusADPerLevel(0.55);
		
	}

}
