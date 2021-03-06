package battle.actions;

import battle.Battle;
import battle.SpellCostType;
import urgot.UrgotStats;

public class UrgotQ extends Spell {

	public UrgotQ(int spellRank)
	{
		super(spellRank, 40, SpellCostType.MANA, 2, 0.25);
		setSpellType("Damage");
	}

	@Override
	public void runBattleCalculations(
			Battle battle, UrgotStats urgot) {
		double baseDamage = 30 * (getSpellRank() - 1);
		double scalingDamage = urgot.getTotalAD() * 0.85;
		double totalDamage = 10 + baseDamage + scalingDamage;
		battle.addPhysicalDamage(totalDamage);		
		battle.addSpellDamage(totalDamage);
		battle.addSpellCast();
	}

}
