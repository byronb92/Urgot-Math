package scenario.UrgotBuilds;

import static org.junit.Assert.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import scenario.ScenarioManager;
import scenario.UrgotBuilds.MakeScenariosFromJSON.BuildType;

public class ScenarioCEOManagerTest {
	private ScenarioCEOManager sceCEOManager;
	@Before
	public void setUp() throws Exception {
		sceCEOManager = new ScenarioCEOManager();
	}

	
	public String getItemListAsStringFromEachScenarioManager()
	{
		StringBuilder allManagerItemLists = new StringBuilder();
		for (ScenarioManager currentManager : sceCEOManager.getScenarioManagers())
		{
			allManagerItemLists.append("Manager name: " + 
					currentManager.getScenarioManagerName() + "\n" );
			allManagerItemLists.append(currentManager.getAllScenarioItems());
		}
		return allManagerItemLists.toString();
				
	}
	
	@Test
	public void testOutputItemListToConsole() throws 
		ClassNotFoundException, NoSuchMethodException, SecurityException, 
		InstantiationException, IllegalAccessException, IllegalArgumentException, 
		InvocationTargetException, IOException, ParseException
	{
		System.out.println("Complete list of items contained in Damage Scenario Managers");
		sceCEOManager.addScenariosByBuildType(BuildType.DAMAGE);
		System.out.println(getItemListAsStringFromEachScenarioManager());
	}
}
