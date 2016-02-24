package items.items;

import urgot.UrgotStats;

public class BootsTreads extends Boots {
	private int mr = 25;
	public BootsTreads()
	{
		setCost();
		setName();
		setMoveSpeed(45);
		setDetails();
	}
	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusMR(mr);
	}
	@Override
	protected void setCost()
	{
		cost = 1100;
	}
	
	@Override
	protected void setName()
	{
		name = "Mercury's Treads";
	}
	@Override
	protected void setDetails()
	{
		details = "Reduces the duration of all crowd control effects by 20%.";
	}
	
	@Override
	protected void setCategory() {
		category.put("Magic Resist", "");
		category.put("Cooldown Reduction", "");
		
	}

}
