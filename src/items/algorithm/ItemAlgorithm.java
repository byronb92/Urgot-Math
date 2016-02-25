package items.algorithm;

import battle.BattleSetup;
import battle.SkillRankType;
import scenario.UrgotScenario;

public class ItemAlgorithm {
	private ItemObjects itemObjects;
	
	public ItemAlgorithm()
	{
		itemObjects = new ItemObjects();
	}
	
	public UrgotScenario bestDamageItemToAdd(UrgotScenario sce, String itemCategory) throws CloneNotSupportedException
	{
//		UrgotScenario duplicateSce = (UrgotScenario) sce.deepClone(sce);
//		duplicateSce.addItem("Long Sword");
//		duplicateSce.computeBattleScenario(BattleSetup.ALLIN_NOULT, SkillRankType.STANDARD);
		
		return null;
	}
}
