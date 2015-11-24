package scenario;

import java.util.ArrayList;

public class Phase {
	
	
	private ArrayList<UrgotScenario> listScenarios;
	public Phase()
	{
		listScenarios = new ArrayList<UrgotScenario>();
	}
	
	public void addScenario(UrgotScenario sce)
	{
		listScenarios.add(sce);
	}
	
	public ArrayList<UrgotScenario> getScenarios()
	{
		return listScenarios;
	}
	

	

}
