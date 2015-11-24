package battle;


import org.junit.Before;
import org.junit.Test;

public class OutputUrgotCompareTest {

	OutputUrgotCompare comp;
	@Before
	public void setUp() throws Exception {
		comp = new OutputUrgotCompare();
	}


	@Test
	public void testItemCosts() {
		comp.outputEarlyItemCosts();
	}

}
