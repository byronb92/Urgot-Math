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

import items.ItemObjects;
import scenario.ScenarioManager;
import scenario.UrgotScenario;

public class MakeScenariosFromJSON {
	private JSONParser parser;
	private HashMap<String, ?> mapCurrentBuildTypesProcessed;
	private HashMap<HashMap<BuildType,String>, HashMap<String, ScenarioManager>> 
		mapBuildTypesOfScenarioManagers;
	private HashMap<String, ScenarioManager> mapScenarioManagers;
	private static final String STARTING = "starting";
	private static final String DAMAGE = "damage";
	private static final String BRUISER = "bruiser";	
	private static final String TANKY = "tanky";

	public enum BuildType
	{
		ALL, STARTING, DAMAGE, BRUISER, TANKY
	}
	public ArrayList<ScenarioManager> 
		getAllManagersFromBuildType(BuildType buildType)
	{
		ArrayList<ScenarioManager> listScenarioManagers = 
				new ArrayList<ScenarioManager>();
		for(Entry<HashMap<BuildType,String> , HashMap<String, ScenarioManager>> item: 
			mapBuildTypesOfScenarioManagers.entrySet())
		{
			String scenarioManagerString = item.getKey().get(buildType);
			if (scenarioManagerString != null)
			{
				ScenarioManager currentManager =
						item.getValue().get(scenarioManagerString);
			 listScenarioManagers.add(currentManager);
			}
		}
		return listScenarioManagers;
	}
	public MakeScenariosFromJSON()
	{
		parser = new JSONParser();
		mapCurrentBuildTypesProcessed = new HashMap<String,String>();
		mapBuildTypesOfScenarioManagers = new HashMap<HashMap<BuildType,String>, 
				HashMap<String, ScenarioManager>>();
		mapScenarioManagers = new HashMap<String,ScenarioManager>();

	}
	
	public ArrayList<ScenarioManager> getAllManagersWithKey(BuildType buildType)
	{
		ArrayList<ScenarioManager> buildTypeScenarioManagers =
				new ArrayList<ScenarioManager>();
		HashMap<String,ScenarioManager> mapManager = mapBuildTypesOfScenarioManagers.get(buildType);
		for(Entry<String, ScenarioManager> managerPair: mapManager.entrySet())
		{
			buildTypeScenarioManagers.add(managerPair.getValue());
		}
		return buildTypeScenarioManagers;
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
				if (!mapCurrentBuildTypesProcessed.containsKey(STARTING)) 
				{
					buildTypeJSONObject = (JSONObject)obj.get(STARTING);
					mapCurrentBuildTypesProcessed.put(STARTING, null);
				}
				else 
				{
					return true;
				}
				break;
			case DAMAGE:
				buildTypeJSONObject = (JSONObject)obj.get(DAMAGE);
				break;
			case BRUISER:
				if (!mapCurrentBuildTypesProcessed.containsKey(BRUISER)) 
				{
					buildTypeJSONObject = (JSONObject)obj.get(BRUISER);
					mapCurrentBuildTypesProcessed.put(BRUISER, null);
				}
				else 
				{
					return true;
				}
				break;
			case TANKY:
				if (!mapCurrentBuildTypesProcessed.containsKey(TANKY)) 
				{
					mapCurrentBuildTypesProcessed.put(TANKY, null);
					buildTypeJSONObject = (JSONObject)obj.get(TANKY);
				}
				else
				{
					return true;
				}
				break;
			default:
				parseCompleteJSONFile();
				return true;
		}	
		HashMap<String,JSONArray> mapBuildTypes = new HashMap<String, JSONArray>();
		mapBuildTypes.putAll(buildTypeJSONObject);
		for(Entry<String, JSONArray> item: mapBuildTypes.entrySet())
		{
			addSceManagerToManagersListFromJSONArray(item.getValue(), item.getKey(), buildType);
		}
		
		return true;
	}
	
	//private boolean addMapBuildTypesProcessed(BuildType buildType)
	
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
				addSceManagerToManagersListFromJSONArray(itemB.getValue(), itemB.getKey(), BuildType.ALL);
			}
		}
		return true;
	}
	
	private boolean addSceManagerToManagersListFromJSONArray(
		JSONArray arrayJSON, String managerTag, BuildType buildType) throws 
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
		HashMap<BuildType,String> wtfPair = new HashMap<BuildType,String>();
		wtfPair.put(buildType, managerTag);
		mapBuildTypesOfScenarioManagers.put(wtfPair,mapScenarioManagers);
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
