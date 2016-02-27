package items.items;

import items.Item;
import urgot.UrgotStats;

public class MawOfMalmortius extends Item {

	private int mr = 50;
	private int ad = 55;
	private int armorPen = 10;
	private UrgotStats urgot;
	private boolean passiveApplied = false;
	
	public MawOfMalmortius()
	{
		super();
	}
	@Override
	public void applyPassive(UrgotStats urgot) {
		this.urgot = urgot;
		passiveApplied = true;
		setDetails();
		
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusMR(mr);
		urgot.addFlatArmorPen(armorPen);
		urgot.addBonusAD(ad);
		
	}

	@Override
	protected void setCost() {
		cost = 3250;
		
	}

	@Override
	protected void setName() {
		name = "Maw of Malmortius";
		
	}

	@Override
	protected void setDetails() {
		if (passiveApplied)
		{
			details = "Upon taking magic damage that would" +
					"reduce maximum health below 30% (+" + urgot.getTotalHP() * 0.30 + 
					") grants a shield that absorbs 300 " +
					"(+ 100% Bonus Magic Resistance)(" + urgot.getTotalMR() +
					") for 5 seconds.(90 second cooldown)";
		}
		else
		{
			details = "UNIQUE – LIFELINE: Upon taking magic damage that would" +
					"reduce maximum health below 30%, grants a shield that absorbs" +
					"300 (+ 100% Bonus Magic Resistance) for 5 seconds. "
					+ "(90 second cooldown)";
		}
	}
	
	@Override
	protected void setCategory() {
		category.put("Attack Damage", "");
		category.put("Armor Penetration", "");
		category.put("Magic Resistance", "");
		category.put("Sustain", "");
		
	}

}
