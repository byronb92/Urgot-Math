package masteries.aa.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import masteries.MasteryManager;
import masteries.MasterySet;
import urgot.UrgotStats;

public class MasteryManagerTest {
	private UrgotStats urg;
	private MasteryManager manager;
	@Before
	public void setUp() throws Exception {
		urg = new UrgotStats(4);
		manager = new MasteryManager(urg);
	}

	@Test
	public void testSetup() {
		manager.masterySetup(MasterySet.DEATHFIRE_BALANCED);
		manager.computeMasteryStats();
	}

}
