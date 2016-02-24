package items.items;

import items.Item;
import urgot.UrgotStats;

public class SunfireCape extends Item {

	private int hp = 500;
	private int armor = 45;
	private UrgotStats urgot;
	private boolean passiveApplied = false;
	@Override
	public void applyPassive(UrgotStats urgot) {
		passiveApplied = true;
		this.urgot = urgot;
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusHP(hp);
		urgot.addBonusArmor(armor);
		
	}

	@Override
	protected void setCost() {
		cost = 2700;
		
	}

	@Override
	protected void setName() {
		name = "Sunfire Cape";
		
	}

	@Override
	protected void setDetails() {
		if (passiveApplied)
		{
			details = "Deals 25 + (" + urgot.getLevel() + ") magic damage "
					+ "per second to nearby enemies (400 range).";
		}
		else
		{
			details = "Deals 25 + (1 × level) magic damage per second to "
					+ "nearby enemies (400 range).";
		}
		
	}

	@Override
	protected void setCategory() {
		category.put("Armor", "");
		category.put("Health", "");

		
	}
}
