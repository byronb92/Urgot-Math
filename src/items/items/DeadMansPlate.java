package items.items;

import items.Item;
import urgot.UrgotStats;

public class DeadMansPlate extends Item {
	private int hp = 500;
	private int arm = 50;
	public DeadMansPlate()
	{
		super();
	}
	@Override
	public void applyPassive(UrgotStats urgot) {
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusHP(hp);
		urgot.addBonusArmor(arm);
		
	}

	@Override
	protected void setCost() {
		cost = 2900;
		
	}

	@Override
	protected void setName() {
		name = "Dead Man's Plate";
		
	}

	@Override
	protected void setDetails() {
		details = "Generates Momentum stacks while moving, up to 100, "
				+ "granting up to +60 bonus movement speed.";
		
	}
	
	@Override
	protected void setCategory() {
		category.put("Movement Speed", "");
		category.put("Health", "");
		category.put("Armor", "");
		
	}

}
