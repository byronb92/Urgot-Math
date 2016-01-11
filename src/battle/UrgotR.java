package battle;

import calc.BattleCalculator;
import urgot.UrgotStats;

public class UrgotR extends Spell {

	public UrgotR(int spellRank)
	{
		super(spellRank, 
				100,
				SpellCostType.MANA, 
				120 - (20 * (spellRank - 1)),
				1);
	}

	@Override
	public void runBattleCalculations(BattleCalculator battle, UrgotStats urgot) {
		battle.addSpellCast();
		
	}

}
