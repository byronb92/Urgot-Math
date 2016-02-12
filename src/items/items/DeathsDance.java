package items.items;

import battle.Battle;
import items.Item;
import urgot.UrgotStats;

public class DeathsDance extends Item {

	private int ad = 75;
	private double cdr = 0.10;
	
	public DeathsDance()
	{
		super();
	}
	
	@Override 
	public void applyAfterBattleUniques(Battle calc)
	{
		calc.addHealing(calc.getPhysicalDamage() * 0.15);
	}
	@Override
	public void applyPassive(UrgotStats urgot) {
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusAD(ad);
		urgot.addCDR(cdr);
	}

	@Override
	protected void setCost() {
		cost = 3500;
		
	}

	@Override
	protected void setName() {
		name = "Death's Dance";
		
	}

	@Override
	protected void setDetails() {
		details = "Instantly heal for 15% of all physical damage dealt."
				+ "AOE 5% to each unit affected.";
	}

}
