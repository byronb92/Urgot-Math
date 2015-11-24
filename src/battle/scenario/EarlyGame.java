package battle.scenario;

import java.util.ArrayList;

/**
 * @author byronb92
 * http://leagueoflegends.wikia.com/wiki/Experience_(champion)
 * http://mullinator.com/tools/cscore?c=46&t=6.0&p=80
 * Levels 1-9, first legendary item purchase, halfway 2nd item purchase.
 * 18 Waves must spawn for level 9. (10 minutes and 30 seconds of game time.)
 * 75% of creeps hit = 86/144.  --  1804 gold from minions.
 * Passive gold					--  1501 gold
 * Estimated total gold.		-- 	3305
 * 
 * 
 * Early Game Purchases and Combonents to Compare
 * Most efficient first components.
 * 1. Tear
 * 2. Sheen
 * 3. Caulfield's Warhammer
 * 4. Phage
 * 5. Serrated Dirk
 * 
 * Best starting item.
 * 1. Manamune
 * 2. Iceborn Gauntlet
 * 3. Black Cleaver
 * 4. Youmuu's Ghostblade
 *
 */
public class EarlyGame extends Phase {
	

	
	public EarlyGame()
	{
		
	
	}
	
	
	// 9 waves for level 6.
	// Level 6 at 6 minutes in the game.
	// 75% of 9 waves. 845 / 1155 creep gold attained.
	// 988 Passive Gold
	// 1,833 Total Gold
	public void levelSixCompare()
	{
		UrgotScenario tear = new UrgotScenario(6);
		UrgotScenario sheen = new UrgotScenario(6);
		UrgotScenario hammer = new UrgotScenario(6);
		UrgotScenario phage = new UrgotScenario(6);
		UrgotScenario dirk = new UrgotScenario(6);
		
		// TODO: Complete tear interactions
		tear.addAndComputeItem("Tear");
		sheen.addAndComputeItem("Sheen");
		hammer.addAndComputeItem("Caulfield's Warhammer");
		dirk.addAndComputeItem("Serrated Dirk");
		phage.addAndComputeItem("Phage");
		
		addScenario(tear);
		addScenario(sheen);
		addScenario(hammer);
		addScenario(phage);
		addScenario(dirk);
	}
	

	

	
	

}
