package items.items;

import items.Item;
import urgot.UrgotStats;

public class ZzRotPortal extends Item {
	private int mr = 55;
	private int armor = 55;
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
		this.urgot = urgot;
		setDetails();
		
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusMR(mr);
		urgot.addBonusArmor(armor);
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
	@Override
	protected void setCategory() {
		category.put("Armor", "");
		category.put("Magic Resistance", "");
		category.put("Health Regeneration", "");
		
	}

}
