package items.items;

import items.Item;
import urgot.UrgotStats;

public class Boots extends Item {

	private int moveSpeed = 25;
	@Override
	public void applyPassive(UrgotStats urgot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addFlatMoveSpeed(moveSpeed);
		
	}

	@Override
	protected void setCost() {
		cost = 300;
		
	}

	@Override
	protected void setName() {
		name = "Boots of Speed";
		
	}

	@Override
	protected void setDetails() {
		// TODO Auto-generated method stub
		
	}
	
	public void setMoveSpeed(int value)
	{
		moveSpeed = value;
	}

}
