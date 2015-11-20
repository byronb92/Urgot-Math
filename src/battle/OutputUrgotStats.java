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
		
	}
	
	public void configureItemSet(int setNumb)
	{
		itemManager.applyItemSet(setNumb);
		battleManager = new BattleCalculator();
		urgCombos = new UrgotCombos(battleManager, urgot);
		itemManager.computeItemStats();
	}
	
	/**
	 * Display the current items and their descriptions.
	 */
	public void outputUrgotItems()
	{
		for(Entry<String,Item> item: itemManager.getItems().getItems().entrySet())
		{
			System.out.print(item.getValue().getName());
			if (item.getValue().getDetails() != null)
			{
				System.out.print(": " + item.getValue().getDetails());
				System.out.println();
			}
		}
		
	}
	// Output item costs individually.
	public void outputIndividualCosts()
	{
		for(Entry<String,Item> item: itemManager.getItems().getItems().entrySet())
		{
			System.out.println(item.getValue().getName() + ": " + item.getValue().getCost());
		}
	}
	

	// Output combined cost of all current items.
	public void outputTotalCosts()
	{
		int runningCost = 0;
		for(Entry<String,Item> item: itemManager.getItems().getItems().entrySet())
		{
			runningCost = runningCost + item.getValue().getCost();
		}
		System.out.println("Combined Item Cost: " + runningCost);
	}
	

	
	// Output offensive and defensive statistics.
	public void outputUrgotStats()
	{
		outputOffense();
		outputDefense();
	}
	
	private void outputOffense()
	{
		System.out.println("Offensive Stats");
		System.out.println("Current Level: " + urgot.getLevel());
		System.out.println("Total AD: " + urgot.getTotalAD());
		System.out.println("Bonus AD: " + urgot.getBonusAD());
		System.out.println("Total Mana: " + urgot.getTotalMana());
		System.out.println("Current CDR: " + urgot.getCDR());
		System.out.println("Current Armor Pen: " + urgot.getArmorPen());
		System.out.println("Current Armor Reduc: " + urgot.getArmorReduc());
		System.out.println("-----------------");
	}
	private void outputDefense()
	{
		System.out.println("Defensive Stats");
		System.out.println("HP: " + urgot.getTotalHP());
		System.out.println("Armor: " + urgot.getTotalArmor());
		System.out.println("Magic Resistance: " + urgot.getTotalMR());
		System.out.println("Damage Reduction: " + (1 - urgot.getDamageReduc()));
		System.out.println("Physical Damage Received " 
				+ (urgot.getResistanceReduction(urgot.getTotalArmor())));
		System.out.println("Magic Damage Received " 
				+ (urgot.getResistanceReduction(urgot.getTotalMR())));
		System.out.println("-----------------");

		
	}
	// Output data relating to urgot combo performed.
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
		System.out.println("-----------------");
	}

	
	
	
	// ------------- Combos -------------
	
	public void outputMaxCombo()
	{
		System.out.println("Lock-on Combo");
		urgCombos.lockOnWithUlt(urgot.getLevel());
		outputBattleNumbers();
		outputUrgotStats();
		outputUrgotItems();
		outputTotalCosts();
	}

}
