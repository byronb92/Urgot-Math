package items.test;


import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import items.ItemDynamicFactory;

public class ItemDynamicFactoryTest {
	ItemDynamicFactory factory;
	@Before
	public void setUp() throws Exception {
		factory = new ItemDynamicFactory();
	}

	@Test
	public void test() throws ParseException, IOException {
		System.out.println(factory.getSpecificItemCategory("Single"));
	}

}
