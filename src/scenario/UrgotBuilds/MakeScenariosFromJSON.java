package scenario.UrgotBuilds;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import items.Item;
import items.ItemObjects;
import scenario.ScenarioManager;
import scenario.UrgotScenario;

public class MakeScenariosFromJSON {
	private JSONParser parser;
	private HashMap<String, ScenarioManager> mapScenarioManagers;
	private static final String STARTING = "starting";
	private static final String DAMAGE = "damage";
	private static final String BRUISER = "bruiser";	
	private static final String TANKY = "tanky";

	public enum BuildType
	{
		ALL, STARTING, DAMAGE, BRUISER, TANKY
	}
	
	public MakeScenariosFromJSON()
	{
		parser = new JSONParser();
		mapScenarioManagers = new HashMap<String,ScenarioManager>();
	}
	

	
	public boolean parseJSONByBuildType(BuildType buildType) throws IOException, ParseException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		String itemsFile = readItemFile();
		JSONObject obj = (JSONObject)parser.parse(itemsFile);
		JSONObject buildTypeJSONObject = null;
		switch (buildType)
		{
			case ALL:
				parseCompleteJSONFile();
				return true;
			case STARTING:
				buildTypeJSONObject = (JSONObject)obj.get(STARTING);
				break;
			case DAMAGE:
				buildTypeJSONObject = (JSONObject)obj.get(DAMAGE);
				break;
			case BRUISER:
				buildTypeJSONObject = (JSONObject)obj.get(BRUISER);
				break;
			case TANKY:
				buildTypeJSONObject = (JSONObject)obj.get(TANKY);
				break;
			default:
				parseCompleteJSONFile();
				return true;
		}	
		HashMap<String,JSONArray> mapBuildTypes = new HashMap<String, JSONArray>();
		mapBuildTypes.putAll(buildTypeJSONObject);
		for(Entry<String, JSONArray> item: mapBuildTypes.entrySet())
		{
			addSceManagerToManagersListFromJSONArray(item.getValue(), item.getKey());
		}
		
		return true;
	}
	
	private boolean parseCompleteJSONFile() throws ParseException, IOException, ClassNotFoundException, 
		NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, 
		IllegalArgumentException, InvocationTargetException
	{
		String itemsFile = readItemFile();
		JSONObject obj = (JSONObject)parser.parse(itemsFile);
		HashMap<String,JSONObject> mapBuildTypeJSONObjects = new HashMap<String, JSONObject>();
		mapBuildTypeJSONObjects.putAll(obj);
		for(Entry<String, JSONObject> item: mapBuildTypeJSONObjects.entrySet())
		{
			HashMap<String,JSONArray> mapBuildTypes = new HashMap<String, JSONArray>();
			mapBuildTypes.putAll(item.getValue());
			for(Entry<String, JSONArray> itemB: mapBuildTypes.entrySet())
			{
				addSceManagerToManagersListFromJSONArray(itemB.getValue(), itemB.getKey());
			}
		}
		return true;
	}
	
	private boolean addSceManagerToManagersListFromJSONArray(
		JSONArray arrayJSON, String managerTag) throws 
			ClassNotFoundException, NoSuchMethodException, SecurityException, 
			InstantiationException, IllegalAccessException, IllegalArgumentException, 
			InvocationTargetException, ParseException, IOException
	{
		ScenarioManager currentSceManager = new ScenarioManager();
		currentSceManager.setScenarioManagerName(managerTag);
		// Special case for starting items.
		if (managerTag.equals("Potions") || managerTag.equals("Battle Stats"))
		{
			currentSceManager.addAllScenarios(
					makeListOfScenariosFromJSONArrayWithCustomLevel(arrayJSON,1));
		}
		currentSceManager.addAllScenarios(makeListOfScenariosFromJSONArray(arrayJSON));
		mapScenarioManagers.put(managerTag,currentSceManager);
		return true;
	}

	private ArrayList<UrgotScenario> makeListOfScenariosFromJSONArray
		(JSONArray JSONitems) throws 
			ClassNotFoundException, NoSuchMethodException, SecurityException, 
			InstantiationException, IllegalAccessException, IllegalArgumentException, 
			InvocationTargetException, ParseException, IOException
	{
		ArrayList<UrgotScenario> urgList = new ArrayList<UrgotScenario>();
		for (int i =0; i < JSONitems.size(); i++)
		{
			JSONArray currentArray = (JSONArray)JSONitems.get(i);
			urgList.add(makeFullBuildScenarioFromJSONArrayWithItems(currentArray));
		}
		return urgList;
	}
	
	private ArrayList<UrgotScenario> makeListOfScenariosFromJSONArrayWithCustomLevel
	(JSONArray JSONitems,int urgotLevel) throws ClassNotFoundException, 
		NoSuchMethodException, SecurityException, InstantiationException, 
		IllegalAccessException, IllegalArgumentException, 
		InvocationTargetException, ParseException, IOException
{
	ArrayList<UrgotScenario> urgList = new ArrayList<UrgotScenario>();
	for (int i =0; i < JSONitems.size(); i++)
	{
		JSONArray currentArray = (JSONArray)JSONitems.get(i);
		urgList.add(makeScenarioFromJSONArrayWithLevel(
				currentArray,urgotLevel));
	}
	return urgList;
}
	
	private UrgotScenario makeFullBuildScenarioFromJSONArrayWithItems
		(JSONArray JSONitems) throws ClassNotFoundException, NoSuchMethodException, 
		SecurityException, InstantiationException, IllegalAccessException, 
		IllegalArgumentException, InvocationTargetException, ParseException, 
		IOException
	{
		UrgotScenario itemScenario = new UrgotScenario(18);
		ItemObjects itemObjs = new ItemObjects();
		for (int i = 0; i < JSONitems.size(); i++)
		{
			String currentItem = (String)JSONitems.get(i);
			itemScenario.addItem(itemObjs.constructItemAndGetItem(currentItem));
		}
	
		return itemScenario;
	}

	

	
	private UrgotScenario makeScenarioFromJSONArrayWithLevel(JSONArray JSONitems, int urgotLevel) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException, IOException
	{
		UrgotScenario itemScenario = new UrgotScenario(urgotLevel);
		ItemObjects itemObjs = new ItemObjects();
		for (int i = 0; i < JSONitems.size(); i++)
		{
			String currentItem = (String)JSONitems.get(i);
			itemScenario.addItem(itemObjs.constructItemAndGetItem(currentItem));
		}
	
		return itemScenario;
	}
	
	/** 
	 * Extracts list of items from JSON file "ItemList";
	 * @return
	 * @throws IOException
	 */
	private static String readItemFile() throws IOException
	{
		String filePath = readFile("src/resources/JSON/urgotItemSets.json",
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
