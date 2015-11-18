package items;

import java.util.Map.Entry;
import urgot.UrgotStats;

/**
 * Obtain stats from every item before the battle scenarios are proceeded.
 * @author byronb92
 *
 */
public class ItemManager {
	UrgotStats urgot;
	Items urgotItems;
	public ItemManager(UrgotStats urgot)
	{
		this.urgot = urgot;
		urgotItems = new Items();
	}
	
	// Manamune, Black Cleaver, Ionian Boots, Youmuu's Ghostblade
	// Lord Dominick's, Maw Of Malmortus
	// For now, only test level 6 urgot.
	public void setItemSetOne()
	{
		
		ItemFactory itemFactory = new ItemFactory();
		urgotItems.addItem("Manamune", itemFactory.getItem("Manamune400"));
		urgotItems.addItem("Sheen", itemFactory.getItem("Sheen"));
		urgotItems.addItem("Black Cleaver", itemFactory.getItem("Black Cleaver"));
		urgotItems.addItem("Youmuu's Ghostblade", 
				itemFactory.getItem("Youmuu's Ghostblade"));
		
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
