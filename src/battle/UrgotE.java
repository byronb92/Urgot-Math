package battle;

import urgot.UrgotStats;

public class UrgotE extends Spell {

	public UrgotE(int spellRank)
	{
		super(spellRank, 
				50 + (5 * spellRank - 1), 
				SpellCostType.MANA, 
				15 - (1 * spellRank - 1), 
				0.25);
	}

	@Override
	public void runBattleCalculations(Battle battle, UrgotStats urgot) {
		double baseDps = 11 * (getSpellRank() - 1);
		double scalingDps = 15 + urgot.getBonusAD() * 0.12;
		double totalDps = baseDps + scalingDps;
		
		// Urgot E ticks 5 times in 5 seconds.
		battle.addSpellCast();
		battle.addPhysicalDamage(totalDps);
		battle.addPhysicalDamage(totalDps);
		battle.addPhysicalDamage(totalDps);
		battle.addPhysicalDamage(totalDps);
		battle.addPhysicalDamage(totalDps);
		battle.addSpellDamage(totalDps*5);
		
	}

}
