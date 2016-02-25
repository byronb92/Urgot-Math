package items.algorithm;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

import items.*;

import org.json.simple.parser.ParseException;


public class ItemObjects {
	// Legendary, Boots, Intermediate, Single, Special
	//private ArrayList<Item> listItemObjects;
	private HashMap<String, Item> itemLocations;
	private ItemObjectFactory factory;
	
	public ItemObjects()
	{
//		listItemObjects = new ArrayList<Item>();
		itemLocations = new HashMap<String, Item>();
		factory = new ItemObjectFactory();
	}
	
//	public ArrayList<Item> getItemObjects()
//	{
//		return listItemObjects;
//	}
	
	public HashMap<String, Item> getItemObjects()
	{
		return itemLocations;
	}
	
	// Item construction methods.
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
			itemLocations.put(itemToAdd.getName(), itemToAdd);
		}
		System.out.println("hi");
	}

	private void constructSingle() throws ParseException, IOException, 
		InstantiationException, IllegalAccessException, IllegalArgumentException, 
		InvocationTargetException, NoSuchMethodException, SecurityException, 
		ClassNotFoundException
	{
		ArrayList<String> list = factory.getSpecificItemCategory(ItemObjectFactory.SINGLE);
		for (String currentClassName : list)
		{
			Class<?> clazz = Class.forName(currentClassName);
			Constructor<?> ctor = clazz.getConstructor(String.class);
			Item itemToAdd = (Item)ctor.newInstance();
			//listItemObjects.add(itemToAdd);
			itemLocations.put(itemToAdd.getName(), itemToAdd);
		}

	}
	private void constructIntermediate() throws ParseException, IOException {
		factory.getSpecificItemCategory(ItemObjectFactory.INTERMEDIATE);
	}
	private void constructLegendary() throws ParseException, IOException {
		factory.getSpecificItemCategory(ItemObjectFactory.LEGENDARY);
	}
	private void constructBoots() throws ParseException, IOException {
		factory.getSpecificItemCategory(ItemObjectFactory.BOOTS);
	}
	private void constructSpecial() throws ParseException, IOException {
		factory.getSpecificItemCategory(ItemObjectFactory.SPECIAL);
	}

}
