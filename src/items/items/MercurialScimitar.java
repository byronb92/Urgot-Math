package items.items;

import items.Item;
import urgot.UrgotStats;

public class MercurialScimitar extends Item {
	private int mr = 35;
	private int ad = 65;
	private double lifeSteal = 0.10;
	@Override
	public void applyPassive(UrgotStats urgot) {		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusMR(mr);
		urgot.addBonusAD(ad);
		urgot.addLifeSteal(lifeSteal);
		
	}

	@Override
	protected void setCost() {
		cost = 3600;
		
	}

	@Override
	protected void setName() {
		name = "Mercurial Scimitar";
		
	}

	@Override
	protected void setDetails() {
		details = "UNIQUE – QUICKSILVER: Removes CC from your champion and "
				+ "grants +50% movement speed for 1 second. (90 second cooldown.)";
		
	}

	@Override
	protected void setCategory() {
		category.put("Magic Resistance", "");
		category.put("Attack Damage", "");
		category.put("Sustain", "");
		
	}

}
