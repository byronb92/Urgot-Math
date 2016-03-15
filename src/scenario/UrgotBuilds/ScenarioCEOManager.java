package scenario.UrgotBuilds;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.json.simple.parser.ParseException;

import scenario.ScenarioManager;
import scenario.UrgotScenario;
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
	
	public String outputGeneral()
	{
		for (ScenarioManager currentManager : sceCEO.getScenarioManagers())
		{
			// Append string onto string buffer.
			return outputGeneral(currentManager);
		}
		return null;
	}
	/** @return string containing statical overview of a scenario. */
	private String outputGeneral(ScenarioManager sceManager)
	{
		StringBuilder generalInfo = new StringBuilder();
		for (UrgotScenario sce : sceManager.getScenarios())
		{
			generalInfo.append(sce.getScenarioName() + "\n");
			generalInfo.append(sceManager.getScenarioItems(sce));
			generalInfo.append("\n");
			generalInfo.append("Cost: " + sceManager.getScenarioCost(sce));
			generalInfo.append("\n");
			generalInfo.append("Raw Damage: " + sceManager.getRawDamage(sce) + "\n");
			generalInfo.append("Physical Damage: " + sce.getBattleStats().getPhysicalDamage() + "\n");
			generalInfo.append("Magic Damage Damage: " + sce.getBattleStats().getMagicDamage() + "\n");
			generalInfo.append("\nOffense: \n");
			generalInfo.append(sceManager.getOffensiveStats(sce));
			generalInfo.append("\nDefense: \n");
			generalInfo.append(sceManager.getDefensiveStats(sce));
			generalInfo.append("\nSustain: \n");
			generalInfo.append(sceManager.getSustainStats(sce));
			generalInfo.append("---------------");
			generalInfo.append("\n");
		}
		return generalInfo.toString();
	}

	

}