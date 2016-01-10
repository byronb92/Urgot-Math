package attacks;

import calc.BattleCalculator;
import urgot.UrgotStats;

public class UrgotQ extends Spell {

	public UrgotQ(int spellRank)
	{
		super(spellRank, 40, SpellCostType.MANA, 40, 0.25);
	}

	@Override
	public void runBattleCalculations(
			BattleCalculator battle, UrgotStats urgot) {
		double baseDamage = 30 * (getSpellRank() - 1);
		double scalingDamage = urgot.getTotalAD() * 0.85;
		double totalDamage = 10 + baseDamage + scalingDamage;
		battle.addPhysicalDamage(totalDamage);		
		battle.addSpellAttack();
	}

}
