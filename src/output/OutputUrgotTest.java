package output;


import org.junit.Before;
import org.junit.Test;

import masteries.MasterySet;
import runes.RuneSetup;

public class OutputUrgotTest {
	OutputUrgot singleUrg;
	@Before
	public void setUp() throws Exception {
		singleUrg = new OutputUrgot();
	}

	@Test
	public void test() {
		singleUrg.setUpSingleUrgot("Muramana,Black Cleaver,Frozen Heart", 14, 
				RuneSetup.STANDARD,MasterySet.THUNDERLORD_BALANCED);
	}

}
