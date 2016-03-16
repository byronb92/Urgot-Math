package battle.actions.effects;

import battle.Battle;
import battle.actions.BattleAction;
import battle.dynamic.DynamicCompleteDamage;
import battle.dynamic.DynamicEnemyResistances;
import urgot.UrgotStats;

public class BlackCleaverAfterAction extends EffectAfterAction {
	
	private double stacks;
	private double physicalAttacksDonePreviously;
	private double damageLastAttack;
	
	public BlackCleaverAfterAction()
	{
		stacks = 0;
		physicalAttacksDonePreviously = 0;
		damageLastAttack = 0;
	}

	private void addStack(UrgotStats urgot)
	{
		stacks++;
		if (stacks > 6)
		{
			stacks = 6;
		}
		else
		{
			urgot.addPercentArmReduc(0.05);
		}
	}
	@Override
	public void runEffectCalculations(Battle battle, BattleAction action, UrgotStats urgot) {

	}
	
	@Override
	/**
	 * For black Cleaver, computes damage before stack is adding, then
	 * adds a stack and increases armor penetration.
	 * @param battle
	 * @param action
	 * @param urgot
	 */
	public void runDynamicEffectCalculations(Battle battle, 
			BattleAction action, UrgotStats urgot, DynamicEnemyResistances enemy)
	{
		double damageIncrease = battle.getPhysicalDamage() - damageLastAttack;
		double physicalAttackIncrease = battle.getPhysicalAttacks() - physicalAttacksDonePreviously;
		if (physicalAttackIncrease > 0)
		{
			battle.undoLastPhysicalAddition(damageIncrease);
			double damagePerAttackUnit = damageIncrease / physicalAttackIncrease;
			for (int i = 0; i < physicalAttackIncrease; i++)
			{
				DynamicCompleteDamage damageObj = urgot.computeDamageAfterResistances(
						urgot, damagePerAttackUnit, 
						enemy.getBaseArmor(), enemy.getBonusArmor());
						
				double damageAfterResistances = damageObj.getPhysicalDamage();
				battle.addPhysicalDamage(damageAfterResistances);
				addStack(urgot);
			}
		}
		damageLastAttack = battle.getPhysicalDamage();
		physicalAttacksDonePreviously = physicalAttackIncrease;
	}


}
