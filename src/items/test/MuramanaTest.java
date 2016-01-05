package items.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import items.items.Muramana;
import scenario.UrgotScenario;
import urgot.UrgotStats;

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
