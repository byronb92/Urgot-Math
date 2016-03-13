package scenario.UrgotBuilds;

import java.util.ArrayList;

import scenario.ScenarioManager;

public class ScenarioCEO {
	
	private ArrayList<ScenarioManager> listAllScenarioManagers;
	
	public ScenarioCEO()
	{
		listAllScenarioManagers = new ArrayList<ScenarioManager>();
	}
	
	public ArrayList<ScenarioManager> getScenarioManagers()
	{
		return listAllScenarioManagers;
	}
	public void addScenarioManager(ScenarioManager sceManager)
	{
		listAllScenarioManagers.add(sceManager);
	}
}
