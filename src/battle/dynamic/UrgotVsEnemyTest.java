package battle.dynamic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UrgotVsEnemyTest {

	private UrgotVsEnemy urgVs;
	@Before
	public void setUp() throws Exception {
		urgVs = new UrgotVsEnemy();
	}

	@Test
	// Numbers generated from test preset scenario.
	public void testThunderlordArmPen() {
		CompleteDamage dmg = urgVs.damageVsCustomEnemy(737, 144, 
				15.36, 0, 0.88, 60, 30, 650);
		System.out.println("Physical damage done: " + dmg.getPhysicalDamage());
		System.out.println("Magic damage done: " + dmg.getMagicDamage());
		
		CompleteDamage dmg2 = urgVs.damageVsCustomEnemy(820, 156, 
				0, 0, 0.88, 40, 30, 650);
		System.out.println("Non Arm Pen: Physical damage done: " + dmg2.getPhysicalDamage());
		System.out.println("Non Arm Pen: Magic damage done: " + dmg2.getMagicDamage());
	}

}
