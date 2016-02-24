package items.items;

import urgot.UrgotStats;

public class BootsNinja extends Boots {
	private int ad = 30;
	public BootsNinja()
	{
		setCost();
		setName();
		setMoveSpeed(45);
		setDetails();
	}
	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusArmor(ad);
	}
	@Override
	protected void setCost()
	{
		cost = 1100;
	}
	
	@Override
	protected void setName()
	{
		name = "Ninja Tabi";
	}
	@Override
	protected void setDetails()
	{
		details = "Reduces incoming damage from all basic attacks by 10% "
				+ "(excluding turret shots). Does not reduce damage of "
				+ "on-hit effects, it does however reduce damage of "
				+ "basic attack modifiers."; 
	}
	@Override
	protected void setCategory() {
		category.put("Movement Speed", "");
		category.put("Armor", "");
		
	}
}
