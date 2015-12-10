package scenario;

/**
 * Class used to keep values coupled with their scenario.
 * This allows scenarios to be ranked based on damage, costs, etc.
 * @author byronb92
 *
 */
public class ScenarioPair {
	private Object value;
	private UrgotScenario sce;
	
	public ScenarioPair(Object value, UrgotScenario sce)
	{
		this.sce = sce;
		this.value = value;
	}
	
	public Object getValue() { return value; }
	public UrgotScenario getScenario() { return sce; }
}
