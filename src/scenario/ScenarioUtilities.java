package scenario;

public class ScenarioUtilities {

	/**
	 * Creates an Urgot Scenario from a comma separated item list.
	 * @param itemsList Full item name as displayed in league of legends game.
	 * @return
	 */
	public static UrgotScenario scenarioFromItemString(String itemsList, int urgotLevel)
	{
		String[] itemArray = itemsList.split(",");
		UrgotScenario currentScenario = new UrgotScenario(urgotLevel);
		for (String currentItem : itemArray)
		{
			currentScenario.addItem(currentItem);
		}
		return currentScenario;
	}

}
