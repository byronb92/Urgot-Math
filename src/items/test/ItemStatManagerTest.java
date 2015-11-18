package items.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import items.ItemManager;
import urgot.UrgotStats;

public class ItemStatManagerTest {

	ItemManager statManager;
	@Before
	public void setUp() throws Exception {
		//statManager = new ItemStatManager();
	}

	@Test
	public void testItemSetOne() {
		statManager.applyItemSet(1);
		statManager.computeItemStats();
		UrgotStats urgot = statManager.getUrgotStats();
		
		// Level 6 Base A				= 78.072
		// Manamune AD For Mana 		= 24.748
		// Manamune Base AD				= 25
		// Total AD						= 127.82
		// Debugging.
		System.out.println("Item set one debugging:");
		System.out.println("Base AD: " + urgot.getBaseAD());
		System.out.println("AD Per Level: " + urgot.getADPerLevel());
		System.out.println("Bonus AD: " + urgot.getBonusAD());
		System.out.println("Current Mana: " + urgot.getTotalMana());
		System.out.println("2% of current mana: " + urgot.getTotalMana() * 0.02);
		assertEquals(127.82, urgot.getTotalAD(), 1);
		
		

	}

}
