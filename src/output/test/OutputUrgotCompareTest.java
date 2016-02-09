package output.test;


import java.io.FileNotFoundException;
import java.io.PrintWriter;

import battle.BattleSetup;
import battle.SkillRankType;
import junit.framework.TestCase;
import masteries.MasterySet;
import output.OutputUrgotCompare;
import runes.RuneSetup;
import scenario.SortRank;
import scenario.StatSetup;


public class OutputUrgotCompareTest extends TestCase {

	OutputUrgotCompare comp;
	protected void setUp() throws Exception {
		comp = new OutputUrgotCompare();
	}

	public void testGeneral() throws FileNotFoundException
	{
		comp.statCollection(StatSetup.LEVEL18);
		PrintWriter out = new PrintWriter("testTextDumps/general.txt");
		out.println(comp.outputGeneral());
		out.close();
	}
	public void testStartingItems() throws FileNotFoundException
	{
		comp.statCollection(StatSetup.STARTING_ITEMS);
		comp.battleCollection(BattleSetup.AUTOTRADE_NO_W, SkillRankType.AGGRESSIVE);
		PrintWriter out = new PrintWriter("testTextDumps/startingItems.txt");
		out.println(comp.outputHighestRawDamage());
		out.close();
	}
	public void testMasteries() throws FileNotFoundException
	{
		comp.statCollection(StatSetup.MASTERIES_LEVEL1);
		comp.battleCollection(BattleSetup.POKE_AUTOWEAVE, SkillRankType.AGGRESSIVE);
		PrintWriter out = new PrintWriter("testTextDumps/testMasteries.txt");
		out.println(comp.outputHighestRawDamage());
		out.println(comp.outputPassiveandActivies());
		out.println(comp.outputSortedDamage(SortRank.ASCENDING));
		out.close();
	}
//	// Simple tests to ensure there are no nullpointer exceptions.
//	public void testArmorLevelSi() throws FileNotFoundException
//	{
//		comp.statCollection(StatSetup.LEVEL6);
//		PrintWriter out = new PrintWriter("testTextDumps/testArmorLevel6.txt");
//		out.println(comp.outputSortedArmor(SortRank.ASCENDING));
//		out.close();
//		
//	}
//	public void testFullBuildRawDamage() throws FileNotFoundException
//	{
//		comp.statCollection(StatSetup.LEVEL18);
//		PrintWriter out = new PrintWriter("testTextDumps/testFullBuildRawDamage.txt");
//		out.println(comp.outputHighestRawDamage());
//		out.close();
//		
//	}
//	
//	public void testOutputCheapestFullBuild() throws FileNotFoundException
//	{
//		comp.statCollection(StatSetup.LEVEL18);
//		PrintWriter out = new PrintWriter("testTextDumps/testCheapestBuild.txt");
//		out.println(comp.outputLowestCost());
//		out.close();
//		
//	}
//	
//	
//	public void testOutputSortedArmorFullBuild() throws FileNotFoundException
//	{
//		comp.statCollection(StatSetup.LEVEL18, 
//				RuneSetup.STANDARD, 
//				MasterySet.THUNDERLORD_BALANCED);
//		comp.battleCollection(BattleSetup.ALLIN_ULT, SkillRankType.STANDARD);
//		
//		PrintWriter out = new PrintWriter("testTextDumps/testLevel18_Runes"
//				+ "_Masteries_BattleSetup.txt");
//		out.println(comp.outputSortedArmor(SortRank.DESCENDING));
//		out.close();
//	}
//	
//	public void testPassiveAndActives() throws FileNotFoundException
//	{
//		comp.statCollection(StatSetup.LEVEL6,
//				RuneSetup.STANDARD, 
//				MasterySet.THUNDERLORD_BALANCED);
//		comp.battleCollection(BattleSetup.ALLIN_ULT, SkillRankType.STANDARD);
//		
//		PrintWriter out = new PrintWriter("testTextDumps/testPassiveActives.txt");
//		out.println(comp.outputPassiveandActivies());
//		out.close();
//	}

}
