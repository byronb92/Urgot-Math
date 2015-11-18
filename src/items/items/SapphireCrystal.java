package items.items;

import items.Item;
import urgot.UrgotStats;

public class SapphireCrystal extends Item {

	private int mana = 250;
	
	public SapphireCrystal()
	{
		super();
	}
	
	@Override
	public void applyPassive(UrgotStats urgot) {
		// No passive.
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusMana(250);
		
	}

	@Override
	protected void setCost() {
		cost = 350;
		
	}

	@Override
	protected void setName() {
		name = "Sapphire Crystal";
		
	}
	@Override
	protected void setDetails() {
		// No details
		
	}

}
