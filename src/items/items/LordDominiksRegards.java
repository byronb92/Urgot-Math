package items.items;

import items.Item;
import urgot.UrgotStats;

public class LordDominiksRegards extends Item {

	private int ad = 40;
	private double bonusArmorPen = 0.45;
	
	public LordDominiksRegards()
	{
		super();
	}
	@Override
	public void applyPassive(UrgotStats urgot) {
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusPercentArmorPen(bonusArmorPen);
		urgot.addBonusAD(ad);
	}

	@Override
	protected void setCost() {
		cost = 2700;	
	}

	@Override
	protected void setName() {
		name = "Lord Dominik's Regards";
		
	}

	@Override
	protected void setDetails() {
		details = "15% physical damage increase against enemy champions with "
				+ "greater max HP than you (+1.5% damage per 50 Health difference, "
				+ "maxing at 500 Health difference).";
		
	}
	
	@Override
	protected void setCategory() {
		category.put("Attack Damage", "");
		category.put("Armor Penetration", "");

		
	}

}
