package battle.dynamic;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UrgotVsEnemyTest {

	private DynamicDamageVSEnemy urgVs;
	@Before
	public void setUp() throws Exception {
		urgVs = new DynamicDamageVSEnemy();
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
//		DynamicResistModifier thundAD = urgVs.aggregrateResistanceMods(
//				"Thunderlord with AD", 
//				0, 0.88, 
//				0.0, 0, 0, 
//				0, 0, 0, 0);
//		DynamicResistModifier thundArmPen = urgVs.aggregrateResistanceMods(
//				"Thunderlord with Arm Pen", 
//				0, 0.88, 
//				0, 0, 19.2, 
//				0, 0, 0, 0);
//		
//		DynamicCompleteDamage thundAd_Damage = urgVs.damageVsEnemy(thundAD, 726.12, 47.59, 
//				30, 10, 30, 0);
//		
//		DynamicCompleteDamage thundArmPen_Damage = urgVs.damageVsEnemy(thundArmPen, 632.02, 43, 
//				30, 10, 30, 0);
//		
//		DynamicCompleteDamage highestDmg = urgVs.findHighestRealDamageFromTwoDamageObjects(
//				thundAd_Damage, thundArmPen_Damage);
//		
//		assertEquals("Thunderlord with Arm Pen", highestDmg.getName());
	}

}
