package masteries;

import java.util.ArrayList;

import battle.Battle;
import masteries.cunning.Cunning;
import masteries.ferocity.Ferocity;
import masteries.resolve.Resolve;
import urgot.UrgotStats;

/**
 * The masteries object will be attached to every UrgotScenario object.
 * There are several types of masteries that should be applied before any items are added,
 * right after items are added, and right after battle scenarios. This is due to the fact
 * that some stats need to be applied before others to correctly compute damage output.
 * @author byronb92
 *
 */
public class Masteries {
	
	private Ferocity ferocity;
	private Cunning cunning;
	private Resolve resolve;
	
	

	private String keystone;
	
	
	public Masteries()
	{
		ferocity = new Ferocity();
		cunning = new Cunning();
		resolve = new Resolve();

	}
	
	
	public Ferocity getFerocity() { return ferocity; }
	public Cunning getCunning() { return cunning; }
	public Resolve getResolve() { return resolve; }
	
	public String getKeyStone() { return keystone; }

	
	

	
	
	
	
	
	
	

}
