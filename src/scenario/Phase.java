package scenario;

import java.util.ArrayList;

import runes.RuneSetup;


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
	 * This will be overridden by each individual Phase object.
	 * Based on the code input, a different comparison will be made.
	 * @param code
	 */
	public void runStatCollection(StatSetup setupCode)
	{
		
	}
	public void addScenarioLevel(String itemName, int currentLevel)
	{
		UrgotScenario currentScenario = new UrgotScenario(currentLevel);
		currentScenario.addItem(itemName);
		currentScenario.computeStats();
		if (currentLevel >= 6)
		{
			currentScenario.getUrgotCombos().lockOnWithUlt(currentLevel);
		}
		else
		{
			currentScenario.getUrgotCombos().lockOnNoUlt(currentLevel);
		}
		addScenario(currentScenario);
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
		if (currentLevel >= 6)
		{
			currentScenario.getUrgotCombos().lockOnWithUlt(currentLevel);
		}
		else
		{
			currentScenario.getUrgotCombos().lockOnNoUlt(currentLevel);
		}
		addScenario(currentScenario);
	}
	
	/**
	 * Adds an all-in ult scenario based on level.
	 * Scenarios are setup here, added, then their stats are computed.
	 * TODO: Does not prohibit under level 6 scenarios.
	 * @param itemNames
	 */
	public void addScenarioLevel(String[] itemNames, int currentLevel, RuneSetup runes)
	{
		UrgotScenario currentScenario = new UrgotScenario(currentLevel);
		for (String item: itemNames)
		{
			currentScenario.addItem(item);
		}
		currentScenario.addRunes(runes);
		currentScenario.computeStats();
		if (currentLevel >= 6)
		{
			currentScenario.getUrgotCombos().lockOnWithUlt(currentLevel);
		}
		else
		{
			currentScenario.getUrgotCombos().lockOnNoUlt(currentLevel);
		}
		addScenario(currentScenario);
	}
	

	

}
