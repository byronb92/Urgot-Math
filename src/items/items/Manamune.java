package items.items;

import urgot.UrgotStats;

public class Manamune extends Tear
{

	private double attackDamage = 25;
	UrgotStats urgot;
	private boolean passiveApplied = false;
	public Manamune(int stacks) {
		super(stacks);
	}

	@Override
	public void setCost()
	{
		cost = 2400;
	}
	
	@Override
	protected void setName()
	{
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
		this.urgot = urgot;
		
		passiveApplied = true;
		setDetails();
	}
	
	@Override
	public void setDetails()
	{
		if (passiveApplied)
		{
			details = "Bonus AD From Mana: " + urgot.getTotalMana() * 0.02;
			urgot.addBonusAD((urgot.getTotalMana() * 0.02));

		}
		else
		{
			details = "Bonus AD From Mana: 2% max mana";
		}
	}


}
