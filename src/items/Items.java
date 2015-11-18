package items;

import java.util.HashMap;

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
}
