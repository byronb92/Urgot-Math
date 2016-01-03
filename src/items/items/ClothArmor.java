package items.items;

import items.Item;
import urgot.UrgotStats;

public class ClothArmor extends Item {

	private int armor = 15;
	public ClothArmor()
	{
		super();
	}
	@Override
	public void applyPassive(UrgotStats urgot) {
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusArmor(armor);
	}

	@Override
	protected void setCost() {
		cost = 300;
		
	}

	@Override
	protected void setName() {
		name = "Cloth Armor";	
	}

	@Override
	protected void setDetails() {	
	}

}
