package items.items;

import battle.actions.effects.SheenAfterAction;
import battle.actions.effects.SheenWrapper.SheenVariation;
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
		currentBaseAD = urgot.getBaseADFromLevel();
		setDetails();
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusHP(hp);
		urgot.addBonusMana(mana);
		urgot.addBonusAD(ad);
		urgot.addCDR(cdr);
		urgot.addBonusCritChance(critChance);
		urgot.addPercentMoveSpeed(movement);
		urgot.addBonusAS(attackSpeed);	
		SheenAfterAction sheenAdd = new SheenAfterAction(SheenVariation.TRINITY);
		urgot.addEffect(sheenAdd);
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
	
	@Override
	protected void setCategory() {
		category.put("Health", "");
		category.put("Mana", "");
		category.put("Cooldown Reduction", "");
		category.put("Attack Damage", "");
		category.put("Movement Speed", "");
		
	}

}
