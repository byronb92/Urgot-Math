package battle;

import java.util.LinkedList;
import java.util.ListIterator;

import calc.BattleCalculator;
import urgot.UrgotStats;

public class BattleManager {
	private LinkedList<BattleAction> listBattleActions;
	private BattleCalculator battleCalc;
	private UrgotStats urgot;
	
	public BattleManager(BattleCalculator battleCalc, UrgotStats urgot, BattleSetup battleSetup)
	{
		listBattleActions = new LinkedList<BattleAction>();
		this.battleCalc = battleCalc;
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
		int wRank = urgotAbilities.getUrgotQBasedOnLevel(rankType, urgot.getLevel());
		int eRank = urgotAbilities.getUrgotQBasedOnLevel(rankType, urgot.getLevel());
		int rRank = urgotAbilities.getUrgotQBasedOnLevel(rankType, urgot.getLevel());
		switch (battleSetup)
		{
		case AUTOTRADE:
			addBattleAction(new UrgotW(wRank));
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
			break;
		}

	}
	
	public void runBattleCalculations()
	{
		ListIterator<BattleAction> listIterator = listBattleActions.listIterator();
		while (listIterator.hasNext()) {
			listIterator.next().runBattleCalculations(battleCalc, urgot);
		}
	}
	
}
