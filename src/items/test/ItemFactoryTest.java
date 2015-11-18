package items.test;

import items.*;
import items.items.Manamune;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ItemFactoryTest {

	ItemFactory itemFactory;
	
	@Before
	public void setUp() throws Exception {
		itemFactory = new ItemFactory();
	}

	@Test
	public void testManamuneParse() {
		// Get 150 stack manamune.
		Manamune manamune150 = (Manamune)itemFactory.getItem("Manamune150"); 	
		assertEquals(150, manamune150.getStacks()); 
		
		// Get 300 stack manamune.
		Manamune manamune350 = (Manamune)itemFactory.getItem("Manamune350"); 	
		assertEquals(350, manamune350.getStacks());
		
	}

}
