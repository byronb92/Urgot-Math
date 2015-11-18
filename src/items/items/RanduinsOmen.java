package items.items;

import items.Item;
import urgot.UrgotStats;

public class RanduinsOmen extends Item {

	private int hp = 450;
	private int armor = 60;
	public RanduinsOmen()
	{
		super();
	}
	@Override
	public void applyPassive(UrgotStats urgot) {

		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusHP(hp);
		urgot.addBonusArmor(armor);
	}

	@Override
	protected void setCost() {
		cost = 3000;
		
	}

	@Override
	protected void setName() {
		name = "Randuin's Omen";
		
	}

	@Override
	protected void setDetails() {
		details = "When hit by basic attacks, reduces "
				+ "the attacker's attack speed by 15% for 1 second.\n" 
				+ "-10% damage from critical strikes";
				
		
	}

}
