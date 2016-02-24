package items.items;

import urgot.UrgotStats;

public class BootsIonian extends Boots {
	
	public BootsIonian()
	{
		setCost();
		setName();
		setMoveSpeed(45);
		setDetails();
	}
	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addCDR(0.10);
	}
	@Override
	protected void setCost()
	{
		cost = 800;
	}
	
	@Override
	protected void setName()
	{
		name = "Ionian Boots of Lucidity";	
	}
	@Override
	protected void setDetails()
	{
		details = "Reduces summoner spell cooldowns by 10%.";
	}
	
	@Override
	protected void setCategory() {
		category.put("Movement Speed", "");
		category.put("Cooldown Reduction", "");
		
	}


}
