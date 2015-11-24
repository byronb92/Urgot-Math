package items.items;

import items.Item;
import urgot.UrgotStats;

public class Phage extends Item {

	private int hp = 200;
	private int ad = 15;
	public Phage()
	{
		
	}
	@Override
	public void applyPassive(UrgotStats urgot) {
		// TODO: Calculate how much movement speed Urgot receives from Phage.
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusAD(ad);
		urgot.addBonusHP(hp);
		
	}

	@Override
	protected void setCost() {
		cost = 1250;
		
	}

	@Override
	protected void setName() {
		name = "Phage";
		
	}

	@Override
	protected void setDetails() {
		details = "Basic attacks (on-hit) grant +20 flat movement speed for 2 seconds. "
				+ "Killing a Unit grants +60 flat movement speed instead.";
		
	}

}
