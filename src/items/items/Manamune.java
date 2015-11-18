package items.items;

import urgot.UrgotStats;

public class Manamune extends Tear
{

	private double attackDamage = 25;
	public Manamune(int stacks) {
		super(stacks);
		setCost();
	}

	@Override
	public void setCost()
	{
		cost = 2400;
		name = "Manamune";
	}
	
	@Override
	public void addItemStats(UrgotStats urgot) {
		
		urgot.addBonusAD(attackDamage);
		urgot.addBonusMana(super.getTotalMana());
		urgot.addBonusManaRegen(super.getBonusManaRegen());	
	}
	
	// UNIQUE – AWE: Gain attack damage equal to 2% of your maximum mana.
	public void applyPassive(UrgotStats urgot)
	{
		urgot.addBonusAD((urgot.getTotalMana() * 0.02));
	}


}
