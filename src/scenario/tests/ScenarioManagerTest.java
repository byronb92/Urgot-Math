package scenario.tests;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import battle.BattleSetup;
import battle.SkillRankType;
import scenario.ScenarioManager;
import scenario.UrgotScenario;

public class ScenarioManagerTest {
	
	private ScenarioManager sceManage;
	@Before
	public void setUp() throws Exception {
		sceManage = new ScenarioManager();
	}

	@Test
	public void testEarlyRawDamage() {
		sceManage.battleCollection(BattleSetup.ALLIN_NOULT, SkillRankType.STANDARD);
		sceManage.findHighestRawDamage();
		
	}
	
	@Test
	public void testBestFirstItem() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, CloneNotSupportedException, ParseException, IOException {
		UrgotScenario sceA = new UrgotScenario(6);
		//UrgotScenario sceB = sceManage.bestDamageItemToAdd(sceA, "Starting");
		UrgotScenario sceB;
		//System.out.println(sceB.getScenarioName());
		
		int wow = 0;
		while (wow < 5)
		{
			sceB = sceManage.bestDamageItemToAdd(sceA, "Starting");
			sceA.addItem(sceB.getScenarioName());
			System.out.println("Item " + wow + ": " + sceB.getScenarioName());
			wow++;
		}
		System.out.println(sceManage.getScenarioItems(sceA));
	}
	

}
