package battle;

import java.util.Map.Entry;

import items.Item;
import items.ItemManager;
import urgot.*;
public class OutputUrgotStats {
	
	UrgotStats urgot;
	ItemManager itemManager;
	UrgotCombos urgCombos;
	BattleCalculator battleManager;
	public OutputUrgotStats(int currentLevel)
	{
		urgot = new UrgotStats(currentLevel);
		itemManager = new ItemManager(urgot);		
		
		//TODO: Consolidate into an independent method.
		itemManager.setItemSetOne();
		battleManager = new BattleCalculator();
		urgCombos = new UrgotCombos(battleManager, urgot);
	}
	
	/**
	 * Output current item set costs. 
	 */
	public void outputItemCosts()
	{
		for(Entry<String,Item> item: itemManager.getItems().getItems().entrySet())
		{
			System.out.println(item.getValue().getName() + ": " + item.getValue().getCost());
		}
	}
	
	/**
	 * Display the current items contained in the current set.
	 */
	public void outputUrgotItems()
	{
		for(Entry<String,Item> item: itemManager.getItems().getItems().entrySet())
		{
			System.out.println(item.getValue().getName());
			if (item.getValue().getDetails() != null)
			{
				System.out.println(item.getValue().getDetails());
			}
		}
		
	}
	

	
	/**
	 * Output urgot statistics for comparing.
	 */
	public void outputUrgotStats()
	{
		System.out.println("Current Level: " + urgot.getLevel());
		System.out.println("Total AD: " + urgot.getTotalAD());
		System.out.println("Total Mana: " + urgot.getTotalMana());
		System.out.println("Current CDR: " + urgot.getCDR());
		System.out.println("Current Armor Pen: " + urgot.getArmorPen());
		System.out.println("Current Armor Reduc: " + urgot.getArmorReduc());
	}
	
	public void outputBattleNumbers()
	{
		System.out.println("Damage Done: " + battleManager.getADDamage());
		if (itemManager.containsItem("Death's Dance"))
		{
			System.out.println("Death's Dance Damage Healed: " + 
					battleManager.getADDamage() * 0.12);
		}
		System.out.println("Mana Usage: " + battleManager.getManaUsage());
		System.out.println("Shield Amount: " + battleManager.getShieldPoints());
		System.out.println("Battle Time: " + battleManager.getCastTime());
	}

	
	public void outputLevelCombo()
	{
		System.out.println("Level Six Combo");
		urgCombos.levelSix();
		outputBattleNumbers();
		System.out.println("------------");
		outputUrgotStats();
		System.out.println("------------");
		outputUrgotItems();
	}

}
