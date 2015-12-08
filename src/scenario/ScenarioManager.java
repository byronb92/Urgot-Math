package scenario;

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
	public void armorPenVSAD()
	{
		early = new EarlyGame();
		early.CaulfieldVsDirk();
		addAllScenarios(early.getScenarios());
	}
	public void sheenDamage()
	{
		early = new EarlyGame();
		early.earlySheenDamage();
		addAllScenarios(early.getScenarios());
	}
	public void GhostbladeVsClear()
	{
		early = new EarlyGame();
		early.ghostbladeVsCleaver();
		addAllScenarios(early.getScenarios());
	}
	
	// ----- Mid Game Setup -----
	public void midSetup()
	{
		mid = new MidGame();
		//mid.compareBestThreeItems();
		mid.compareBruiser();
		addAllScenarios(mid.getScenarios());
	}
	// ----- Late Game Setup -----
	public void lateSetup()
	{
		late = new LateGame();
		//mid.compareBestThreeItems();
		late.compareFullBuilds();
		addAllScenarios(late.getScenarios());
	}
	private void addAllScenarios(ArrayList<UrgotScenario> smallList)
	{
		listAllScenarios.addAll(smallList);
	}
	
	public ArrayList<UrgotScenario> getScenarios()
	{
		return listAllScenarios;
	}
	


}
