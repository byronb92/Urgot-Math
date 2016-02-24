package items.items;

import items.Item;
import urgot.UrgotStats;

public class Pickaxe extends Item{

	@Override
	public void addItemStats(UrgotStats urgot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCost() {
		cost = 875;
	}

	@Override
	// No passive, nothing happens/
	public void applyPassive(UrgotStats urgot) {
		
	}

	@Override
	protected void setName() {
		name = "Pickaxe";
		
	}

	@Override
	protected void setDetails() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void setCategory() {
		category.put("Attack Damage", "");
		
	}

}
