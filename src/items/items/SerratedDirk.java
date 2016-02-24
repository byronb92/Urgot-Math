package items.items;

import items.Item;
import urgot.UrgotStats;

public class SerratedDirk extends Item {

	private int ad = 20;
	private int armorpen = 10;
	@Override
	public void applyPassive(UrgotStats urgot) {
		// TODO Auto-generated method stub
		
	}

	public SerratedDirk()
	{
		super();
	}
	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addArmorPen(armorpen);
		urgot.addBonusAD(ad);
		
	}

	@Override
	protected void setCost() {
		cost = 1100;
		
	}

	@Override
	protected void setName() {
		name = "Serrated Dirk";
	}

	@Override
	protected void setDetails() {
		details = "After killing a unit, your next basic attack (on-hit) "
				+ "or single target ability deals +15 bonus damage.";
		
	}
	
	@Override
	protected void setCategory() {
		category.put("Attack Damage", "");
		category.put("Armor Penetration", "");
		
	}

}
