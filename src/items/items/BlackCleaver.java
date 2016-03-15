package items.items;

import calc.UniqueCalculator;
import items.Item;
import urgot.UrgotStats;

/**
 * Important assumption about Black Cleaver:
 * Math is assumed to always have full stacks.
 * Numbers may seem more powerful than they actually are.
 * @author bbeck799
 *
 */
public class BlackCleaver extends Item {

	private int health = 300;
	private int ad = 55;
	private double cdr = 0.20;
	private boolean passiveApplied = false;
	private UrgotStats urgot;
	
	public BlackCleaver()
	{
		
	}
	
	@Override
	public void applyPassive(UrgotStats urgot) {
		this.urgot = urgot;
		passiveApplied = true;
		setDetails();
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusHP(health);
		urgot.addBonusAD(ad);
		urgot.addCDR(cdr);
		urgot.addPercentArmReduc(0.30);		
	}

	@Override
	protected void setCost() {
		cost = 3500;
		
	}

	@Override
	protected void setName() {
		name = "Black Cleaver";		
	}

	@Override
	protected void setDetails() {
		if (!passiveApplied)
		{
			details = "UNIQUE: 30% armor reduction after 5 stacks of physical damage."
					+ "5% armor per stack.\n"
					+ "RAGE: Physical damage grants 20 (10 for ranged) movement speed for 2 seconds.\n"
					+ "Kills on unit or assists on champs grants 60 (30 for ranged) movement speed.";
		}
		else
		{
			details = "UNIQUE: 30% armor reduction after 5 stacks of physical damage."
					+ "5% armor per stack.\n"
					+ "RAGE: Physical damage grants 20 (10 for ranged) movement speed for 2 seconds.\n"
					+ "Kills on unit or assists on champs grants 60 (30 for ranged) movement speed.\n"
					+ "Urgot Physical Damage MS; " + 
						UniqueCalculator.getMSBonus(urgot, 10) + "\n"
					+ "Urgot Kill MS: " + 
						UniqueCalculator.getMSBonus(urgot, 30);
		}

		
	}
	@Override
	protected void setCategory() {
		category.put("Health", "");
		category.put("Attack Damage", "");
		category.put("Cooldown Reduction", "");
		
	}

}
