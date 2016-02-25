package items.test;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import items.ItemObjects;

public class ItemObjectsTest {
	ItemObjects itemObjs;
	@Before
	public void setUp() throws Exception {
		itemObjs = new ItemObjects();
	}

	@Test
	public void test() throws ClassNotFoundException, NoSuchMethodException, 
	SecurityException, InstantiationException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException, ParseException, IOException {
		itemObjs.constructAllItems();
	}

}
