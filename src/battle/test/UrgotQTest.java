package battle.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UrgotQTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testQMath() {
		double spellRank = 2;
		double totalAD = 0;
		double baseDamage = 30 * (spellRank - 1);
		double scalingDamage = totalAD * 0.85;
		double totalDamage = 10 + baseDamage + scalingDamage;
		assertEquals(40, totalDamage, 0.01);
		
	}

}
