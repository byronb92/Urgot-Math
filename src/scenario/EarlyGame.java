package scenario;


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
 * Best starting item comparison.
 * 1. Manamune
 * 2. Iceborn Gauntlet
 * 3. Black Cleaver
 * 4. Youmuu's Ghostblade
 *
 */

// 9 waves for level 6.
// Level 6 at 6 minutes in the game.
// 75% of 9 waves. 845 / 1155 creep gold attained.
// 988 Passive Gold
// 1,833 Total Gold
public class EarlyGame extends Phase {
	

	
	public EarlyGame()
	{
		
	
	}
	
	/**
	 * Compares Youmuu's Ghostblade to Black Cleaver.
	 * Black Cleaver gives the best power spike for Urgot.
	 */
	public void ghostbladeVsCleaver()
	{
		UrgotScenario gun = new UrgotScenario(6);
		UrgotScenario cleaver = new UrgotScenario(6);
		
		gun.addAndComputeItem("Youmuu's Ghostblade");
		cleaver.addAndComputeItem("Black Cleaver");
		
		gun.getUrgotCombos().lockOnWithUlt(6);
		cleaver.getUrgotCombos().lockOnWithUlt(6);
		
		addScenario(gun);
		addScenario(cleaver);
	}
	/**
	 * If auto attacks can be weaved into between Urgot's combo, 
	 * Sheen is the superior early game item.
	 * Sheen should be compared to Serrated Dirk, which gives
	 * the highest raw early game stats.
	 */
	public void earlySheenDamage()
	{
		UrgotScenario sheen = new UrgotScenario(6);
		sheen.addAndComputeItem("Sheen");
		sheen.getUrgotCombos().lockOnWithUlt(6);
		addScenario(sheen);
	}
	/**
	 * Helps output the importance of armor pen vs. ad in the early game.
	 * Theory: Serrated Dirk provides more early game damage than Caulfield's Hammer.
	 * https://docs.google.com/spreadsheets/d/1id4DbG1pK-ylib1MYoqL0jyXeaFsTDtL_Th20754TJU/edit#gid=985991436&vpid=A1
	 */
	public void CaulfieldVsDirk()
	{
		UrgotScenario dirk = new UrgotScenario(6);
		UrgotScenario hammer = new UrgotScenario(6);
		
		hammer.addAndComputeItem("Caulfield's Warhammer");
		dirk.addAndComputeItem("Serrated Dirk");
		
		hammer.getUrgotCombos().lockOnWithUlt(6);
		dirk.getUrgotCombos().lockOnWithUlt(6);
		
		addScenario(dirk);
		addScenario(hammer);
	}
	

	/**
	 * Compares first-level component items before legendaries are built.
	 * Creates 5 scenarios and finds the highest raw damage output. 
	 * This does not take into account the opponent's armor value.
	 */
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
		
		
		tear.getUrgotCombos().lockOnWithUlt(6);
		sheen.getUrgotCombos().lockOnWithUlt(6);
		phage.getUrgotCombos().lockOnWithUlt(6);
		hammer.getUrgotCombos().lockOnWithUlt(6);
		dirk.getUrgotCombos().lockOnWithUlt(6);
	
		
		addScenario(tear);
		addScenario(sheen);
		addScenario(hammer);
		addScenario(phage);
		addScenario(dirk);
	}
	

	

	
	

}
