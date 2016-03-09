package scenario.UrgotBuilds;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import items.ItemObjects;
import scenario.ScenarioManager;
import scenario.UrgotScenario;

public class MakeScenariosFromJSON {
	private JSONParser parser;
	private HashMap<String, ScenarioManager> mapScenarioManagers;
	private static final String STARTING_ITEMS = "starting";
	
	private static final String DAMAGE = "damage";
	private static final String DAMAGE_RISKY = "Risky Damage Builds";
	private static final String DAMAGE_TRADITIONAL = "Traditional Damage Builds";
	
	private static final String BRUISER = "bruiser";
	private static final String BRUISER_DUELIST = "Duelist Bruiser Builds";
	private static final String BRUISER_BURST = "Duelist Against Burst Bruiser Builds";
	
	private static final String TANKY = "tanky";
	private static final String TANK_ARMOR = "Anti-AD Builds";
	private static final String TANK_MAGIC = "Anti-Magic Builds";

	public MakeScenariosFromJSON()
	{
		parser = new JSONParser();
		mapScenarioManagers = new HashMap<String,ScenarioManager>();
	}
	
	public enum parseType
	{
		ALL, DAMAGE, BRUISER, TANKY
	}
	private void parseCompleteJSONFile() throws ParseException, IOException, ClassNotFoundException, 
		NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, 
		IllegalArgumentException, InvocationTargetException
	{
		String itemsFile = readItemFile();
		JSONObject obj = (JSONObject)parser.parse(itemsFile);
		JSONArray starting = (JSONArray)obj.get("starting");
		ScenarioManager startingItems = new ScenarioManager();
		startingItems.addAllScenarios(makeListOfScenariosFromJSONLevel(starting,1));
		
		
		JSONObject damage = (JSONObject)obj.get(DAMAGE);
		JSONArray damageRisky = (JSONArray)damage.get(DAMAGE_RISKY);
		JSONArray damageTraditional = (JSONArray)damage.get(DAMAGE_TRADITIONAL);
		createManagerWithJSONArray(damageRisky, DAMAGE_RISKY);
		createManagerWithJSONArray(damageTraditional, DAMAGE_TRADITIONAL);
		
		
		JSONObject bruiser = (JSONObject)obj.get(BRUISER);
		JSONArray bruiserDuelist = (JSONArray)bruiser.get(BRUISER_DUELIST);
		JSONArray bruiserVsBurst = (JSONArray)bruiser.get(BRUISER_BURST);
		createManagerWithJSONArray(bruiserDuelist, BRUISER_DUELIST);
		createManagerWithJSONArray(bruiserVsBurst, BRUISER_BURST);
		
		JSONObject tanky = (JSONObject)obj.get(TANKY);
		JSONArray tankyArmor = (JSONArray)tanky.get(TANK_ARMOR);
		JSONArray tankyMagic = (JSONArray)tanky.get(TANK_MAGIC);
		createManagerWithJSONArray(tankyArmor, TANK_ARMOR);
		createManagerWithJSONArray(tankyMagic, TANK_MAGIC);
	}
	
	
	private boolean createManagerWithJSONArray(JSONArray arrayJSON, String managerTag) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException, IOException
	{
		ScenarioManager currentSceManager = new ScenarioManager();
		currentSceManager.setScenarioManagerName(managerTag);
		currentSceManager.addAllScenarios(makeListOfScenariosFromJSON(arrayJSON));
		mapScenarioManagers.put(managerTag,currentSceManager);
		return true;
	}
	private ArrayList<UrgotScenario> makeListOfScenariosFromJSONLevel(JSONArray JSONitems, int urgLevel) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException, IOException
	{
		ArrayList<UrgotScenario> urgList = new ArrayList<UrgotScenario>();
		for (int i =0; i < JSONitems.size(); i++)
		{
			JSONArray currentArray = (JSONArray)JSONitems.get(i);
			urgList.add(makeScenarioFromItemArray(currentArray, urgLevel));
		}
		return urgList;
	}
	
	private ArrayList<UrgotScenario> makeListOfScenariosFromJSON(JSONArray JSONitems) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException, IOException
	{
		ArrayList<UrgotScenario> urgList = new ArrayList<UrgotScenario>();
		for (int i =0; i < JSONitems.size(); i++)
		{
			JSONArray currentArray = (JSONArray)JSONitems.get(i);
			urgList.add(makeScenarioFromItemArrayFullBuild(currentArray));
		}
		return urgList;
	}
	
	private UrgotScenario makeScenarioFromItemArrayFullBuild(JSONArray JSONitems) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException, IOException
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
	private UrgotScenario makeScenarioFromItemArray(JSONArray JSONitems, int urgLevel) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException, IOException
	{
		UrgotScenario itemScenario = new UrgotScenario(urgLevel);
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
