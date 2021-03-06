package items.items;

import battle.Battle;
import items.Item;
import urgot.UrgotStats;

public class SpiritVisage extends Item {

	private int hp = 500;
	private int mr = 70;
	private double hpRegen = 1.5;
	private double cdr = 0.1;
	
	public SpiritVisage()
	{
		super();
	}
	@Override
	public void applyPassive(UrgotStats urgot) {
		setDetails();
		
	}

	@Override 
	public void applyAfterBattleUniques(Battle calc)
	{
		calc.addHealingModifier(0.20);
	}
	
	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusHP(hp);
		urgot.addBonusMR(mr);
		urgot.addCDR(cdr);
		urgot.addBonusHealthRegen(hpRegen);
	}

	@Override
	protected void setCost() {
		cost = 2800;
		
	}

	@Override
	protected void setName() {
		name = "Spirit Visage";
		
	}

	@Override
	protected void setDetails() {
		details = "Increases effectiveness of all sources of healing by 20%.";
		
	}
	
	@Override
	protected void setCategory() {
		category.put("Health Regeneration", "");
		category.put("Health", "");
		category.put("Cooldown Reduction", "");
		category.put("Magic Resistance", "");
		category.put("Sustain", "");
		
	}

}
