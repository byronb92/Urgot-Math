package scenario;

import java.util.HashMap;

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
	
	public static HashMap<String,Double> mapOfArmorMods(UrgotScenario sce)
	{
		HashMap<String,Double> mapOfArmorMods = new HashMap<String,Double>();
		// TODO: Add flat armor reduction to UrgotStats.
		mapOfArmorMods.put("ArmorReductionFlat",sce.getUrgotStats().getFlatArmorReduc());
		mapOfArmorMods.put("ArmorReductionPercent",sce.getUrgotStats().getPercentArmorReduc());
		mapOfArmorMods.put("ArmorPenFlat",sce.getUrgotStats().getFlatArmorPen());
		mapOfArmorMods.put("ArmorPenBonusPercent",sce.getUrgotStats().getBonusPercentArmorPen());
		mapOfArmorMods.put("ArmorPenPercent",sce.getUrgotStats().getPercentArmorPen());
		return mapOfArmorMods;
	}

}
