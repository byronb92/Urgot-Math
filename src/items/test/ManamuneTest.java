package items.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import items.items.Manamune;

public class ManamuneTest {
	Manamune manamune;
	@Before
	public void setUp() throws Exception {
		// Manamune with 450 tear stacks.
		manamune = new Manamune(450);
	}

	@Test
	public void testManamuneCost() {
		assertEquals(2400, manamune.getCost());
		assertEquals(700, manamune.getTotalMana()); // 250 base mana + 450 stacked.
	}

}
