package scenario;

import java.util.Map.Entry;

import battle.Battle;
import battle.BattleManager;
import battle.BattleSetup;
import battle.SkillRankType;
import items.Item;
import items.ItemManager;
import items.Items;
import masteries.Masteries;
import masteries.MasteryManager;
import masteries.MasterySet;
import runes.RuneManager;
import runes.RuneSetup;
import urgot.UrgotCombos;
import urgot.UrgotStats;



/**
 * A scenario class sets up an Urgot object's items, runes, and masteries.
 * Then the items are run through battle simulations through the BattleCalculator.
 *
 * Order of an UrgotScenario's life:
 * Add runes and items.
 * Add masteries that are standalone (don't depend on other any battle scenarios)
 * Compute all of the bonus stats given by runes, items, and masteries.
 * Add masteres that depend on item stats. (%Bonus Armor/MR etc.)
 * Compute battle situations.
 * Add masteries that depend on battle scenarios(Increasing healing, etc.)
 * Add items effects that depend o battle scenarios (Healing based off damaage done)
 * 
 * @author byronb92
 *
 */
public class UrgotScenario {
	private UrgotStats urgot;
	private ItemManager itemManager;
	private RuneManager runeManager;
	private MasteryManager masteryManager;
	private BattleManager battleManager;
	

	public UrgotScenario(int currentLevel)
	{
		urgot = new UrgotStats(currentLevel);
		masteryManager = new MasteryManager(urgot);
		runeManager = new RuneManager(urgot);
		itemManager = new ItemManager(urgot);
		battleManager = new BattleManager(urgot);
	}
	

	
	
	public void addRunes(RuneSetup rs)
	{
		runeManager.setUpRunes(rs);
	}
	
	public void addItem(String itemName)
	{
		itemManager.addItem(itemName);
	}
	

	public void addAndComputeItem(String itemName)
	{
		itemManager.addItem(itemName);
		itemManager.computeItemStats();
	}
	
	
	
	/**
	 * Used to quickly apply rune and mastery sets to scenario objects.
	 * @param runes
	 * @param masteries
	 */
	public void setUpRunesAndMasteries(RuneSetup runes, MasterySet masteries)
	{
		runeManager.setUpRunes(runes);
		masteryManager.masterySetup(masteries);
	}
	
	
	/**
	 * Calculates rune, mastery, and item stats and applies their effects.
	 */
	public void computeStats()
	{
		runeManager.computeRuneStats();
		itemManager.computeItemStats();
		masteryManager.computeMasteryStats();
	}
	

	
	

	
	
	public void computeBattleScenario()
	{
		battleManager.runBattleCalculations();
	}
	
	public void computeBattleScenario(BattleSetup battleSetup, SkillRankType rankType)
	{
		battleManager.battleSetup(battleSetup, rankType);
		battleManager.runBattleCalculations();
	}
	
	/**
	 * Some items unique passivee and actives are only relevant after
	 * item stats are added and battle situations are generated.
	 * Should be run last.
	 */
	public void computeAfterBattleItemStats()
	{
		for(Entry<String,Item> item: itemManager.getItems().getItems().entrySet())
		{
			// Add every item stat value.
			item.getValue().applyAfterBattleUniques(battleManager.getBattle());
		}
	}
	



	

	
	// -------------- Accessor Methods -------------- 
	public Battle getBattleStats()
	{
		return battleManager.getBattle();
	}
	
	public UrgotStats getUrgotStats()
	{
		return urgot;
	}
	
	public Items getUrgotItems()
	{
		return itemManager.getItems();
	}
	
	public RuneManager getRuneManager()
	{
		return runeManager;
	}
	
	public MasteryManager getMasteryManager()
	{
		return masteryManager;
	}
}
