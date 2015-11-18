package items.items;

import items.Item;
import urgot.UrgotStats;

public class Thornmail extends Item {

	private int armor = 100;
	private boolean passiveApplied = false;
	private UrgotStats urgot;
	public Thornmail()
	{
		super();
	}
	@Override
	public void applyPassive(UrgotStats urgot) {
		passiveApplied = true;
		setDetails();
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusArmor(armor);
		this.urgot = urgot;
		
	}

	@Override
	protected void setCost() {
		cost = 2350;
		
	}

	@Override
	protected void setName() {
		name = "Thornmail";
		
	}

	@Override
	protected void setDetails() {
		if (passiveApplied)
		{
			details = "Reflects 15% of the physical damage taken (+ 25% bonus armor)("
					+ urgot.getBonusArmor() * 0.25
					+ ") from basic attacks and on-hit effects back to its source as "
					+ "magic damage";
		}
		else
		{
			{
				details = "Reflects 15% of the physical damage taken (+ 25% bonus armor) "
						+ "from basic attacks and on-hit effects back to its source as "
						+ "magic damage";
			}
		}
		// TODO: Compute thornmail damage done.
		
	}

}
