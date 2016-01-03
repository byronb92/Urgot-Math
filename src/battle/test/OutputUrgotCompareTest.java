package battle.test;


import junit.framework.TestCase;

import battle.OutputUrgotCompare;
import scenario.StatSetup;


public class OutputUrgotCompareTest extends TestCase {

	OutputUrgotCompare comp;
	protected void setUp() throws Exception {
		comp = new OutputUrgotCompare();
		System.out.println("-----------------");
	}

	public void testMasteries()
	{
		comp.statCollection(StatSetup.STARTING_ITEMS);
		comp.outputHighestRawDamage();
	}
//	public void testMasteries()
//	{
//		comp.statCollection(StatSetup.MASTERIES_LEVEL1);
//		comp.outputHighestRawDamage();
//		comp.outputPassiveandActivies();
//	}
	// Simple tests to ensure there are no nullpointer exceptions.
//	public void testOutputLevelSix()
//	{
//		comp.statCollection(StatSetup.LEVEL6);
//		comp.outputSortedArmor(SortRank.ASCENDING);
//	}
//	public void testOutputFullBuild()
//	{
//		comp.statCollection(StatSetup.LEVEL18);
//		comp.outputHighestRawDamage();
//	}
//	
//	public void testOutputCheapestFullBuild()
//	{
//		comp.statCollection(StatSetup.LEVEL18);
//		comp.outputLowestCost();
//	}
//	
//	public void testOutputSortedDamageFulLBuild()
//	{
//		comp.statCollection(StatSetup.LEVEL18);
//		comp.outputSortedDamageDescending();
//	}
//	
//	public void testOutputSortedArmorFullBuild()
//	{
//		comp.statCollection(StatSetup.LEVEL18);
//		comp.outputSortedArmor(SortRank.DESCENDING);
//	}
//	public void testPassiveAndActives()
//	{
//		comp.statCollection(StatSetup.LEVEL6);
//		comp.outputPassiveandActivies();
//	}

}
