package output;

import battle.BattleManager;
import battle.BattleSetup;
import items.ItemManager;
import masteries.Masteries;
import masteries.MasterySet;
import runes.RuneManager;
import runes.RuneSetup;
import scenario.StatSetup;

public class StatAggregator {
	
	private RuneManager runeM;
	private ItemManager im;
	private Masteries mstr;
	private BattleManager bm;
	public StatAggregator()
	{
		
	}
	
	
	public void setManagers(RuneManager rune, ItemManager item,
			Masteries mastery, BattleManager battle)
	{
		runeM = rune;
		im = item;
		mstr = mastery;
		bm = battle;
	}
	
	
	public void computeBattleNumbers(RuneSetup runes, MasterySet masteries,
			StatSetup items, BattleSetup battleActions)
	{
		 runeM.setUpRunes(runes);
		 //mstr.applyUrgotMastery(mastery, urgot);
	}

}
