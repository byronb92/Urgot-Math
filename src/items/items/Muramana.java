package items.items;

import urgot.UrgotStats;

public class Muramana extends Manamune {
	
	// TODO: Add dynamic Muramana iteraction.
	UrgotStats urgot;
	public Muramana()
	{
		super(750);
	}
	
	@Override
	protected void setName()
	{
		 name = "Muramana";
	}
	
	public void setAdditionalDetails()
	{
		details = details + "Consume 3% of current mana to deal 6% of "
				+ "current mana as physical damage.";
	}

}
