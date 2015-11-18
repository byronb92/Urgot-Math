package items.items;

import items.Item;
import urgot.UrgotStats;

public class ZzRotPortal extends Item {
	private int mr = 60;
	private int armor = 60;
	private double healthRegen = 1.25;
	private boolean passiveApplied = false;
	private UrgotStats urgot;
	
	public ZzRotPortal()
	{
		super();
	}
	@Override
	public void applyPassive(UrgotStats urgot) {
		passiveApplied = true;
		setDetails();
		this.urgot = urgot;
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusMR(mr);
		urgot.addBonusArmor(60);
		urgot.addBonusHealthRegen(healthRegen);
		
	}

	@Override
	protected void setCost() {
		cost = 2700;
		
	}

	@Override
	protected void setName() {
		name = "Zz'Rot Portal";
		
	}

	@Override
	protected void setDetails() {
		if (passiveApplied)
		{
			details = "20% bonus movement speed near turrets or Void Gates"

				+ "The first and every fourth voidspawn gain "
				+ "15% of your maximum health as damage. ("
				+ urgot.getTotalHP();
		}
		else
		{
			details = "20% bonus movement speed near turrets or Void Gates"

				+ "The first and every fourth voidspawn gain "
				+ "15% of your maximum health as damage";
		}
		
		
	}

}
