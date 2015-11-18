package items.items;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SapphireCrystalTest {

	SapphireCrystal sc;
	@Before
	public void setUp() throws Exception {
		sc = new SapphireCrystal();
	}

	@Test
	public void testInitialize() {
		assertEquals(350, sc.getCost());;
		assertNull(sc.getDetails());;
		assertEquals("Sapphire Crystal", sc.getName());
	}

}
