 package items.items;

import items.Item;
import urgot.UrgotStats;

public class RighteousGlory extends Item {
	private int hp = 500;
	private int mana = 300;
	private double manaRegen = 1.0;
	
	public RighteousGlory()
	{
		super();
	}
	@Override
	public void applyPassive(UrgotStats urgot) {
		
	}
	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusHP(hp);
		urgot.addBonusMana(mana);
		urgot.addBonusManaRegen(manaRegen);
		
	}
	@Override
	protected void setCost() {
		cost = 2600;
		
	}
	@Override
	protected void setName() {
		name = "Righteous Glory";
		
	}
	@Override
	protected void setDetails() {
		
	}
	
	@Override
	protected void setCategory() {
		category.put("Health", "");
		category.put("Mana","");
		category.put("Movement","");
		
	}
	

}
