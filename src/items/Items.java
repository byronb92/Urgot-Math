package items;

import java.util.HashMap;
import java.util.Map.Entry;

public class Items {

	private HashMap<String, Item> items;
	public Items()
	{
		items = new HashMap<String, Item>();
	}
	
	public void addItem(String itemName, Item i)
	{
		items.put(itemName, i);
	}
	
	public void removeItem(String itemName)
	{
		items.remove(itemName);
	}
	
	public HashMap<String, Item> getItems()
	{
		return items;
	}
	

	
	public String getAllItemDetails()
	{
		StringBuilder itemString = new StringBuilder();
		for(Entry<String,Item> item: getItems().entrySet())
		{
			if (item.getValue().getDetails() != null)
			{
				itemString.append(item.getValue().getName());
				itemString.append(": " + item.getValue().getDetails());
			}
		}
		return itemString.toString();
	}
	
	@Override
	public String toString()
	{
		StringBuilder itemString = new StringBuilder();
		for(Entry<String,Item> item: getItems().entrySet())
		{
			if (item.getValue().getDetails() != null)
			{
				itemString.append(item.getValue().getName() + " ");
			}
		}
		return itemString.toString();
	}
}
