package items.items;
import items.Item;
import urgot.UrgotStats;

public class Tear extends Item
{
	private int baseMana = 250;
	private int stacks = 0;
	private double bonusManaRegen = 0.25;
	
	
	// 15 intervals of 8 in 2 minutes.
	// +8 mana per interval.
	// 120 stacks per 2 minutes.
	// 6.25 * 2 = 12.5 minutes minimum to stack tear.
	public Tear(int stacks)
	{
		super();
		setStacks(stacks);
		setDetails();
	}

	public int getStacks() { return stacks; }
	public int getTotalMana() { return (stacks + baseMana); }
	public double getBonusManaRegen() { return bonusManaRegen; }
	public void setCost() { cost = 750; }
	public void setStacks(int value) { stacks = stacks + value; }


	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusMana(baseMana + stacks);
		urgot.addBonusManaRegen(bonusManaRegen);	
	}

	@Override
	public void applyPassive(UrgotStats urgot) { }

	@Override
	protected void setName() { name = "Tear"; }

	@Override
	protected void setDetails() { details = "Stacks: " + stacks; }
	
	
	
}
