package battle.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import battle.BattleManager;
import battle.BattleSetup;
import battle.SkillRankType;
import urgot.UrgotStats;

public class BattleSetupTests {
	BattleManager battleM;
	@Before
	public void setUp() throws Exception {	
	}

	@Test
	public void testAutotrade() {
		UrgotStats urgot = new UrgotStats(1);
		battleM = new BattleManager(urgot);
		battleM.battleSetup(BattleSetup.AUTOTRADE, SkillRankType.TRADE);
		battleM.runBattleCalculations();
		assertEquals(battleM.getBattle().getPhysicalAttacks(),3);
	}
	
	public void testAutotrade_No_W() {
		fail("Not yet implemented");
	}

	public void testPoke() {
		fail("Not yet implemented");
	}

	public void testPokeAutoWeave() {
		fail("Not yet implemented");
	}
	
	public void testPokeExtended() {
		fail("Not yet implemented");
	}
	
	public void testPokeCombo() {
		fail("Not yet implemented");
	}
	
	public void testAllIn_Ult() {
		fail("Not yet implemented");
	}
	public void testAllIn_NoUlt() {
		fail("Not yet implemented");
	}
	
	

}
