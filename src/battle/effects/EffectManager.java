package battle.effects;

import java.util.ArrayList;

import battle.AutoAttack;
import battle.BattleAction;
import battle.Spell;

public class EffectManager {
	private ArrayList<Effect> listEffects;
	private ArrayList<Effect> listAfterActionEffects;
	private int autoAttacks = 0;
	private int damageSpells = 0; 
	private int nonDamageSpells = 0;
	
	
	public EffectManager()
	{
		listEffects = new ArrayList<Effect>();
		listAfterActionEffects = new ArrayList<Effect>();
	}
	
	/**
	 * Sorts effects to be called only when they are added properly.
	 * Prevents unnecessary calling of effects.
	 */
	public void sortEffects()
	{
		for (int i = 0; i < listEffects.size(); i++)
		{
			if (listEffects.get(i).getEffectType().equals("After Action"))
			{
				listAfterActionEffects.add(listEffects.get(i));	
			}
		}
	}
	
	public void runActionEffects(BattleAction action)
	{
		if (action instanceof AutoAttack)
		{
			autoAttacks++;
		}
		else if (action instanceof Spell)
		{
			Spell currentSpell = (Spell)action;
			if (currentSpell.getSpellType().equals("Damage"))
			{
				damageSpells++;
			}
		}
		// TODO: Make UrgotW and UrgotR be involved in spell counting.
		for (int i = 0; i < listAfterActionEffects.size(); i++)
		{
			listAfterActionEffects.get(i).runEffectCalculations();
		}
	}
}
