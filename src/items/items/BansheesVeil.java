package items.items;

import items.Item;
import urgot.UrgotStats;

public class BansheesVeil extends Item {

	private int hp = 500;
	private int mr = 70;
	private double baseHealthRegen = 1.0;
	public BansheesVeil()
	{
		super();
	}
	@Override
	public void applyPassive(UrgotStats urgot) {
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusHP(hp);
		urgot.addBonusMR(mr);
		urgot.addBonusHealthRegen(baseHealthRegen);
		
	}

	@Override
	protected void setCost() {
		cost = 2900;
		
	}

	@Override
	protected void setName() {
		name = "Banshee's Veil";
	}

	@Override
	protected void setDetails() {
		details = "Spell shield blocking enemy abilities.\n"
				+ "40 second refresh time when hit with an ability.";
		
	}

}
