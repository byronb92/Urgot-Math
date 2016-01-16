package urgot;

import battle.Battle;

public class UrgotCombos {
	/**
	 * Level 1 - W, 3 Autos  / 2 Qs, 1 Auto
	 * Level 2 - W, 3 Autos  / 2 Qs, 1 Auto
	 * Level 3 - W, 3 Autos  / 2 Qs, 1 Auto
	 * Level 4 - E - W - Q - Q
	 * Level 5 - E - W - Q - Q
	 * 17% CDR Combo = E - W - Q - Q - Q - Q
	 * 40% CDR Combo = E - W - Q - Q - Q - Q - Q
	 * 17% CDR All-In= R - E - W - Q - Q - Q 
	 * 40% CDR All-In= R - E - W - Q - Q - Q - Q
	 */

	
	private Battle battleManager;
	private UrgotSkills urgotSkills;
	private UrgotStats urgot;
	
	public UrgotCombos(Battle manager, UrgotStats urgot)
	{
		battleManager = manager;
		urgotSkills = new UrgotSkills(manager, urgot);
		this.urgot = urgot;
	}
	
	public UrgotSkills getSkills()
	{
		return urgotSkills;
	}
	public void levelOneQ()
	{
		urgotSkills.qAcidHunter(1);
		urgotSkills.qAcidHunter(1);
		battleManager.adDamage(urgot.getTotalAD());

	}
	
	// Shield, 3 Auto Attacks
	public void levelOneW()
	{
		urgotSkills.wTerrorCapacitor(1);
		battleManager.adDamage(urgot.getTotalAD());
		battleManager.adDamage(urgot.getTotalAD());
		battleManager.adDamage(urgot.getTotalAD());
	}
	
