package items.items;

import items.Item;
import urgot.UrgotStats;

public class LordDominiksRegards extends Item {

	private double bonusArmorPen = 0.40;
	
	public LordDominiksRegards()
	{
		super();
	}
	@Override
	public void applyPassive(UrgotStats urgot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusArmorPen(bonusArmorPen);
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
		details = "UNIQUE – GIANT SLAYER: Grants up to +15% physical damage "
				+ "against enemy champions with greater maximum Health than you "
				+ "(+1.5% damage per 50 Health difference, maxing at 500 Health "
				+ "difference).";
		
	}

}
