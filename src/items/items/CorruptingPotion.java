package items.items;

import items.Item;
import urgot.UrgotStats;

public class CorruptingPotion extends Item {

	public CorruptingPotion()
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
		cost = 500;
		
	}

	@Override
	protected void setName() {
		name = "Corrupting Potion";
		
	}

	@Override
	protected void setDetails() {
		details = "TOUCH OF CORRUPTION: Abilities and basic attacks "
				+ "apply a burn that damages enemy champions for " 
				+ "15 - 30 (based on level) bonus magic damage over 3 seconds. "
				+ "Bonus damage is halved for area of effect "
				+ "and damage over time effects. Corrupting Potion can be "
				+ "used even at full health and mana.";
	}
	
	@Override
	protected void setCategory() {
		category.put("Consumable", "");
	}

}
