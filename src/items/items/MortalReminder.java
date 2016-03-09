package items.items;

import items.Item;
import urgot.UrgotStats;

public class MortalReminder extends Item {
	private int ad = 40;
	private double bonusArmorPen = 0.45;
	@Override
	public void applyPassive(UrgotStats urgot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusAD(ad);
		// TODO: Check armor pen.
		urgot.addBonusArmorPen(bonusArmorPen);
		
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
