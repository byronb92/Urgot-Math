package items.test;


import org.junit.Before;
import org.junit.Test;

import items.items.Muramana;


public class MuramanaTest {

	Muramana muramana;
	@Before
	public void setUp() throws Exception {
		muramana = new Muramana();
	}

	@Test
	public void testMuramanaStats() {
		System.out.println(muramana.getBonusManaRegen());

	}

}
