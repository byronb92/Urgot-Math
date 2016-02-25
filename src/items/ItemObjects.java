package items;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.parser.ParseException;


public class ItemObjects {
	private HashMap<String,Item> mapItemObjects;
	private ItemDynamicFactory factory;
	
	public ItemObjects()
	{
		mapItemObjects = new HashMap<String, Item>();
		factory = new ItemDynamicFactory();
	}
	
	public HashMap<String, Item> getItemObjects()
	{
		return mapItemObjects;
	}
	
	public void constructAllItems() throws ParseException, IOException, 
		ClassNotFoundException, NoSuchMethodException, SecurityException, 
		InstantiationException, IllegalAccessException, IllegalArgumentException, 
		InvocationTargetException
	{
		ArrayList<String> list = factory.getAllItemCategories();
		for (int i = 0; i < list.size(); i++)
		{
			Class<?> clazz = Class.forName("items.items." + list.get(i));
			//Constructor<?> ctor = clazz.getConstructor(String.class);
			Item itemToAdd = (Item)clazz.newInstance();
			//listItemObjects.add(itemToAdd);
			mapItemObjects.put(itemToAdd.getName(), itemToAdd);
		}
	}

	/**
	 * Allocates only the specified items with the given itemCategory
	 * @param itemCategory Single, Intermediate, Legendary, Boots, and Special
	 * @throws ParseException
	 * @throws IOException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 */
	public void constructSpecificCategory(String itemCategory) throws ParseException, 
		IOException, InstantiationException, IllegalAccessException, 
		IllegalArgumentException, InvocationTargetException, NoSuchMethodException, 
		SecurityException, ClassNotFoundException
	{
		ArrayList<String> list = factory.getSpecificItemCategory(itemCategory);
		for (String currentClassName : list)
		{
			Class<?> clazz = Class.forName(currentClassName);
			Constructor<?> ctor = clazz.getConstructor(String.class);
			Item itemToAdd = (Item)ctor.newInstance();
			mapItemObjects.put(itemToAdd.getName(), itemToAdd);
		}

	}
	
	
	/**
	 * Methods that only obtain items from a given category.
	 */
//	private void constructIntermediate() throws ParseException, IOException {
//		factory.getSpecificItemCategory(ItemObjectFactory.INTERMEDIATE);
//	}
//	private void constructLegendary() throws ParseException, IOException {
//		factory.getSpecificItemCategory(ItemObjectFactory.LEGENDARY);
//	}
//	private void constructBoots() throws ParseException, IOException {
//		factory.getSpecificItemCategory(ItemObjectFactory.BOOTS);
//	}
//	private void constructSpecial() throws ParseException, IOException {
//		factory.getSpecificItemCategory(ItemObjectFactory.SPECIAL);
//	}

}
