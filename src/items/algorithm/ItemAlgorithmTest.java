package items.algorithm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import scenario.UrgotScenario;

public class ItemAlgorithmTest {
	private ItemAlgorithm alg;
	@Before
	public void setUp() throws Exception {
		alg = new ItemAlgorithm();
	}

	@Test
	public void test() throws CloneNotSupportedException {
		UrgotScenario sceA = new UrgotScenario(1);
		alg.bestDamageItemToAdd(sceA, "Starting");
	}

}
