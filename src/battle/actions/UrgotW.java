package battle.actions;

import battle.Battle;
import battle.SpellCostType;
import urgot.UrgotStats;

public class UrgotW extends Spell {

	public UrgotW(int spellRank)
	{
		super(spellRank, 
				55 + (5 * spellRank - 1), 
				SpellCostType.MANA, 
				16 - (1 * spellRank - 1), 
				0);
		// Notes: Urgot W does not have a cast time.
	}

	@Override
	public void runBattleCalculations(Battle battle, UrgotStats urgot) {
		double baseShieldAmount = 40 * getSpellRank() - 1;
		double scalingAmount = (urgot.getBonusAP() * 0.8) + 
				(urgot.getTotalMana() * 0.08);
		double totalShieldAmount = 60 + baseShieldAmount + scalingAmount;
		battle.addShieldAmount(totalShieldAmount);
		battle.addSpellCast();		
	}

}
