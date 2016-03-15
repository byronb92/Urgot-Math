package battle.dynamic;


/**
 * Uses DynamicResistModifers to compute damage after damage modifiers.
 * Damage modifiers are considered to be armor and magic resistance.
 * @author bbeck799
 *
 */
public class DynamicCompleteDamage {
	private String name;
	private double physicalDamage;
	private double magicDamage;
	private DynamicResistModifier resistMod;
	
	private String comparedWith;
	private double comparedDamage;
	
	public DynamicCompleteDamage(String o, double physical, double magic)
	{
		name = o;
		physicalDamage = physical;
		magicDamage = magic;
	}
	
	public DynamicCompleteDamage(String o, double physical, double magic,
			DynamicResistModifier resistMod)
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
	
	public DynamicResistModifier getResistMod()
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
