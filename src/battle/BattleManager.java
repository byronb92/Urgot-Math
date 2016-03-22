package battle;

import java.util.HashMap;
import java.util.LinkedList;

import battle.actions.AutoAttack;
import battle.actions.BattleAction;
import battle.actions.UrgotE;
import battle.actions.UrgotQ;
import battle.actions.UrgotR;
import battle.actions.UrgotW;
import urgot.UrgotStats;

/** Manages interaction between Battle and BattleAction classes. */
public class BattleManager implements Cloneable {
	private LinkedList<BattleAction> listBattleActions;
	private Battle battle;
	private UrgotStats urgot;
	

	
	public BattleManager(UrgotStats urgot)
	{
		listBattleActions = new LinkedList<BattleAction>();
		battle = new Battle();
		this.urgot = urgot;
	}
	
	public Object Clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	
	public Battle getBattle()
	{
		return battle;
	}
	
	
	public LinkedList<BattleAction> getBattleActions()
	{
		return listBattleActions;
	}

	
	public void battleSetup(BattleSetup battleSetup, SkillRankType rankType)
	{
		UrgotAbilityLevels urgotAbilities = new UrgotAbilityLevels();
		int qRank = urgotAbilities.getUrgotQBasedOnLevel(rankType, urgot.getLevel());
		int wRank = urgotAbilities.getUrgotWBasedOnLevel(rankType, urgot.getLevel());
		int eRank = urgotAbilities.getUrgotEBasedOnLevel(rankType, urgot.getLevel());
		int rRank = urgotAbilities.getUrgotRBasedOnLevel(rankType, urgot.getLevel());
		switch (battleSetup)
		{
		case AUTOTRADE:
			if (wRank > 0)
			{
				addBattleAction(new UrgotW(wRank));
			}
			addBattleAction(new AutoAttack());
			addBattleAction(new AutoAttack());
			addBattleAction(new AutoAttack());
			break;
		case AUTOTRADE_NO_W:
			addBattleAction(new AutoAttack());
			addBattleAction(new AutoAttack());
			addBattleAction(new AutoAttack());
			break;
		case POKE:
			addBattleAction(new UrgotQ(qRank));
			break;
		case POKE_AUTOWEAVE:
			addBattleAction(new UrgotW(wRank));
			addBattleAction(new UrgotQ(qRank));
			addBattleAction(new AutoAttack());
			break;
		case POKE_EXTENDED:
			addBattleAction(new UrgotQ(qRank));
			addBattleAction(new UrgotQ(qRank));
			addBattleAction(new UrgotQ(qRank));
			break;
		case POKE_COMBO:
			addBattleAction(new UrgotW(wRank));
			addBattleAction(new UrgotE(eRank));
			addBattleAction(new UrgotQ(qRank));
			addBattleAction(new UrgotQ(qRank));
			addBattleAction(new UrgotQ(qRank));
			break;
		case ALLIN_NOULT:
			addBattleAction(new UrgotW(wRank));
			addBattleAction(new UrgotE(eRank));
			addBattleAction(new UrgotQ(qRank));
			addBattleAction(new AutoAttack());
			addBattleAction(new AutoAttack());
			addBattleAction(new UrgotQ(qRank));
			addBattleAction(new AutoAttack());
			addBattleAction(new UrgotQ(qRank));
			break;
		case ALLIN_ULT:
			addBattleAction(new UrgotW(wRank));
			addBattleAction(new UrgotR(rRank));
			addBattleAction(new UrgotE(eRank));
			addBattleAction(new UrgotQ(qRank));
			addBattleAction(new AutoAttack());
			addBattleAction(new AutoAttack());
			addBattleAction(new UrgotQ(qRank));
			addBattleAction(new AutoAttack());
			addBattleAction(new UrgotQ(qRank));
			addBattleAction(new AutoAttack());

			break;
		default:
			addBattleAction(new UrgotW(wRank));
			addBattleAction(new UrgotE(eRank));
			addBattleAction(new UrgotQ(qRank));
			addBattleAction(new UrgotQ(qRank));
			addBattleAction(new UrgotQ(qRank));
			break;
		}

	}
	

	
	public void runBattleCalculations()
	{
		urgot.getEffects().sortEffects();
		HashMap<String,Double> battleTimeMap = new HashMap<String,Double>();		
		for (int i = 0; i < listBattleActions.size(); i++)
		{
			BattleAction currentAction = listBattleActions.get(i);
			handleBattleTime(battleTimeMap, currentAction);
			currentAction.runBattleCalculations(battle, urgot);
			applyAfterBattleActionEffects(currentAction);
		}
		applyAfterBattleEffects();
	}
	
	public void runBattleCalculationsDynamically()
	{
		urgot.getEffects().sortEffects();
		HashMap<String,Double> battleTimeMap = new HashMap<String,Double>();		
		for (int i = 0; i < listBattleActions.size(); i++)
		{
			BattleAction currentAction = listBattleActions.get(i);
			handleBattleTime(battleTimeMap, currentAction);
			double preCalcPhysicalDamage = battle.getPhysicalDamage();
			currentAction.runBattleCalculations(battle, urgot);
			double physicalDamageAdded = battle.getPhysicalDamage() - preCalcPhysicalDamage;
			applyAfterBattleActionEffects(currentAction);
		}
		applyAfterBattleEffects();
	}
	

	private void handleBattleTime(HashMap<String,Double> battleMap, BattleAction battleAction)
	{
		double skillTime = 0;
		if (battleAction instanceof UrgotQ)
		{
			
			UrgotQ urgQ = (UrgotQ)battleAction;
			skillTime = urgQ.getCdrCooldown(urgot.getCDR()) + urgQ.getCastTime();
			if (!battleMap.containsKey("UrgotQ"))
			{
				 skillTime = 0;
				 battleMap.put("UrgotQ", skillTime);
			}
			else
			{
				double oldSkillTime = battleMap.get("UrgotQ");
				double totalTime = oldSkillTime + skillTime;
				battleMap.put("UrgotQ", totalTime);
				battle.addBattleTime(skillTime);
				
			}
			
		}

		else if (battleAction instanceof AutoAttack)
		{
			skillTime = urgot.getTotalAS();
			if (!battleMap.containsKey("AutoAttack"))
			{
				 skillTime = 0;
				 battleMap.put("AutoAttack", skillTime);
			}
			else
			{
				double oldSkillTime = battleMap.get("UrgotQ");
				double totalTime = oldSkillTime + skillTime;
				battleMap.put("AutoAttack", totalTime);
				battle.addBattleTime(skillTime);
			}
		}
	}
		
	private void addBattleAction(BattleAction action)
	{
		listBattleActions.add(action);
	}
	
	private void applyAfterBattleActionEffects(BattleAction action)
	{
		urgot.getEffects().runActionEffects(battle, urgot, action);
	}
	
	private void applyAfterBattleEffects()
	{
		urgot.getEffects().runAfterBattleEffects(battle, urgot);
	}
	
	

	
	
}
