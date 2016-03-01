package items.items;

import battle.actions.effects.SheenAfterAction;
import battle.actions.effects.SheenWrapper.SheenVariation;
import items.Item;
import urgot.UrgotStats;

public class Sheen extends Item
{
	private int mana = 250;
	private double cdr = 0.10;
	private double currentBaseAD = 0;
	
	public Sheen()
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
		urgot.addBonusMana(mana);
		urgot.addCDR(cdr);
		SheenAfterAction sheenAdd = new SheenAfterAction(SheenVariation.SHEEN);
		urgot.addEffect(sheenAdd);
		
	}

	@Override
	protected void setCost() {
		cost = 700;
		
	}

	@Override
	protected void setName() {
		name = "Sheen";
		
	}

	@Override
	protected void setDetails() {
		details = "100% Bonus Base AD Damage on Spell Cast every 1.5 seconds: (+" 
				+ currentBaseAD + " AD)";
		
	}
	
	@Override
	protected void setCategory() {
		category.put("Mana", "");
		category.put("Cooldown Reduction", "");
		category.put("Sustain", "");
		
	}

}
