package masteries.ferocity;

import masteries.Mastery;
import urgot.UrgotStats;


/** 
 * Fervor: You gain stacks of Fervor for 6 seconds whenever you damage an enemy champion, stacking up to 10 stacks, based on the type:
 *		1 stack for ranged basic attacks (on-hit).
 *		2 stacks for melee basic attacks (on-hit).
 *		2 stacks for ability damage (2 second cooldown).
 *		Each stack of Fervor adds 1.32 - 8.46 (based on level) bonus physical damage on-hit against champions.
 *			0.9 + (0.73 * level)
 */
public class Ferocity06Fervor extends Mastery {
	private int stacks;
	public Ferocity06Fervor() {
		super(6);
	}

	public void setStacks(int stacks)
	{
		this.stacks = stacks;
		if (this.stacks > 10)
		{
			this.stacks = 10;
		}
	}
	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		double fervorBonusPerLevel = 0.73 * urgot.getLevel();
		double fervorDamagePerAuto = stacks * (0.9 + fervorBonusPerLevel);
		setMasteryDetails("Fervor damage per auto attack at 10 stacks: " + fervorDamagePerAuto);
		
	}

}
