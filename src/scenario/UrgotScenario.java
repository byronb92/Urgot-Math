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
	private Masteries masteries;
	//private UrgotCombos urgCombos;
	//private BattleCalculator battleManager;
	private BattleManager battleManager;
	

	/**
	 * Set-up the manager for one single use.
	 * @param currentLevel
	 */
	public UrgotScenario(int currentLevel)
	{
		urgot = new UrgotStats(currentLevel);
		itemManager = new ItemManager(urgot);
		runeManager = new RuneManager(urgot);
		masteries = new Masteries();
		battleManager = new BattleManager(urgot);
	}
	
	
	public void addItem(String itemName)
	{
		itemManager.addItem(itemName);
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
	
	
	public void addRunes(RuneSetup rs)
	{
		runeManager.setUpRunes(rs);
	}
	
	public void addPreItemMastery(MasterySet mastery)
	{
		masteries.applyUrgotMastery(mastery, urgot);
	}
	
	public void addAfterItemMastery(MasterySet mastery)
	{
		masteries.applyUrgotMasteryAfterItems(mastery, urgot);
	}
	
	public void addAfterBattleMastery(MasterySet mastery)
	{
		masteries.applyUrgotMasteryAfterBattle(mastery, urgot, battleManager.getBattle());
	}


	/**
	 * Adds item and rune stats to Urgot's stats. 
	 * This should always be run before computing combos, even if no items are added.
	 */
	public void computeStats()
	{
		//urgCombos = new UrgotCombos(battleManager, urgot);
		runeManager.getRunes().computeRuneStats(urgot);
		itemManager.computeItemStats();
	}
	
	/**
	 * For single item comparisons.
	 * @param itemName
	 */
	public void addAndComputeItem(String itemName)
	{
		itemManager.addItem(itemName);
		//urgCombos = new UrgotCombos(battleManager, urgot);
		itemManager.computeItemStats();
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
	
	
//	public UrgotCombos getUrgotCombos()
//	{
//		return urgCombos;
//	}
	
	public void computeBattleScenario()
	{
		battleManager.runBattleCalculations();
	}
	
	public void computeBattleScenario(BattleSetup battleSetup, SkillRankType rankType)
	{
		battleManager.battleSetup(battleSetup, rankType);
		battleManager.runBattleCalculations();
	}
	
	public Items getUrgotItems()
	{
		return itemManager.getItems();
	}
	
	public Masteries getMasteries()
	{
		return masteries;
	}
	
	public RuneManager runeManager()
	{
		return runeManager;
	}

}
