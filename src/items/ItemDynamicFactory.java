package items;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

/**
 * Creates item objects from JSON file.
 * https://code.google.com/archive/p/json-simple/
 * http://www.tutorialspoint.com/json/json_java_example.htm
 * @author byronb92
 *
 */
public class ItemDynamicFactory {
	private JSONParser parser;
	
	// Item categories (non-stat related)
	public static final String SINGLE = "Single";
	public static final String INTERMEDIATE = "Intermediate";
	public static final String LEGENDARY = "Legendary";
	public static final String BOOTS = "Boots";
	public static final String SPECIAL = "Special";
	
	// Flag used for lazy initialization of item list.
	private boolean isCreated = false;
	private ArrayList<String> itemsToCreate;
	public ItemDynamicFactory()
	{
		parser = new JSONParser();
		itemsToCreate = new ArrayList<String>();
	}

	public ArrayList<String> getAllItemCategories() throws ParseException, IOException
	{
		if (!isCreated)
		{
			parseCompleteJSONFile();
			isCreated = true;
		}
		return itemsToCreate;
	}
	
	public ArrayList<String> getSpecificItemCategory(String itemCategory)
			throws ParseException, IOException
	{
		if (isCreated)
		{
			itemsToCreate.clear();
			isCreated = false;
		}
		if (!isCreated)
		{
			parseCategoryOfJSONFile(itemCategory);
			isCreated = true;
		}
		return itemsToCreate;
	}
	
	private void parseCompleteJSONFile() throws ParseException, IOException
	{
		String itemsFile = readItemFile();
		JSONObject obj = (JSONObject)parser.parse(itemsFile);
		itemsToCreate.addAll(getItemCategoryAsArray(obj, SINGLE));
		itemsToCreate.addAll(getItemCategoryAsArray(obj, INTERMEDIATE));
		itemsToCreate.addAll(getItemCategoryAsArray(obj, LEGENDARY));
		itemsToCreate.addAll(getItemCategoryAsArray(obj, BOOTS));
		itemsToCreate.addAll(getItemCategoryAsArray(obj, SPECIAL));
	}
	
	private void parseCategoryOfJSONFile(String category)  throws ParseException, IOException
	{
		String itemsFile = readItemFile();
		JSONObject obj = (JSONObject)parser.parse(itemsFile);
		itemsToCreate.addAll(getItemCategoryAsArray(obj, category));
	}
	
	private ArrayList<String> getItemCategoryAsArray(JSONObject obj, String itemCategory)
	{
		@SuppressWarnings("unchecked")
		Map<String,?> currentItems = (Map<String,?>)obj.get(itemCategory);
		ArrayList<String> stringArray = new ArrayList<String>();
		for (Map.Entry<String,?> entry : currentItems.entrySet())
		{
			stringArray.add(entry.getKey());
		}
		return stringArray;
	}
	
	
	
	// Used for testing purposes.
	public String getItemCategoryAsString(JSONObject obj, String itemCategory)
	{
		@SuppressWarnings("unchecked")
		Map<String,Object> currentItems = (Map<String,Object>)obj.get(itemCategory);
		StringBuilder singleBuffer = new StringBuilder();
		for (Map.Entry<?,?> entry : currentItems.entrySet())
		{
			singleBuffer.append(entry.getKey());
			singleBuffer.append(",");
		}
		// Removes last comma.
		singleBuffer.setLength(singleBuffer.length() - 1);
		return singleBuffer.toString();
	}
	
	
	/** 
	 * Extracts list of items from JSON file "ItemList";
	 * @return
	 * @throws IOException
	 */
	private static String readItemFile() throws IOException
	{
		String filePath = readFile("src/resources/JSON/ItemList.JSON",
				StandardCharsets.UTF_8);
		return filePath;
	}
	/**
	 * http://stackoverflow.com/questions/326390/how-to-create-a-java-string-from-the-contents-of-a-file
	 * @param path
	 * @param encoding
	 * @return
	 * @throws IOException
	 */
	private static String readFile(String path, Charset encoding) throws IOException 
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
}
