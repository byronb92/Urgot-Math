package items;



public class ItemRemovalWrapper {
	
	public ItemRemovalWrapper()
	{
		
	}
	
	
	
	public void removeItemAfterBeingUsed(String itemName, ItemObjects itemObjs)
	{
		itemObjs.getItemObjects().remove(itemName);
		if (itemName.equals("Muramana") && 
				itemObjs.getItemObjects().containsKey("Manamune"))
		{
			itemObjs.getItemObjects().remove("Manamune");
		}
		else if (itemName.equals("Manamune") && 
				itemObjs.getItemObjects().containsKey("Muramana"))
		{
			itemObjs.getItemObjects().remove("Muramana");
		}
	}
	

}
