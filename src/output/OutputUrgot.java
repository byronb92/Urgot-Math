package output;

import masteries.MasterySet;
import runes.RuneSetup;
import scenario.UrgotScenario;

public class OutputUrgot {
	/** Provides ability to apply stats on a single urgot instance.
	 * @param runes RuneSetup enum specifying runes to be added.
	 * @param masteries MasterySet enum specifying masteries to be added.
	 */
	public void setUpSingleUrgot(String itemsString, int urgotLevel,
			RuneSetup runes, MasterySet masteries)
	{
		if (urgotLevel > 18)
		{
			System.err.println("Invalid level: " + urgotLevel);
		}
		UrgotScenario currentSce = new UrgotScenario(urgotLevel);
		// Comma seperated list of strings.
		String[] itemsStringArray = itemsString.split(",");
		for (String item : itemsStringArray)
		{
			currentSce.addItem(item);
		}
		currentSce.setUpRunesAndMasteries(runes, masteries);
		currentSce.computeStats();
	}
}
