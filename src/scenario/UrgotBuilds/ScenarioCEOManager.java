package scenario.UrgotBuilds;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.json.simple.parser.ParseException;

import battle.BattleSetup;
import battle.SkillRankType;
import scenario.ScenarioManager;
import scenario.SortRank;
import scenario.UrgotScenario;
import scenario.UrgotBuilds.MakeScenariosFromJSON.BuildType;

public class ScenarioCEOManager {
	
	private ScenarioCEO sceCEO;
	private MakeScenariosFromJSON scenariosFromJSON;
	
	public ScenarioCEOManager()
	{
		sceCEO = new ScenarioCEO();
		scenariosFromJSON = new MakeScenariosFromJSON();
	}
	
	public ArrayList<ScenarioManager> getScenarioManagers()
	{
		return sceCEO.getScenarioManagers();
	}
	
	public void computeStatsAndBattleScenario(BattleSetup battleSetup, SkillRankType rankType)
	{
		for (ScenarioManager currentManager : sceCEO.getScenarioManagers())
		{
			currentManager.computeStatsAndBattleScenario(battleSetup, rankType);
		}
	}
	public boolean addScenariosByBuildType(BuildType buildType) throws ClassNotFoundException, 
		NoSuchMethodException, SecurityException, InstantiationException, 
		IllegalAccessException, IllegalArgumentException, InvocationTargetException, 
		IOException, ParseException
	{
		scenariosFromJSON.parseJSONByBuildType(buildType);
		for (ScenarioManager currentSceManager : 
			scenariosFromJSON.getAllManagersFromBuildType(buildType))
		{
			
			sceCEO.addScenarioManager(currentSceManager);
		}
		return true;
	}
	
	public String outputGeneral()
	{
		StringBuilder outputGeneral = new StringBuilder();
		for (ScenarioManager currentManager : getScenarioManagers())
		{
			outputGeneral.append(outputGeneral(currentManager) + "\n\n");
		}
		return outputGeneral.toString();
	}
	/** @return string containing statistical overview of a scenario. */
	private String outputGeneral(ScenarioManager sceManager)
	{
		StringBuilder generalInfo = new StringBuilder();
		for (UrgotScenario sce : sceManager.getScenarios())
		{
			generalInfo.append(sce.getScenarioName() + "\n");
			generalInfo.append(sceManager.getScenarioItems(sce));
			generalInfo.append("\n");
			generalInfo.append("Cost: " + sceManager.getScenarioCost(sce));
			generalInfo.append("\n");
			generalInfo.append("Raw Damage: " + sceManager.getRawDamage(sce) + "\n");
			generalInfo.append("Physical Damage: " + sce.getBattleStats().getPhysicalDamage() + "\n");
			generalInfo.append("Magic Damage Damage: " + sce.getBattleStats().getMagicDamage() + "\n");
			generalInfo.append("\nOffense: \n");
			generalInfo.append(sceManager.getOffensiveStats(sce));
			generalInfo.append("\nDefense: \n");
			generalInfo.append(sceManager.getDefensiveStats(sce));
			generalInfo.append("\nSustain: \n");
			generalInfo.append(sceManager.getSustainStats(sce));
			generalInfo.append("---------------");
			generalInfo.append("\n");
		}
		return generalInfo.toString();
	}

	
	public Map<Double,UrgotScenario> sortDamage(SortRank rank)
	{
		HashMap<Double,UrgotScenario> map = new HashMap<Double,UrgotScenario>();
		ArrayList<UrgotScenario> allScenarios = new ArrayList<UrgotScenario>();
		for (ScenarioManager currentManager : getScenarioManagers())
		{
			allScenarios.addAll(currentManager.getScenarios());
		}

		for (UrgotScenario sce : allScenarios)
		{
			double rawDmg = sce.getBattleStats().getTotalDamage();
			map.put(makeKeyUnique(map,rawDmg), sce);
		}
		Map<Double,UrgotScenario> newMap = null;
		if (rank == SortRank.ASCENDING)
		{
			newMap = new TreeMap<Double, UrgotScenario>(map);
			return newMap;
		}
		newMap = new TreeMap<Double, UrgotScenario>(Collections.reverseOrder());
		newMap.putAll(map);
		return newMap;
	}
	
	/**
	 * Takes care of duplicate cases inserted into maps, by making them differentiate slightly.
	 * @param map
	 * @param key
	 * @return
	 */
	private double makeKeyUnique(Map<?,?> map, Double key)
	{
		boolean isUnique = false;
		double currentValue = key;
		while (!isUnique)
		{
			if (map.containsKey(currentValue))
			{
				currentValue = currentValue + 0.0001;
			}
			else
			{
				isUnique = true;
			}
		}
		return currentValue;

	}
	
	public UrgotScenario damageVsHPDifferenceArmor()
	{
		UrgotScenario bestBalancedScenario = null;
		for (ScenarioManager currentManager : getScenarioManagers())
		{
			if (bestBalancedScenario == null)
			{
				bestBalancedScenario = currentManager.damageVsHPDifferenceArmor();
			}
			else
			{
				UrgotScenario intermediateScenario = currentManager.damageVsHPDifferenceArmor();
				bestBalancedScenario = currentManager.damageVsHPDifferenceArmor(
						intermediateScenario, bestBalancedScenario);
			}
		}
		return bestBalancedScenario;
	}

}
