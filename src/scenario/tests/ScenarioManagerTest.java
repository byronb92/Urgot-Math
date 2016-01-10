package scenario.tests;


import org.junit.Before;
import org.junit.Test;

import scenario.ScenarioManager;
import scenario.StatSetup;

public class ScenarioManagerTest {
	
	private ScenarioManager sceManage;
	@Before
	public void setUp() throws Exception {
		sceManage = new ScenarioManager();
	}

	@Test
	public void testEarlyRawDamage() {
		sceManage.setUpStatCollection(StatSetup.LEVEL6);
		System.out.println(sceManage.findHighestRawDamage().getBattleStats().getPhysicalDamage());
	}
	

}
