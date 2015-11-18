package urgot;

import battle.BattleCalculator;

public class UrgotCombos {
	/**
	 * Level 1 - Q, Auto
	 * Level 2 - Q - E
	 * Level 3 - E - Q - Q
	 * Level 4 - E - W - Q - Q
	 * Level 5 - E - W - Q - Q
	 * 17% CDR Combo = E - W - Q - Q - Q
	 * 40% CDR Combo = E - W - Q - Q - Q - Q
	 * 17% CDR All-In= R - E - W - Q - Q - Q 
	 * 40% CDR All-In= R - E - W - Q - Q - Q - Q
	 */

	
	BattleCalculator battleManager;
	UrgotSkills urgotSkills;
	UrgotStats urgot;
	public UrgotCombos(BattleCalculator manager, UrgotStats urgot)
	{
		battleManager = manager;
		urgotSkills = new UrgotSkills(manager, urgot);
		this.urgot = urgot;
	}
	
	
	public void levelOne()
	{
		urgotSkills.qAcidHunter(1);
		battleManager.adDamage(urgot.getTotalAD());
	}
	
	public void levelSix()
	{
		if (urgot.getCDR() < 0.17)
		{
			urgotSkills.eNoxianCorrosiveCharge(1);
			urgotSkills.wTerrorCapacitor(1);
			urgotSkills.qAcidHunter(3);
			urgotSkills.qAcidHunter(3);
		}
		else if (urgot.getCDR() > 0.17 && urgot.getCDR() < 0.40)
		{
			urgotSkills.eNoxianCorrosiveCharge(1);
			urgotSkills.wTerrorCapacitor(1);
			urgotSkills.qAcidHunter(3);
			urgotSkills.qAcidHunter(3);
			urgotSkills.qAcidHunter(3);
		}
		else
		{
			urgotSkills.eNoxianCorrosiveCharge(1);
			urgotSkills.wTerrorCapacitor(1);
			urgotSkills.qAcidHunter(3);
			urgotSkills.qAcidHunter(3);
			urgotSkills.qAcidHunter(3);
			urgotSkills.qAcidHunter(3);
		}
	}
	
}
