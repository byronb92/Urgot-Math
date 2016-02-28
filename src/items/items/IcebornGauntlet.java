package items.items;

import battle.effects.SheenAfterAction;
import battle.effects.SheenWrapper.SheenVariation;
import items.Item;
import urgot.UrgotStats;

public class IcebornGauntlet extends Item {

	// TODO: Recalculate Spellblade number with sterek's;
	private int armor = 65;
	private int mana = 500;
	private double cdr = 0.20;
	private double currentBaseAD = 0;
	private UrgotStats urgot;
	private boolean passiveApplied = false;
	public IcebornGauntlet()
	{
		super();
	}
	@Override
	public void applyPassive(UrgotStats urgot) {
		currentBaseAD = urgot.getBaseADFromLevel();
		this.urgot = urgot;
		passiveApplied = true;
		setDetails();
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusArmor(armor);
		urgot.addBonusMana(mana);
		urgot.addCDR(cdr);
		SheenAfterAction sheenAdd = new SheenAfterAction(SheenVariation.ICEBORN);
		urgot.addEffect(sheenAdd);
		
	}

	@Override
	protected void setCost() {
		cost = 2700;
	}

	@Override
	protected void setName() {
		name = "Iceborn Gauntlet";
		
	}

	@Override
	protected void setDetails() {
		if (passiveApplied)
		{
			details = "Armor scaling zone: 180 + (55% bonus armor) ("
					+ urgot.getBonusArmor() + ")\n"
					+ "Spellblade: 125% Base AD( " + currentBaseAD + " )\n"
					+ "30% Movement Speed Slow";
		}
		else
		{
			details = "Armor scaling zone: 180 + (55% bonus armor)\n"
					+ "Spellblade: 125% Base AD\n"
					+ "30% Movement Speed Slow";
		}
	}
	
	@Override
	protected void setCategory() {
		category.put("Armor", "");
		category.put("Mana", "");
		category.put("Cooldown Reduction", "");
		category.put("Sustain", "");
		
	}

}
