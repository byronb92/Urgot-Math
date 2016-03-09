package items.items;

import items.Item;
import urgot.UrgotStats;

public class GuardianAngel extends Item{
	private int mr = 60;
	private int arm = 60;
	@Override
	public void applyPassive(UrgotStats urgot) {
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusMR(mr);
		urgot.addBonusArmor(arm);
		
	}

	@Override
	protected void setCost() {
		cost = 2700;
		
	}

	@Override
	protected void setName() {
		name = "Guardian Angel";
		
	}

	@Override
	protected void setDetails() {
		details = "UNIQUE: Upon taking lethal damage, restores the greater of 700 Health or "
				+ "30% of maximum Health and 30% of maximum Mana after 4 seconds of stasis. 300 second cooldown.";
		
	}

	@Override
	protected void setCategory() {
		category.put("Armor", "");
		category.put("Magic Resistance", "");
		
	}

}
