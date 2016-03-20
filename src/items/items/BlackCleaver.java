package items.items;

import items.Item;
import urgot.UrgotStats;

public class BlackCleaver extends Item {

	private int health = 300;
	private int ad = 55;
	private double cdr = 0.20;
	
	public BlackCleaver()
	{
		
	}
	
	@Override
	public void applyPassive(UrgotStats urgot) {
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusHP(health);
		urgot.addBonusAD(ad);
		urgot.addCDR(cdr);
		// TODO: Calculate Black Cleaver on stack by stack basis.
		urgot.addPercentArmReduc(0.30);
		// TODO: Calculate movement speed boost.
		
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
		details = "30% armor reduction after 5 stacks of physical damage."
				+ "5% armor per stack.";
	}
	@Override
	protected void setCategory() {
		category.put("Health", "");
		category.put("Attack Damage", "");
		category.put("Cooldown Reduction", "");
		
	}

}
