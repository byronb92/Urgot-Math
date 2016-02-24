package items.items;

import items.Item;
import urgot.UrgotStats;

public class LongSword extends Item {

	private int ad = 10;
	public LongSword()
	{
		super();
	}
	@Override
	public void applyPassive(UrgotStats urgot) {
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusAD(ad);
	}

	@Override
	protected void setCost() {
		cost = 350;
		
	}

	@Override
	protected void setName() {
		name = "Long Sword";
		
	}

	@Override
	protected void setDetails() {
		
	}
	
	@Override
	protected void setCategory() {
		category.put("Attack Damage", "");
	}

}
