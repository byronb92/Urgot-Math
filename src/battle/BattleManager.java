package battle;

import java.util.LinkedList;
import java.util.ListIterator;

import urgot.UrgotStats;

public class BattleManager {
	private LinkedList<BattleAction> listBattleActions;
	private Battle battle;
	private UrgotStats urgot;
	
	
	public BattleManager(UrgotStats urgot)
	{
		listBattleActions = new LinkedList<BattleAction>();
		battle = new Battle();
		this.urgot = urgot;
	}
	

	
	
	private void addBattleAction(BattleAction action)
	{
		listBattleActions.add(action);
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
			addBattleAction(new UrgotQ(qRank));
			addBattleAction(new AutoAttack());
			break;
		case ALLIN_ULT:
			addBattleAction(new UrgotR(rRank));
			addBattleAction(new UrgotW(wRank));
			addBattleAction(new UrgotE(eRank));
			addBattleAction(new UrgotQ(qRank));
			addBattleAction(new AutoAttack());
			addBattleAction(new AutoAttack());
			addBattleAction(new UrgotQ(qRank));
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
		for (int i = 0; i < listBattleActions.size(); i++)
		{
			BattleAction currentAction = listBattleActions.get(i);
			currentAction.runBattleCalculations(battle, urgot);
			applyAfterBattleActionEffects(currentAction);
		}
		applyAfterBattleEffects();
	}
	
	
	
	 
	private void applyAfterBattleActionEffects(BattleAction action)
	{
		urgot.getEffects().runActionEffects(battle, urgot, action);
	}
	
	private void applyAfterBattleEffects()
	{
		urgot.getEffects().runAfterBattleEffects(battle, urgot);
	}
	
	
	public Battle getBattle()
	{
		return battle;
	}
	
	
	public LinkedList<BattleAction> getBattleActions()
	{
		return listBattleActions;
	}
	
	
}
