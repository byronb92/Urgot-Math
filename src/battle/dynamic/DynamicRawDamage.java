package battle.dynamic;

import java.util.HashMap;

/**
 * Maps damage with it's penetration values.
 * Example: Black cleaver's armor penetration must be stacked.
 * This class takes care of the math on a stack-by-stack basis.
 * @author bbeck799
 *
 */
public class DynamicRawDamage {
	
	public HashMap<Double,Double> mapPhysicalDamageWithArmorPen;
	public DynamicRawDamage()
	{
		mapPhysicalDamageWithArmorPen = new HashMap<Double,Double>();
	}
	
	public void addADandArmorPenPair(double physicalDamage, double armorPen)
	{
		mapPhysicalDamageWithArmorPen.put(physicalDamage, armorPen);
	}
	
	public double computeDynamicRawDamage()
	{
		return 0;
	}

}


/**
 * Set ResistanceModifiers with first armor pen --> 
 * Call getTrueEnemyArmor in ResistanceModifiers
 * Call physicalDamageVsEnemy with getTrueEnemy();
 * 
 * 
 * 
 */
