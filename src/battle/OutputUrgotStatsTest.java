package battle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OutputUrgotStatsTest {

	OutputUrgotStats output;
	@Before
	public void setUp() throws Exception {
		output = new OutputUrgotStats(6);
	}

	@Test
	public void test() {
		output.outputLevelCombo();
	}

}
