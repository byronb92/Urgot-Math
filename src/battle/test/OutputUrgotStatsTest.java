package battle.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import battle.OutputUrgotStats;

public class OutputUrgotStatsTest {

	OutputUrgotStats output;
	@Before
	public void setUp() throws Exception {
		output = new OutputUrgotStats(18);
	}

	@Test
	public void test() {
		output.configureItemSet(1);
		output.outputMaxCombo();
	}

}
