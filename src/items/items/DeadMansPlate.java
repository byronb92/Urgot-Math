package items.items;

import items.Item;
import urgot.UrgotStats;

public class DeadMansPlate extends Item {
	private int hp = 600;
	private int arm = 50;
	public DeadMansPlate()
	{
		super();
	}
	@Override
	public void applyPassive(UrgotStats urgot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusHP(600);
		urgot.addBonusArmor(arm);
		
	}

	@Override
	protected void setCost() {
		cost = 2800;
		
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

}