	public void levelTwoQE()
	{
		urgotSkills.eNoxianCorrosiveCharge(1);
		urgotSkills.qAcidHunter(1);
		urgotSkills.qAcidHunter(1);
		urgotSkills.qAcidHunter(1);
	}
	/**
	 * Correct output combos based on skill rank.
	 * Skill ranked is based on Urgot's current level.
	 * THIS DOES NOT INCLUDE ULTIMATE LOGIC.
	 * @param currentLevel level of urgot, valid input is 6-18.
	 */
	public void lockOnNoUlt(int currentLevel)
	{
		lockOnNoUltLogic(currentLevel);
		// CDR Calculations, 3 Q's at 17% CDR, 4 Q's at 37.5% CDR
		if (urgot.getCDR() > 0.17 && urgot.getCDR() < 0.375)
		{
			// Rank 3 Q
			if (currentLevel == 6)
			{
				urgotSkills.qAcidHunter(3);
			}
			// Rank 4 Q			
			else if (currentLevel >= 7 && currentLevel < 9)
			{
				urgotSkills.qAcidHunter(4);
			}
			// Rank 5 Q
			else if (currentLevel >= 9)
			{
				urgotSkills.qAcidHunter(5);
			}
			
		}
		else if (urgot.getCDR() > 0.375)
		{
			// Rank 3 Q
			if (currentLevel == 6)
			{
				urgotSkills.qAcidHunter(3);
				urgotSkills.qAcidHunter(3);
			}
			// Rank 4 Q			
			else if (currentLevel >= 7 && currentLevel < 9)
			{
				urgotSkills.qAcidHunter(4);
				urgotSkills.qAcidHunter(4);
			}
			// Rank 5 Q
			else if (currentLevel >= 9)
			{
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
		}
	}
	
	// Assumption: Q --> E --> W max.
	private void lockOnNoUltLogic(int currentLevel)
	{
		if (currentLevel >=6)
		{
			
			// Power spikes
			// 6 Ult Rank 1, 9 Q Max, 11 Ult Rank 2, 13 E Max, 16 Ult Rank 3
			if (currentLevel == 6)
			{
				urgotSkills.eNoxianCorrosiveCharge(1);
				urgotSkills.wTerrorCapacitor(1);
				urgotSkills.qAcidHunter(3);
				urgotSkills.qAcidHunter(3);
				urgotSkills.qAcidHunter(3);
			}
			else if (currentLevel == 7)
			{
				urgotSkills.eNoxianCorrosiveCharge(1);
				urgotSkills.wTerrorCapacitor(1);
				urgotSkills.qAcidHunter(4);
				urgotSkills.qAcidHunter(4);
				urgotSkills.qAcidHunter(4);
			}
			else if (currentLevel == 8)
			{
				urgotSkills.eNoxianCorrosiveCharge(2);
				urgotSkills.wTerrorCapacitor(1);
				urgotSkills.qAcidHunter(4);
				urgotSkills.qAcidHunter(4);
				urgotSkills.qAcidHunter(4);
			}
			else if (currentLevel == 9)
			{
				urgotSkills.eNoxianCorrosiveCharge(2);
				urgotSkills.wTerrorCapacitor(1);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
			else if (currentLevel == 10)
			{
				urgotSkills.eNoxianCorrosiveCharge(3);
				urgotSkills.wTerrorCapacitor(1);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
			else if (currentLevel == 11)
			{
				urgotSkills.eNoxianCorrosiveCharge(3);
				urgotSkills.wTerrorCapacitor(1);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
			else if (currentLevel == 12)
			{
				urgotSkills.eNoxianCorrosiveCharge(4);
				urgotSkills.wTerrorCapacitor(1);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
			else if (currentLevel == 13)
			{
				urgotSkills.eNoxianCorrosiveCharge(5);
				urgotSkills.wTerrorCapacitor(1);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
			else if (currentLevel == 14)
			{
				urgotSkills.eNoxianCorrosiveCharge(5);
				urgotSkills.wTerrorCapacitor(2);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
			else if (currentLevel == 15)
			{
				urgotSkills.eNoxianCorrosiveCharge(5);
				urgotSkills.wTerrorCapacitor(3);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
			else if (currentLevel == 16)
			{
				urgotSkills.eNoxianCorrosiveCharge(5);
				urgotSkills.wTerrorCapacitor(3);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
			else if (currentLevel == 17)
			{
				urgotSkills.eNoxianCorrosiveCharge(5);
				urgotSkills.wTerrorCapacitor(4);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
			else
			{
				urgotSkills.eNoxianCorrosiveCharge(5);
				urgotSkills.wTerrorCapacitor(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
		}
		
		else
		{
			if (currentLevel == 1)
			{
				levelOneQ();
			}
			else if (currentLevel == 2)
			{
				levelTwoQE();
			}
			else if (currentLevel == 3)
			{
				urgotSkills.eNoxianCorrosiveCharge(1);
				urgotSkills.wTerrorCapacitor(1);
				urgotSkills.qAcidHunter(1);
				urgotSkills.qAcidHunter(1);
				urgotSkills.qAcidHunter(1);
			}
			else if (currentLevel == 4)
			{
				urgotSkills.eNoxianCorrosiveCharge(1);
				urgotSkills.wTerrorCapacitor(1);
				urgotSkills.qAcidHunter(2);
				urgotSkills.qAcidHunter(2);
				urgotSkills.qAcidHunter(2);
			}
			
			else if (currentLevel == 5)
			{
				urgotSkills.eNoxianCorrosiveCharge(1);
				urgotSkills.wTerrorCapacitor(1);
				urgotSkills.qAcidHunter(3);
				urgotSkills.qAcidHunter(3);
				urgotSkills.qAcidHunter(3);
			}
		}
		

	}
	
	
	/**
	 * Correct output combos based on skill rank.
	 * Skill ranked is based on Urgot's current level.
	 * @param currentLevel level of urgot, valid input is 6-18.
	 */
	public void lockOnWithUlt(int currentLevel)
	{
		lockOnWithUltLogic(currentLevel);
		// CDR Calculations, 3 Q's at 17% CDR, 4 Q's at 37.5% CDR
		if (urgot.getCDR() > 0.17 && urgot.getCDR() < 0.375)
		{
			// Rank 3 Q
			if (currentLevel == 6)
			{
				urgotSkills.qAcidHunter(3);
			}
			// Rank 4 Q			
			else if (currentLevel >= 7 && currentLevel < 9)
			{
				urgotSkills.qAcidHunter(4);
			}
			// Rank 5 Q
			else if (currentLevel >= 9)
			{
				urgotSkills.qAcidHunter(5);
			}
			
		}
		else if (urgot.getCDR() > 0.375)
		{
			// Rank 3 Q
			if (currentLevel == 6)
			{
				urgotSkills.qAcidHunter(3);
				urgotSkills.qAcidHunter(3);
			}
			// Rank 4 Q			
			else if (currentLevel >= 7 && currentLevel < 9)
			{
				urgotSkills.qAcidHunter(4);
				urgotSkills.qAcidHunter(4);
			}
			// Rank 5 Q
			else if (currentLevel >= 9)
			{
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
		}
	}
	
	private void lockOnWithUltLogic(int currentLevel)
	{
		if (currentLevel >= 6)
		{
			// Power spikes
			// 6 Ult Rank 1, 9 Q Max, 11 Ult Rank 2, 13 E Max, 16 Ult Rank 3
			if (currentLevel == 6)
			{
				urgotSkills.rHyperKineticPositionReverser(1);
				urgotSkills.eNoxianCorrosiveCharge(1);
				urgotSkills.wTerrorCapacitor(1);
				urgotSkills.qAcidHunter(3);
				urgotSkills.qAcidHunter(3);
				urgotSkills.qAcidHunter(3);
			}
			else if (currentLevel == 7)
			{
				urgotSkills.rHyperKineticPositionReverser(1);
				urgotSkills.eNoxianCorrosiveCharge(1);
				urgotSkills.wTerrorCapacitor(1);
				urgotSkills.qAcidHunter(4);
				urgotSkills.qAcidHunter(4);
				urgotSkills.qAcidHunter(4);
			}
			else if (currentLevel == 8)
			{
				urgotSkills.rHyperKineticPositionReverser(1);
				urgotSkills.eNoxianCorrosiveCharge(2);
				urgotSkills.wTerrorCapacitor(1);
				urgotSkills.qAcidHunter(4);
				urgotSkills.qAcidHunter(4);
				urgotSkills.qAcidHunter(4);
			}
			else if (currentLevel == 9)
			{
				urgotSkills.rHyperKineticPositionReverser(1);
				urgotSkills.eNoxianCorrosiveCharge(2);
				urgotSkills.wTerrorCapacitor(1);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
			else if (currentLevel == 10)
			{
				urgotSkills.rHyperKineticPositionReverser(1);
				urgotSkills.eNoxianCorrosiveCharge(3);
				urgotSkills.wTerrorCapacitor(1);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
			else if (currentLevel == 11)
			{
				urgotSkills.rHyperKineticPositionReverser(2);
				urgotSkills.eNoxianCorrosiveCharge(3);
				urgotSkills.wTerrorCapacitor(1);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
			else if (currentLevel == 12)
			{
				urgotSkills.rHyperKineticPositionReverser(2);
				urgotSkills.eNoxianCorrosiveCharge(4);
				urgotSkills.wTerrorCapacitor(1);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
			else if (currentLevel == 13)
			{
				urgotSkills.rHyperKineticPositionReverser(2);
				urgotSkills.eNoxianCorrosiveCharge(5);
				urgotSkills.wTerrorCapacitor(1);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
			else if (currentLevel == 14)
			{
				urgotSkills.rHyperKineticPositionReverser(2);
				urgotSkills.eNoxianCorrosiveCharge(5);
				urgotSkills.wTerrorCapacitor(2);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
			else if (currentLevel == 15)
			{
				urgotSkills.rHyperKineticPositionReverser(2);
				urgotSkills.eNoxianCorrosiveCharge(5);
				urgotSkills.wTerrorCapacitor(3);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
			else if (currentLevel == 16)
			{
				urgotSkills.rHyperKineticPositionReverser(3);
				urgotSkills.eNoxianCorrosiveCharge(5);
				urgotSkills.wTerrorCapacitor(3);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
			else if (currentLevel == 17)
			{
				urgotSkills.rHyperKineticPositionReverser(3);
				urgotSkills.eNoxianCorrosiveCharge(5);
				urgotSkills.wTerrorCapacitor(4);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
			else
			{
				urgotSkills.rHyperKineticPositionReverser(3);
				urgotSkills.eNoxianCorrosiveCharge(5);
				urgotSkills.wTerrorCapacitor(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
				urgotSkills.qAcidHunter(5);
			}
		}
	}
}
