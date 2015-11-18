package items.items;

import items.Item;
import urgot.UrgotStats;

public class DeathsDance extends Item {

	// TODO: Test multiple interactions of death's adnce.
	// AOE Effect;
	private int ad = 65;
	private double cdr = 0.10;
	
	public DeathsDance()
	{
		super();
	}
	
	@Override
	public void applyPassive(UrgotStats urgot) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusAD(65);
		urgot.addCDR(0.10);
	}

	@Override
	protected void setCost() {
		cost = 3400;
		
	}

	@Override
	protected void setName() {
		name = "Death's Dance";
		
	}

	@Override
	protected void setDetails() {
		details = "Instantly heal for 12% of all physical damage dealt."
				+ "AOE 4% to each unit affected.";
	}

}
