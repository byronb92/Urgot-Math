package masteries.cunning;

import masteries.MasteryTree;



public class Cunning extends MasteryTree {

	@Override
	public void addMasteryByName(String masteryName) {
		if (masteryName.equals("Wanderer"))
		{
			Cunning01Wanderer cunningM = new Cunning01Wanderer();
			addMastery(cunningM);
		}
		else if (masteryName.equals("Savagery"))
		{
			Cunning01Savagery cunningM = new Cunning01Savagery();
			addMastery(cunningM);
		}
		else if (masteryName.equals("Runic Affinity"))
		{
			Cunning02Runic cunningM = new Cunning02Runic();
			addMastery(cunningM);
		}
		else if (masteryName.equals("Assassin"))
		{
			Cunning02Assassin cunningM = new Cunning02Assassin();
			addMastery(cunningM);
		}
		else if (masteryName.equals("Secret Stash"))
		{
			Cunning02Secret cunningM = new Cunning02Secret();
			addMastery(cunningM);
		}
		else if (masteryName.equals("Merciless"))
		{
			Cunning03Merciless cunningM = new Cunning03Merciless();
			addMastery(cunningM);
		}
		else if (masteryName.equals("Meditation"))
		{
			Cunning03Meditation cunningM = new Cunning03Meditation();
			addMastery(cunningM);
		}
		else if (masteryName.equals("Bandit"))
		{
			Cunning04Bandit cunningM = new Cunning04Bandit();
			addMastery(cunningM);
		}
		else if (masteryName.equals("Dangerous Game"))
		{
			Cunning04Dangerous cunningM = new Cunning04Dangerous();
			addMastery(cunningM);
		}
		else if (masteryName.equals("Precision"))
		{
			Cunning05Precision cunningM = new Cunning05Precision();
			addMastery(cunningM);
		}
		else if (masteryName.equals("Intelligence"))
		{
			Cunning05Intelligence cunningM = new Cunning05Intelligence();
			addMastery(cunningM);
		}
		else if (masteryName.equals("Stormraider's Surge"))
		{
			Cunning06Storm cunningM = new Cunning06Storm();
			addMastery(cunningM);
		}
		else if (masteryName.equals("Thunderlord's Decree"))
		{
			Cunning06Thunder cunningM = new Cunning06Thunder();
			addMastery(cunningM);
		}
		else if (masteryName.equals("Windspeaker's Blessing "))
		{
			Cunning06Wind cunningM = new Cunning06Wind();
			addMastery(cunningM);
		}
		else
		{
			System.out.println("Invalid mastery: " + masteryName);
		}
		
	}
	
	 
}	
