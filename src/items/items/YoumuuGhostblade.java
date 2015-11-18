package items.items;

import items.Item;
import urgot.UrgotStats;

public class YoumuuGhostblade extends Item {
	private int ad = 65;
	private double cdr = 0.10;
	public YoumuuGhostblade()
	{
		super();
	}
	@Override
	public void applyPassive(UrgotStats urgot) {
		// TODO Auto-generated method stub
		
	}

	public double applyActive(UrgotStats urgot) {
		// TODO: Use apply active somehow.
		return urgot.getTotalAS() + (0.45);
	}
	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusAD(ad);
		urgot.addCDR(cdr);
		urgot.addArmorPen(20);
		
	}

	@Override
	protected void setCost() {
		cost = 3200;
		
	}

	@Override
	protected void setName() {
		name = "Youmuu's Ghostblade";
		
	}

	@Override
	protected void setDetails() {
		details = "UNIQUE: Gain +40% attack speed and +20% movement "
				+ "speed for 6 seconds. 45 second cooldown";
	}

}
