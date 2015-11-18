package items.items;

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
		currentBaseAD = urgot.getBonusBaseAD();
		this.urgot = urgot;
		passiveApplied = true;
		setDetails();
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusArmor(armor);
		urgot.addBonusMana(mana);
		urgot.addCDR(cdr);
		
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
			details = "Armor scaling zone: 190 + (45% bonus armor) ("
					+ urgot.getBonusArmor() + ")\n"
					+ "Spellblade: 125% Base AD( " + currentBaseAD + " )\n"
					+ "30% Movement Speed Slow";
		}
		else
		{
			details = "Armor scaling zone: 190 + (45% bonus armor)\n"
					+ "Spellblade: 125% Base AD\n"
					+ "30% Movement Speed Slow";
		}
		
		
	}

}
