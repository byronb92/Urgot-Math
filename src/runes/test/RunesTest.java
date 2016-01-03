package runes.test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import runes.RuneSets;
import runes.RuneSetup;
import runes.Runes;
import scenario.UrgotScenario;

public class RunesTest {
	Runes runes;
	RuneSets sets;
	UrgotScenario urgot;
	@Before
	public void setUp() throws Exception {
		// Seperate Rune Test
		runes = new Runes();
		sets = new RuneSets();
		
		// Rune test with base urgot stats.
		urgot = new UrgotScenario(1);
	}
	@Test
	public void testStandardRunePageADDifference()
	{
		// Setup both urgots to compare their differences.
		urgot.computeStats();
		UrgotScenario urgotB = new UrgotScenario(1);
		urgotB.addRunes(RuneSetup.STANDARD);
		urgotB.computeStats();
		
		// No combos are set up on the urgot scenarios, so there are no battle stats.
		
		double baseUrgotAD = urgot.getUrgotStats().getTotalAD();
		double runeUrgotAD = urgotB.getUrgotStats().getTotalAD();
		double difference = runeUrgotAD - baseUrgotAD;
		// With a standard rune page, there should be a +15.3 AD difference.
		assertEquals(15.3, difference, 0.01);
	}

	@Test
	public void testPrintStandRunes() {
		sets.addStandardRunes(runes);
		System.out.println(runes.getRunesAsString());
		System.out.println();


	}
	@Test
	public void testArmorPenmark()
	{
		System.out.print("Armor Pen Marks, AD Quints");
		System.out.println();
		sets.addArmorPenMarks(runes);
		System.out.println(runes.getRunesAsString());
		System.out.println();
	}
	@Test
	public void testArmorPenQuint()
	{
		System.out.print("Armor Pen Quints, AD Marks");
		System.out.println();
		sets.addArmorPenQuints(runes);
		System.out.println(runes.getRunesAsString());
		System.out.println();
	}

}
