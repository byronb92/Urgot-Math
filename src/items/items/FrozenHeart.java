package items.items;

import items.Item;
import urgot.UrgotStats;

public class FrozenHeart extends Item {

	private int armor = 90;
	private int mana = 400;
	private double cdr = 0.20;
	
	@Override
	public void applyPassive(UrgotStats urgot) {
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusArmor(armor);
		urgot.addBonusMana(mana);
		urgot.addCDR(cdr);
		
	}

	@Override
	protected void setCost() {
		cost = 2800;
		
	}

	@Override
	protected void setName() {
		name = "Frozen Heart";
		
	}

	@Override
	protected void setDetails() {
		details = "Reduces the attack speed of nearby enemies by 15% (700 range).";
		
	}
	
	@Override
	protected void setCategory() {
		category.put("Armor", "");
		category.put("Mana", "");
		category.put("Cooldown Reduction", "");
		
	}

}
