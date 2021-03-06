package battle.actions.effects;

import java.util.ArrayList;

import battle.Battle;
import battle.actions.BattleAction;
import urgot.UrgotStats;

public class EffectManager {
	private ArrayList<Effect> listEffects;
	private ArrayList<EffectAfterAction> listAfterActionEffects;
	private ArrayList<EffectAfterBattle> listAfterBattleEffects;
	
	
	public EffectManager()
	{
		listEffects = new ArrayList<Effect>();
		listAfterActionEffects = new ArrayList<EffectAfterAction>();
		listAfterBattleEffects = new ArrayList<EffectAfterBattle>();
	}
	
	public void addEffect(Effect effect)
	{
		listEffects.add(effect);
	}
	
	/** Seperates effects into different maps to prevent unnecessary calling */
	public void sortEffects()
	{
		for (int i = 0; i < listEffects.size(); i++)
		{
			if (listEffects.get(i).getEffectType().equals("After Action"))
			{
				listAfterActionEffects.add((EffectAfterAction) listEffects.get(i));	
			}
			else if (listEffects.get(i).getEffectType().equals("After Battle"))
			{
				listAfterBattleEffects.add((EffectAfterBattle) listEffects.get(i));
			}
		}
	}
	
	public void runActionEffects(Battle battle, UrgotStats urgot, BattleAction action)
	{
		for (int i = 0; i < listAfterActionEffects.size(); i++)
		{
			listAfterActionEffects.get(i).runEffectCalculations(battle, action, urgot);
		}
	}
	
	public void runAfterBattleEffects(Battle battle, UrgotStats urgot)
	{
		for (int i = 0; i < listAfterBattleEffects.size(); i++)
		{
			listAfterBattleEffects.get(i).runEffectCalculations(battle, urgot);
		}
	}
	
	
	public Effect getEffectByClassName(String className)
	{
		if (className.equals("Deathfire After Action"))
		{
			return findClassInEffects("Deathfire After Action");
		}
		System.err.println("Incorrect class name (" + className
				+ ") given. No object returned.");
		return null;
	}
	
	private Effect findClassInEffects(String effectName)
	{
		if (effectName.equals("Deathfire After Action"))
		{
			for (int i = 0; i < listAfterActionEffects.size(); i++)
			{
				Effect currentAction = listAfterActionEffects.get(i);
				if (currentAction instanceof DeathfireAfterAction)
				{
					return currentAction;
				}
			}
		}
		System.err.println("An error occured, class was not found.");
		return null;

	}
	
	
}
