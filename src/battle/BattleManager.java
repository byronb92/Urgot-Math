package battle;

import java.util.ArrayList;
import java.util.HashMap;
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
	
	
	public void battleSetup(BattleSetup battleSetup)
	{
		switch (battleSetup)
		{
		case AUTOTRADE:
			break;
		case AUTOTRADE_NO_W:
			break;
		case POKE:
			break;
		case POKE_AUTOWEAVE:
			break;
		case POKE_EXTENDED:
			break;
		case POKE_COMBO:
			break;
		case ALLIN_NOULT:
			break;
		case ALLIN_ULT:
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
	
	public void getUrgotSkillRanks(SkillRankType rankType, int urgotLevel)
	{

		
		//abilityRanks.put(SkillRankType.STANDARD, value)
	}
}
