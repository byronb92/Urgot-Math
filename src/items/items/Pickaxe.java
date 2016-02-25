package items.items;

import items.Item;
import urgot.UrgotStats;

public class Pickaxe extends Item{
	private int ad = 25;
	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusAD(ad);
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
