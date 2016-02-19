package battle.dynamic;

public class CompleteDamage {
	private String name;
	private double physicalDamage;
	private double magicDamage;
	
	public CompleteDamage(String o, double physical, double magic)
	{
		name = o;
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
}
