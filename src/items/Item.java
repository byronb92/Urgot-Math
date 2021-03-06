package items;

import java.util.HashMap;

import battle.Battle;
import urgot.UrgotStats;

public abstract class Item {
	
	protected int cost;
	protected String name;
	protected String details = null;
	protected HashMap<String,String> category;
	
	
	public abstract void applyPassive(UrgotStats urgot);
	/**
	 * Used to take care of special case battle scenarios such as healing
	 * for a specific set of items.
	 * @param calc - list of battle numbers that items will be usign.
	 */
	public void applyAfterBattleUniques(Battle calc)
	{
		
	}
	public abstract void addItemStats(UrgotStats urgot);
	protected abstract void setCost();
	protected abstract void setName();
	protected abstract void setDetails();
	protected abstract void setCategory();
	
	public int getCost() { return cost; }
	public String getName() { return name; }
	public String getDetails() { return details; }
	
	
	public Item()
	{
		category = new HashMap<String,String>();
		setCost();
		setName();
		setDetails();
		setCategory();
	}


}
