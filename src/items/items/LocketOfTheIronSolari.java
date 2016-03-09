package items.items;

import items.Item;
import urgot.UrgotStats;

public class LocketOfTheIronSolari extends Item {
	private int hp = 400;
	private int mr = 20;
	private double baseHealthRegen = 1;
	private double cdr = 0.10;
	@Override
	public void applyPassive(UrgotStats urgot) {

		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusHP(hp);
		urgot.addBonusMR(mr);
		// TODO: Check this.
		urgot.addBonusHealthRegen(baseHealthRegen);
		urgot.addCDR(cdr);
		
	}

	@Override
	protected void setCost() {
		cost = 2500;
		
	}

	@Override
	protected void setName() {
		name = "Locket of the Iron Solari";
		
	}

	@Override
	protected void setDetails() {
		details = "UNIQUE: Shield yourself and nearby allied champions for 2 seconds, "
				+ "absorbing up to 90 - 345 (based on level) "
				+ "damage (60 second cooldown) (600 range).";
	}

	@Override
	protected void setCategory() {
		category.put("Health", "");
		category.put("Magic Resistance", "");
		category.put("Cooldown Reduction", "");
		category.put("Health Regeneration", "");
		
	}

}
