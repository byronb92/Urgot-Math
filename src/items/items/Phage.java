package items.items;

import items.Item;
import urgot.UrgotStats;

public class Phage extends Item {

	private int hp = 200;
	private int ad = 15;
	private double moveSpeed = 0;
	public Phage()
	{
		super();
	}
	@Override
	public void applyPassive(UrgotStats urgot) {
		moveSpeed = urgot.getTotalMS();
		setDetails();
		
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
		details = "Basic attacks grant +20 flat movement speed for 2 seconds. \n"
				+ "Killing units grant +60 flat movement speed. \n"
				+ "Bonus is half for ranged champs. \n"
				+ "Urgot basic attack MS: " + (moveSpeed + 10) + " \n"
				+ "Urgot killing bonus: " + (moveSpeed + 30);
		
	}
	
	@Override
	protected void setCategory() {
		category.put("Attack Damage", "");
		category.put("Health", "");
		category.put("Movement Speed", "");
		
	}

}
