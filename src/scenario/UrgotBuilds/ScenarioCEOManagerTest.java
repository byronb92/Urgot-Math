package scenario.UrgotBuilds;

import static org.junit.Assert.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import scenario.UrgotBuilds.MakeScenariosFromJSON.BuildType;

public class ScenarioCEOManagerTest {
	private ScenarioCEOManager sceCEOManager;
	@Before
	public void setUp() throws Exception {
		sceCEOManager = new ScenarioCEOManager();
	}

	@Test
	public void test() throws ClassNotFoundException, NoSuchMethodException, 
		SecurityException, InstantiationException, IllegalAccessException, 
		IllegalArgumentException, InvocationTargetException, IOException, 
	ParseException {
		sceCEOManager.addScenariosByBuildType(BuildType.DAMAGE);
	}

}
