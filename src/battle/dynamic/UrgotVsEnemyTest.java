package battle.dynamic;


import org.junit.Before;
import org.junit.Test;

public class UrgotVsEnemyTest {

	private UrgotVsEnemy urgVs;
	@Before
	public void setUp() throws Exception {
		urgVs = new UrgotVsEnemy();
	}

	@Test
	/** Level 4 Thunderlord AD vs Thunderlord Arm Pen
	 * Thunderlord + AD:
	 * 		726.12 AD Dealt
	 * 		47.59 AP Dealt
	 * 		Armor Reduction: 88%
	 * Thunderlord + Full Arm Pen Runes
	 * 		632.02 AD Dealt
	 * 		43 AP Dealt
	 * 		Armor Reduction: 88%
	 * 		Flat Armor Pen: 19.2
	 */
	public void testThunderlordArmPen() {
		ResistanceModifiers thundAD = urgVs.aggregrateResistanceMods(
				"Thunderlord with AD", 
				0, 0.88, 
				0.0, 0, 0, 
				0, 0, 0, 0);
		ResistanceModifiers thundArmPen = urgVs.aggregrateResistanceMods(
				"Thunderlord with Arm Pen", 
				0, 0.88, 
				0, 0, 19.2, 
				0, 0, 0, 0);
		
		CompleteDamage thundAd_Damage = urgVs.damageVsEnemy(thundAD, 726.12, 47.59, 
				30, 10, 30, 0);
		
		CompleteDamage thundArmpen_Damage = urgVs.damageVsEnemy(thundArmPen, 632.02, 43, 
				30, 10, 30, 0);
	}

}
