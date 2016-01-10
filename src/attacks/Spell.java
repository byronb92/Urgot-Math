package attacks;

import calc.BattleCalculator;
import urgot.UrgotStats;

public abstract class Spell {
	
	private int spellRank;
	private int cost;
	private SpellCostType costType;
	private double cooldown;
	private double castTime;		// Average cast time is 0.25 seconds.
	
	// Notes: Urgot W does not have a cast time.
	
	public void setSpellRank(int spellRank)
	{
		this.spellRank = spellRank;
	}
	public void setCost(int cost)
	{
		this.cost = cost;
	}
	public void setCostType(SpellCostType costType)
	{
		this.costType = costType;
	}
	public void setBaseCooldown(double cooldown)
	{
		this.cooldown = cooldown;
	}
	public void setCastTime(double castTime)
	{
		this.castTime = castTime;
	}
	
	public Spell(int spellRank, int cost, SpellCostType costType, double cooldown, double castTime)
	{
		setSpellRank(spellRank);
		setCost(cost);
		setCostType(costType);
		setBaseCooldown(cooldown);
		setCastTime(castTime);
	}
	public int getSpellRank()
	{
		return spellRank;
	}
	public int getCost()
	{
		return cost;
	}
	public SpellCostType getCostType()
	{
		return costType;
	}
	public double getCdrCooldown(double cdr)
	{
		return (cooldown * 1 - cdr);
	}
	
	public double getCastTime()
	{
		return castTime;
	}
	public abstract void runBattleCalculations(
			BattleCalculator battle, UrgotStats urgot);

}
