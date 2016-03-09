package items.items;

import items.Item;
import urgot.UrgotStats;

public class WarmogsArmor extends Item {
	private int hp = 850;
	private int baseHealthRegen = 2;
	@Override
	public void applyPassive(UrgotStats urgot) {
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusHP(hp);
		// TODO: Check health regen formula.
		urgot.addBonusHealthRegen(baseHealthRegen);
		
	}

	@Override
	protected void setCost() {
		cost = 2850;
		
	}

	@Override
	protected void setName() {
		name = "Warmog's Armor";
		
	}

	@Override
	protected void setDetails() {
		details = "UNIQUE – WARMOG'S HEART: Regenerate 「 1.5% maximum health every half-second 」"
				+ "if damage has not been taken in the last 8 seconds.";
		
	}

	@Override
	protected void setCategory() {
		category.put("Health","");
		category.put("Health Regeneration","");
		
	}

}
