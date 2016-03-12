package scenario.UrgotBuilds;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.json.simple.parser.ParseException;

import scenario.ScenarioManager;
import scenario.UrgotBuilds.MakeScenariosFromJSON.BuildType;

public class ScenarioCEOManager {
	
	private ScenarioCEO sceCEO;
	private MakeScenariosFromJSON scenariosFromJSON;
	
	public ScenarioCEOManager()
	{
		sceCEO = new ScenarioCEO();
		scenariosFromJSON = new MakeScenariosFromJSON();
	}
	
	public boolean addScenariosByBuildType(BuildType buildType) throws ClassNotFoundException, 
		NoSuchMethodException, SecurityException, InstantiationException, 
		IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
		IOException, ParseException
	{
		scenariosFromJSON.parseJSONByBuildType(buildType);
		for (ScenarioManager currentSceManager : 
			scenariosFromJSON.getAllManagersFromBuildType(buildType))
		{
			
			sceCEO.addScenarioManager(currentSceManager);
		}
		return true;
	}
	

}
