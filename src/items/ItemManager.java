package items;

import java.util.Map.Entry;
import urgot.UrgotStats;

/**
 * Obtain stats from every item before the battle scenarios are proceeded.
 * @author byronb92
 *
 */
public class ItemManager implements Cloneable {
	private UrgotStats urgot;
	private Items urgotItems;
	private ItemFactory itemFactory;
	
	public Object Clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	
	public ItemManager(UrgotStats urgot)
	{
		this.urgot = urgot;
		urgotItems = new Items();
		itemFactory = new ItemFactory();
	}
	

	public void applyItemSet(int setNumb)
	{
		switch (setNumb) 
		{
		case 1:	
			addItem("Muramana");
			addItem("Black Cleaver");
			addItem("Youmuu's Ghostblade");
			addItem("Death's Dance");
			addItem("Maw of Malmortius");
			break;
		case 2:
			addItem("Iceborn Gauntlet");
			addItem("Black Cleaver");
			addItem("Muramana");
			addItem("Sterak's Gage");
			addItem("Maw of Malmortius");
		case 3:	
			addItem("Muramana");
			addItem("Black Cleaver");
			addItem("Youmuu's Ghostblade");
			addItem("Ionian Boots of Lucidity");
			addItem("Maw of Malmortius");
			addItem("Lord Dominik's Regards");
			break;
		default:
			break;
		}
		
	}
	
	public void addItem(String itemName)
	{
		urgotItems.addItem(itemName, itemFactory.getItem(itemName));
	}
	
	public void addItem(Item item)
	{
		urgotItems.addItem(item.getName(), item);
	}
	
	/**
	 * Add all item stats to urgot's stats.
	 * Then apply any passive or active details after.
	 */
	public void computeItemStats()
	{
		for(Entry<String,Item> item: urgotItems.getItems().entrySet())
		{
			// Add every item stat value.
			item.getValue().addItemStats(urgot);
		}
		
		for(Entry<String,Item> item: urgotItems.getItems().entrySet())
		{
			// Add passives after all stats have been added.
			item.getValue().applyPassive(urgot);
		}
	}
	

	public Items getItems()
	{
		return urgotItems;
	}
	public UrgotStats getUrgotStats()
	{
		return urgot;
	}
	

	
	public boolean containsItem(String itemName)
	{
		if (urgotItems.getItems().containsKey(itemName))
		{
			return true;
		}
		return false;
	}

}
