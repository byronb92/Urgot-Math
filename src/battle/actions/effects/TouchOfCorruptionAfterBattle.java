package battle.actions.effects;

import battle.Battle;
import urgot.UrgotStats;

public class TouchOfCorruptionAfterBattle extends EffectAfterBattle {

	@Override
	public void runEffectCalculations(Battle battle, UrgotStats urgot)
	{
		double corruptionRawDamage = battle.getBattleTime() / 3;
		int corrupInteger = (int)corruptionRawDamage;
		double integerToDoubleDifference = corruptionRawDamage - corrupInteger;
		if (integerToDoubleDifference > 0)
		{
			corruptionRawDamage = corruptionRawDamage + 3;
		}

		double baseCorruptionDamage = 15 * (1 - urgot.getLevel());
		double fullCorruptionTick = corruptionRawDamage * baseCorruptionDamage;
		battle.addMagicDamage(fullCorruptionTick);
	}

}
