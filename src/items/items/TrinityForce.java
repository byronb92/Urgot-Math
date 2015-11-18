package items.items;

import items.Item;
import urgot.UrgotStats;

public class TrinityForce extends Item{

	private int hp = 250;
	private int mana = 250;
	private int ad = 25;
	private double cdr = 0.10;
	private double currentBaseAD = 0;
	private double critChance = 0.20;
	private double movement = 0.05;
	private double attackSpeed = 0.15;


	public TrinityForce()
	{
		super();
	}
	@Override
	public void applyPassive(UrgotStats urgot) {
		currentBaseAD = (urgot.getBaseAD() + 
				(urgot.getADPerLevel() * (urgot.getLevel() - 1)));
		setDetails();
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusHP(250);
		urgot.addBonusMana(250);
		urgot.addBonusAD(ad);
		urgot.addCDR(cdr);
		//TODO: Add crit chance, movement, attack speed.
		
	}

	@Override
	protected void setCost() {
		cost = 3800;
		
	}

	@Override
	protected void setName() {
		name = "Trinity Force";
		
	}

	@Override
	protected void setDetails() {
		details = "200% Bonus Base AD Damage on Spell Cast every 1.5 seconds: (+" 
				+ (currentBaseAD * 2) + " AD)";
		
	}

}
