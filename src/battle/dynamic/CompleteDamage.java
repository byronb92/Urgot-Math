package battle.dynamic;

public class CompleteDamage {
	private double physicalDamage;
	private double magicDamage;
	
	public CompleteDamage(double physical, double magic)
	{
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
}
