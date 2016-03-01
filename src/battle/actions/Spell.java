package battle.actions;

import battle.SpellCostType;

/** Subclass of BattleAction and Superclass of Urgot's abilities */
public abstract class Spell extends BattleAction {
	
	private String spellType;
	private int spellRank;
	private int cost;
	private SpellCostType costType;
	private double cooldown;
	private double castTime;		// Average cast time is 0.25 seconds.
	

	public void setSpellType(String spellType)
	{
		this.spellType = spellType;
	}
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
	
	public String getSpellType()
	{
		return spellType;
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
		return (cooldown * (1 - cdr));
	}
	
	public double getCastTime()
	{
		return castTime;
	}


}
