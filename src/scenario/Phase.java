package scenario;

import java.util.ArrayList;

public class Phase {
	
	
	private ArrayList<UrgotScenario> listScenarios;
	public Phase()
	{
		listScenarios = new ArrayList<UrgotScenario>();
	}
	
	public void addScenario(UrgotScenario sce)
	{
		listScenarios.add(sce);
	}
	
	public ArrayList<UrgotScenario> getScenarios()
	{
		return listScenarios;
	}
	
	
	/**
	 * Adds an all-in ult scenario based on level.
	 * TODO: Does not prohibit under level 6 scenarios.
	 * @param itemNames
	 */
	public void addScenarioLevel(String[] itemNames, int currentLevel)
	{
		UrgotScenario currentScenario = new UrgotScenario(currentLevel);
		for (String item: itemNames)
		{
			currentScenario.addItem(item);
		}
		currentScenario.computeStats();
		currentScenario.getUrgotCombos().lockOnWithUlt(currentLevel);
		addScenario(currentScenario);
	}
	

	

}
