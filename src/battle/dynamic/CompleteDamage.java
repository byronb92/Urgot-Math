package battle.dynamic;

public class CompleteDamage {
	private String name;
	private double physicalDamage;
	private double magicDamage;
	private ResistanceModifiers resistMod;
	
	private String comparedWith;
	private double comparedDamage;
	
	public CompleteDamage(String o, double physical, double magic)
	{
		name = o;
		physicalDamage = physical;
		magicDamage = magic;
	}
	
	public CompleteDamage(String o, double physical, double magic,
			ResistanceModifiers resistMod)
	{
		name = o;
		physicalDamage = physical;
		magicDamage = magic;
		this.resistMod = resistMod;
	}
	/**
	 * Each CompleteDamage object can be compared to another CompleteDamage object.
	 * These variables are set to help access information when compared.
	 * @param comparedWith
	 * @param comparedDamage
	 */
	public void setCompared(String comparedWith, double comparedDamage)
	{
		this.comparedWith = comparedWith;
		this.comparedDamage = comparedDamage;
	}
	
	public String getName()
	{
		return name;
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
	
	public ResistanceModifiers getResistMod()
	{
		return resistMod;
	}
	
	public String getComparedWith()
	{
		return comparedWith;
	}
	
	public double getComparedDamage()
	{
		return comparedDamage;
	}
}
