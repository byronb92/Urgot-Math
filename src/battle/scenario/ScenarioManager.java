package battle.scenario;

import java.util.ArrayList;

public class ScenarioManager {
	
	EarlyGame early;
	MidGame mid;
	LateGame late;
	
	/**
	 * Create UrgotScenario.
	 * Use EarlyGame/MidGame/lateGame to setup the Scenario.
	 * 		Call UrgotScenario(level)
	 * 		Add an item to the scenario
	 * 		Compute the stats
	 * Use ScenarioManager to add the Scenario into the listUrgots
	 * 
	 */
	private ArrayList<UrgotScenario> listAllScenarios;
	
	public ScenarioManager()
	{
		listAllScenarios = new ArrayList<UrgotScenario>();
	}
	
	
	// ----- Early Game Setup -----
	public void earlySetup()
	{
		early = new EarlyGame();
		early.levelSixCompare();
		addAllScenarios(early.getScenarios());
	}
	// ----- Mid Game Setup -----
	// ----- Late Game Setup -----
	private void addAllScenarios(ArrayList<UrgotScenario> smallList)
	{
		listAllScenarios.addAll(smallList);
	}
	
	public ArrayList<UrgotScenario> getScenarios()
	{
		return listAllScenarios;
	}
	


}
