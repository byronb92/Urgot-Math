package battle.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import battle.BattleManager;
import battle.BattleSetup;
import battle.SkillRankType;
import urgot.UrgotStats;

public class BattleSetupTests {
	private BattleManager battleM;
	private UrgotStats urgot;
	@Before
	public void setUp() throws Exception {
		urgot = new UrgotStats(1);
		battleM = new BattleManager(urgot);
	}

	@Test
	public void testAutotrade() {
		battleM = new BattleManager(urgot);
		battleM.battleSetup(BattleSetup.AUTOTRADE, SkillRankType.TRADE);
		battleM.runBattleCalculations();
		assertEquals(battleM.getBattle().getPhysicalAttacks(),3); 
	}
	
	public void testAutotrade_No_W() {
		battleM.battleSetup(BattleSetup.AUTOTRADE, SkillRankType.STANDARD);
		battleM.runBattleCalculations();
		// Ensures W isn't casted, which is Urgot's Shield.
		assertEquals(battleM.getBattle().getShieldPoints(), 0, 0.01);
	}

	public void testPoke() {
		battleM.battleSetup(BattleSetup.POKE, SkillRankType.STANDARD);
		battleM.runBattleCalculations();
		assertEquals(battleM.getBattle().getSpellsCast(), 1);
	}

	public void testPokeAutoWeave() {
		battleM.battleSetup(BattleSetup.POKE_AUTOWEAVE, SkillRankType.STANDARD);
		battleM.runBattleCalculations();
		fail("Not yet implemented");
	}
	
	public void testPokeExtended() {
		battleM.battleSetup(BattleSetup.POKE_EXTENDED, SkillRankType.STANDARD);
		battleM.runBattleCalculations();
		fail("Not yet implemented");
	}
	
	public void testPokeCombo() {
		urgot = new UrgotStats(4);
		battleM.battleSetup(BattleSetup.POKE_COMBO, SkillRankType.STANDARD);
		battleM.runBattleCalculations();
		fail("Not yet implemented");
	}
	
	public void testAllIn_Ult() {
		urgot = new UrgotStats(6);
		battleM.battleSetup(BattleSetup.ALLIN_ULT, SkillRankType.STANDARD);
		battleM.runBattleCalculations();
		fail("Not yet implemented");
	}
	public void testAllIn_NoUlt() {
		urgot = new UrgotStats(6);
		battleM.battleSetup(BattleSetup.ALLIN_NOULT, SkillRankType.STANDARD);
		battleM.runBattleCalculations();
		fail("Not yet implemented");
	}
	
	

}
