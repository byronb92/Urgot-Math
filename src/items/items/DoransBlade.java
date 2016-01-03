package items.items;

import items.Item;
import urgot.UrgotStats;

public class DoransBlade extends Item {

	public DoransBlade()
	{
		super();
	}
	private int hp = 80;
	private int ad = 8;
	private double lifeSteal = 0.03;
	@Override
	public void applyPassive(UrgotStats urgot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusHP(hp);
		urgot.addBonusAD(ad);
		urgot.addLifeSteal(lifeSteal);
		
	}

	@Override
	protected void setCost() {
		cost = 450;
		
	}

	@Override
	protected void setName() {
		name = "Doran's Blade";
		
	}

	@Override
	protected void setDetails() {
		
	}

}
