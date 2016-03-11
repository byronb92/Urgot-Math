package scenario.UrgotBuilds;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

import scenario.UrgotBuilds.MakeScenariosFromJSON.BuildType;

public class MakeScenariosFromJSONTest {
	private MakeScenariosFromJSON jsonMake;
	@Before
	public void setUp() throws Exception {
		jsonMake = new MakeScenariosFromJSON();
	}

	@Test
	public void test() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException, ParseException {
		jsonMake.parseJSONByBuildType(BuildType.ALL);
	}

}
