package items.items;

import items.Item;
import urgot.UrgotStats;

public class CaulfieldWarhammer extends Item {

	private int attackDamage = 25;
	private double cdr = 0.10;
	
	public CaulfieldWarhammer()
	{
		super();
	}
	@Override
	public void applyPassive(UrgotStats urgot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusAD(attackDamage);
		urgot.addCDR(cdr);
		
	}

	@Override
	protected void setCost() {
		cost = 1100;
		
	}

	@Override
	protected void setName() {
		name = "Caulfield's Warhammer";
		
	}

	@Override
	protected void setDetails() {
		// No details.
		
	}

}
