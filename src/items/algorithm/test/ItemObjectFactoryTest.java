package items.algorithm.test;


import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import items.algorithm.ItemObjectFactory;

public class ItemObjectFactoryTest {
	ItemObjectFactory factory;
	@Before
	public void setUp() throws Exception {
		factory = new ItemObjectFactory();
	}

	@Test
	public void test() throws ParseException, IOException {
		System.out.println(factory.getSpecificItemCategory("Single"));
	}

}
