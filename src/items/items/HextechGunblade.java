package items.items;

import battle.actions.effects.HextechAfterBattle;
import items.Item;
import urgot.UrgotStats;

public class HextechGunblade extends Item {

	private int ad = 40;
	private int ap = 80;
	@Override
	public void applyPassive(UrgotStats urgot) {
		HextechAfterBattle hextechPassive = new HextechAfterBattle();
		urgot.addEffect(hextechPassive);
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusAD(ad);
		urgot.addBonusAP(ap);
		
	}

	@Override
	protected void setCost() {
		cost = 3400;
		
	}

	@Override
	protected void setName() {
		name = "Hextech Gunblade";
		
	}

	@Override
	protected void setDetails() {
		details = "UNIQUE: Deals 150 (+ 40% AP) magic damage and "
				+ "Slow icon slows the target champion by 40% for 2 seconds. "
				+ "(700 range and 30 second cooldown)";
		
	}

	@Override
	protected void setCategory() {
		category.put("Ability Power", "");
		category.put("Attack Damage", "");
		category.put("Sustain", "");
		
	}

}
