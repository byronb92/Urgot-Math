package scenario;

import java.util.Map.Entry;

import calc.BattleCalculator;
import items.Item;
import items.ItemManager;
import items.Items;
import masteries.Masteries;
import masteries.MasterySet;
import runes.RuneManager;
import runes.RuneSetup;
import runes.Runes;
import urgot.UrgotCombos;
import urgot.UrgotStats;

public class UrgotScenario {
	private UrgotStats urgot;
	private ItemManager itemManager;
	private RuneManager runeManager;
	private Masteries masteries;
	private UrgotCombos urgCombos;
	private BattleCalculator battleManager;
	

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
		battleManager = new BattleCalculator();
	}
	
	
	public void addItem(String itemName)
	{
		itemManager.addItem(itemName);
	}
	
	public void computeAfterBattleItemStats()
	{
		for(Entry<String,Item> item: itemManager.getItems().getItems().entrySet())
		{
			// Add every item stat value.
			item.getValue().applyAfterBattleUniques(battleManager);
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
		masteries.applyUrgotMasteryAfterBattle(mastery, urgot, battleManager);
	}


	/**
	 * Adds item and rune stats to Urgot's stats. 
	 * This should always be rune before computing combos, even if no items are added.
	 */
	public void computeStats()
	{
		urgCombos = new UrgotCombos(battleManager, urgot);
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
		urgCombos = new UrgotCombos(battleManager, urgot);
		itemManager.computeItemStats();
	}
	
	// -------------- Accessor Methods -------------- 
	// These methods should only be used once an Urgot object has been created.
	public BattleCalculator getBattleStats()
	{
		return battleManager;
	}
	
	public UrgotStats getUrgotStats()
	{
		return urgot;
	}
	
	
	public UrgotCombos getUrgotCombos()
	{
		return urgCombos;
	}
	
	public Items getUrgotItems()
	{
		return itemManager.getItems();
	}
	
	public Masteries getMasteries()
	{
		return masteries;
	}

}
