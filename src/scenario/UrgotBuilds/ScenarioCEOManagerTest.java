package scenario.UrgotBuilds;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map.Entry;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import battle.BattleSetup;
import battle.SkillRankType;
import scenario.ScenarioManager;
import scenario.ScenarioUtilities;
import scenario.SortRank;
import scenario.UrgotScenario;
import scenario.UrgotBuilds.MakeScenariosFromJSON.BuildType;

public class ScenarioCEOManagerTest {
	private ScenarioCEOManager sceCEOManager;
	@Before
	public void setUp() throws Exception {
		sceCEOManager = new ScenarioCEOManager();
	}

	
	public String getItemListAsStringFromEachScenarioManager()
	{
		StringBuilder allManagerItemLists = new StringBuilder();
		for (ScenarioManager currentManager : sceCEOManager.getScenarioManagers())
		{
			allManagerItemLists.append("Manager name: " + 
					currentManager.getScenarioManagerName() + "\n" );
			allManagerItemLists.append(currentManager.getAllScenarioItems());
		}
		return allManagerItemLists.toString();
				
	}
	

	/** 
	 * Sorts all scenarios by highest or lowest RAW damage.
	 * @param rank SortRank enum that sorts in ascending or descending order
	 * @return String of sorted scenarios by raw damage.
	 */
	public String outputSortedDamage(SortRank rank)
	{
		StringBuilder dmgString = new StringBuilder();
		for (Entry<Double, UrgotScenario> entry : sceCEOManager.sortDamage(rank).entrySet())
		{
			dmgString.append("Raw Damage: " + entry.getKey());
			dmgString.append(" " + entry.getValue().getScenarioName());
			dmgString.append("\n");
		}
		return dmgString.toString();
	}
	
	//@Test
	public void testOutputItemListToConsole() throws 
		ClassNotFoundException, NoSuchMethodException, SecurityException, 
		InstantiationException, IllegalAccessException, IllegalArgumentException, 
		InvocationTargetException, IOException, ParseException
	{
		System.out.println("Complete list of items contained in Damage Scenario Managers");
		sceCEOManager.addScenariosByBuildType(BuildType.DAMAGE);
		System.out.println(getItemListAsStringFromEachScenarioManager());
	}
	public void testOutput_GeneralToConsole() throws ClassNotFoundException, 
	NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException, IOException, ParseException
	{
		System.out.println("Super general output.");
		sceCEOManager.addScenariosByBuildType(BuildType.DAMAGE);
		sceCEOManager.computeStatsAndBattleScenario(BattleSetup.ALLIN_ULT, SkillRankType.STANDARD);
		System.out.println(sceCEOManager.outputGeneral());
	}
	
	@Test
	public void testOutput_GeneralTankyToConsole() throws ClassNotFoundException, 
	NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException, IOException, ParseException
	{
		System.out.println("Super general output for tanky items.");
		sceCEOManager.addScenariosByBuildType(BuildType.TANKY);
		sceCEOManager.computeStatsAndBattleScenario(BattleSetup.ALLIN_ULT, SkillRankType.STANDARD);
		System.out.println(sceCEOManager.outputGeneral());
	}
	
	public void testOutput_SortedDamageToConsole() throws ClassNotFoundException, 
	NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException, IOException, ParseException
	{
		System.out.println("Super general output.");
		sceCEOManager.addScenariosByBuildType(BuildType.DAMAGE);
		sceCEOManager.computeStatsAndBattleScenario(BattleSetup.ALLIN_ULT, SkillRankType.STANDARD);
		System.out.println(outputSortedDamage(SortRank.ASCENDING));
	}
	
	public void testOutput_DamageBalanced() throws ClassNotFoundException, 
	NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException, IOException, ParseException
	{
		System.out.println("New damage vs tank calculator.");
		sceCEOManager.addScenariosByBuildType(BuildType.DAMAGE);
		sceCEOManager.computeStatsAndBattleScenario(BattleSetup.ALLIN_ULT, SkillRankType.STANDARD);
		System.out.println(ScenarioUtilities.getScenarioItems(
				sceCEOManager.damageVsHPDifferenceArmor()));
	}
}
