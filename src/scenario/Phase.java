package scenario;

import java.util.ArrayList;



public abstract class Phase {
		
	private ArrayList<UrgotScenario> listScenarios;
	public Phase()
	{
		listScenarios = new ArrayList<UrgotScenario>();
	}
	
	public void addScenario(UrgotScenario sce)
	{
		listScenarios.add(sce);
	}
	
	public void addScenario(UrgotScenario sce, String scenarioName)
	{
		sce.setScenarioName(scenarioName);
		listScenarios.add(sce);
	}
	
	public ArrayList<UrgotScenario> getScenarios()
	{
		return listScenarios;
	}
	
	/**
	 * This will be overridden by each individual Phase object.
	 * Based on the code input, a different comparison will be made.
	 * @param code
	 */
	public abstract void runStatCollection(StatSetup setupCode);
	
	
	public void addScenarioLevel(String itemName, int currentLevel, String scenarioName)
	{
		UrgotScenario currentScenario = new UrgotScenario(currentLevel);
		currentScenario.addItem(itemName);
		addScenario(currentScenario, scenarioName);
	}
	
	public void addScenarioLevel(String[] itemNames, int currentLevel)
	{
		UrgotScenario currentScenario = new UrgotScenario(currentLevel);
		for (String item: itemNames)
		{
			currentScenario.addItem(item);
		}
		addScenario(currentScenario);
	}
	
	public void addScenarioLevel(String[] itemNames, int currentLevel, String sceName)
	{
		UrgotScenario currentScenario = new UrgotScenario(currentLevel);
		for (String item: itemNames)
		{
			currentScenario.addItem(item);
		}
		currentScenario.setScenarioName(sceName);
		addScenario(currentScenario);
	}
}
