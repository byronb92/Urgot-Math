package items.items;

import items.Item;
import urgot.UrgotStats;

public class DuskbladeOfDraktharr extends Item {

	private int ad = 75;
	private double percentMovement = 0.05;
	private int armorPen = 10;
	private boolean passiveApplied = false;
	@Override
	public void applyPassive(UrgotStats urgot) {
		passiveApplied = true;
		setDetails();
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusAD(ad);
		urgot.addPercentMoveSpeed(percentMovement);
		urgot.addFlatArmorPen(armorPen);
		
	}

	@Override
	protected void setCost() {
		cost = 3250;
		
	}

	@Override
	protected void setName() {
		name = "Duskblade of Draktharr";
		
	}

	@Override
	protected void setDetails() {
		// TODO: Implement this with a counter of target's misisng health.
		if (passiveApplied)
		{
			details = "After 2 seconds, deals 90 (+ 25% of target's missing health) physical "
					+ "damage. If the target is taken down before NIGHTFALL has dealt damage,"
					+ " its full cooldown is refunded.";
		}
		else
		{
			details = "After 2 seconds, deals 90 (+ 25% of target's missing health) physical "
					+ "damage. If the target is taken down before NIGHTFALL has dealt damage,"
					+ " its full cooldown is refunded.";
		}
		
		
		
	}

	@Override
	protected void setCategory() {
		category.put("Attack Damage", "");
		category.put("Armor Penetration", "");
		category.put("Movement Speed", "");
		
	}

}
