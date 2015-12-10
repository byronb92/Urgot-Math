package scenario;

import calc.BattleCalculator;
import items.ItemManager;
import items.Items;
import urgot.UrgotCombos;
import urgot.UrgotStats;

public class UrgotScenario {
	private UrgotStats urgot;
	private ItemManager itemManager;
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
		battleManager = new BattleCalculator();
	}
	
	
	public void addItem(String itemName)
	{
		itemManager.addItem(itemName);
	}
	

	
	public void computeStats()
	{
		urgCombos = new UrgotCombos(battleManager, urgot);
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

}
