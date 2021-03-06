package items.items;

import items.Item;
import urgot.UrgotStats;

public class MortalReminder extends Item {
	private int ad = 40;
	private double bonusPercentArmorPen = 0.45;
	@Override
	public void applyPassive(UrgotStats urgot) {	
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusAD(ad);
		urgot.addBonusPercentArmorPen(bonusPercentArmorPen);
		
	}

	@Override
	protected void setCost() {
		cost = 2700;
		
	}

	@Override
	protected void setName() {
		name = "Mortal Reminder";
		
	}

	@Override
	protected void setDetails() {
		details = "UNIQUE – EXECUTIONER: Physical damage inflicts Grievous Wounds icon "
				+ "Grievous Wounds on enemy champions for 5 seconds.";
		
	}

	@Override
	protected void setCategory() {
		category.put("Attack Damage", "");
		category.put("Armor Penetration", "");
		
	}

}
