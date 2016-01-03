package urgot.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import urgot.UrgotStats;

public class UrgotStatsTest {

	UrgotStats urgot;
	@Before
	public void setUp() throws Exception {
		urgot = new UrgotStats(1);
	}

	@Test
	// Used to ensure CDR doesn't exceed 40%, or 45% when the Intelligence mastery is used.
	public void testCDR() {
		urgot.addCDR(0.45);
		assertEquals(0.4, urgot.getCDR(), 0.01);
		urgot.increaseCDRCap();
		urgot.addCDR(0.30);
		assertEquals(0.45, urgot.getCDR(), 0.01);
	}
	
	@Test
	public void testHealthRegen() {
		urgot.addBonusHealthRegen(2);
		assertEquals(8.5, urgot.getTotalHPRegen(), 0.01);
	}

}
