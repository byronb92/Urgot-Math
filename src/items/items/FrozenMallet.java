package items.items;

import items.Item;
import urgot.UrgotStats;

public class FrozenMallet extends Item {
	private int hp = 650;
	private int ad = 40;
	@Override
	public void applyPassive(UrgotStats urgot) {
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusHP(hp);
		urgot.addBonusAD(ad);		
	}

	@Override
	protected void setCost() {
		cost = 3100;
		
	}

	@Override
	protected void setName() {
		name = "Frozen Mallet";
		
	}

	@Override
	protected void setDetails() {
		details = "UNIQUE – ICY: Basic attacks (on-hit) apply 40% (30% ranged) slow "
				+ "to your target for 1.5 seconds, refreshing with every hit.";
		
	}

	@Override
	protected void setCategory() {
		category.put("Attack Damage", "");
		category.put("Health", "");
		
	}

}
