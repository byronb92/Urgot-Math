package battle.test;


import org.junit.Before;
import org.junit.Test;

import battle.OutputUrgotCompare;

public class OutputUrgotCompareTest {

	OutputUrgotCompare comp;
	@Before
	public void setUp() throws Exception {
		comp = new OutputUrgotCompare();
	}


	@Test
//	public void testItemCosts() {
//		comp.outputEarlyItemCosts();
//	}
	
//	public void testItemDamage() 
//	{
//		comp.outputEarlyHighestRaw();
//	}
	
//	public void testHammervsDirk()
//	{
//		comp.outputCaulfieldVsDirk();
//	}
	
//	public void testSheenDamage()
//	{
//		comp.outputSheenDamage();
//	}
	
//	public void testBladeVsClear()
//	{
//		comp.outputGhostbladeVsCleaver();
//	}
	
	public void outAllLevel6()
	{
		comp.outputAllLevel6Items();
	}

}
