package items.items;

import items.Item;
import urgot.UrgotStats;

public class RefillablePotion extends Item {

	public RefillablePotion()
	{
		super();
	}
	@Override
	public void applyPassive(UrgotStats urgot) {
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
	}

	@Override
	protected void setCost() {
		cost = 150;
		
	}

	@Override
	protected void setName() {
		name = "Refillable Potion";
		
	}

	@Override
	protected void setDetails() {
		details = "Regenerates 5.21 health every half-second for 12 seconds, "
				+ "restoring a total of 125 health.";
	}
	
	@Override
	protected void setCategory() {
		category.put("Consumable", "");
	}

}
