package battle.actions.effects;

import java.util.HashMap;

import battle.Battle;
import battle.actions.AutoAttack;
import battle.actions.BattleAction;
import battle.actions.Spell;
import battle.actions.effects.SheenWrapper.SheenVariation;
import urgot.UrgotStats;

public class SheenAfterAction extends EffectAfterAction {
	private HashMap <BattleAction, Double> prevActions;
	private boolean isSheenActive;
	private double sheenCooldown = 0;

	private SheenWrapper sheenWrapper;
	public SheenAfterAction(SheenVariation sheenType)
	{
		prevActions = new HashMap<BattleAction, Double>();
		sheenWrapper = new SheenWrapper(sheenType);
	}
	
	@Override
	public void runEffectCalculations(Battle battle, BattleAction action, UrgotStats urgot) 
	{
		if (action instanceof Spell && sheenCooldown == 0)
		{
			isSheenActive = true;
			Spell castedSpell = (Spell)action; 
			prevActions.put(castedSpell, castedSpell.getCdrCooldown(urgot.getCDR()));
		}
		
		else if (action instanceof AutoAttack && isSheenActive)
		{
			// TODO: Do trinity force, iceborn gauntlet math.
			battle.addPhysicalDamage(urgot.getBaseADFromLevel() * sheenWrapper.getSheenCoefficient());
			sheenCooldown = 1.5;
			isSheenActive = false;
		}
		else if (action instanceof AutoAttack && !isSheenActive)
		{
			reduceSheenCooldown(urgot.getTotalAS());
		}
		else if (sheenCooldown <= 1.5 && action instanceof Spell)
		{
			// Spell hasn't been casted yet.:
			Spell castedSpell = (Spell)action; 
			if (prevActions.containsKey(castedSpell))
			{
				reduceSheenCooldown(castedSpell.getCastTime() +
						castedSpell.getCdrCooldown(urgot.getCDR()));
			}
			else
			{
				prevActions.put(castedSpell, castedSpell.getCdrCooldown(urgot.getCDR()));
			}
		}
	}
	
	
	private void reduceSheenCooldown(double cd)
	{
		sheenCooldown = sheenCooldown - cd;
		if (sheenCooldown < 0)
		{
			sheenCooldown = 0;
		}
	}

}
