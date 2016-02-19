package battle.dynamic;

import scenario.UrgotScenario;

public class CompleteDamageWithScenario {
	private String scenarioOrigin;
	private double physicalDamage;
	private double magicDamage;
	
	public CompleteDamageWithScenario(UrgotScenario sce, double physical, double magic)
	{
		scenarioOrigin = sce.getScenarioName();
		physicalDamage = physical;
		magicDamage = magic;
	}
	
	public CompleteDamageWithScenario(String sceName, double physical, double magic)
	{
		scenarioOrigin = sceName;;
		physicalDamage = physical;
		magicDamage = magic;
	}
	
	public double getPhysicalDamage()
	{
		return physicalDamage;
	}
	
	public double getMagicDamage()
	{
		return magicDamage;
	}
	
	public double getTotalDamage()
	{
		return physicalDamage + magicDamage;
	}
	
	public String getOrigin()
	{
		return scenarioOrigin;
	}
}

