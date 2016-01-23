package masteries.ferocity;

import masteries.MasteryTree;

public class Ferocity extends MasteryTree {


	@Override
	public void addMasteryByName(String masteryName) {
		if (masteryName.equals("Fury"))
		{
			Ferocity01Fury furyM = new Ferocity01Fury();
			addMastery(furyM);
		}
		else if (masteryName.equals("Sorcery"))
		{
			Ferocity01Sorcery furyM = new Ferocity01Sorcery();
			addMastery(furyM);
		}
		else if (masteryName.equals("Feast"))
		{
			Ferocity02Feast furyM = new Ferocity02Feast();
			addMastery(furyM);
		}
		else if (masteryName.equals("Double-Edged Sword"))
		{
			Ferocity02Sword furyM = new Ferocity02Sword();
			addMastery(furyM);
		}
		else if (masteryName.equals("Natural Talent"))
		{
			Ferocity03NaturalTalent furyM = new Ferocity03NaturalTalent();
			addMastery(furyM);
		}
		else if (masteryName.equals("Vampirism"))
		{
			Ferocity03Vampirism furyM = new Ferocity03Vampirism();
			addMastery(furyM);
		}
		else if (masteryName.equals("Bounty Hunter"))
		{
			Ferocity04Bounty furyM = new Ferocity04Bounty();
			addMastery(furyM);
		}
		else if (masteryName.equals("Oppressor"))
		{
			Ferocity04Oppressor furyM = new Ferocity04Oppressor();
			addMastery(furyM);
		}
		else if (masteryName.equals("Battering Blows"))
		{
			Ferocity05Blows furyM = new Ferocity05Blows();
			addMastery(furyM);
		}
		else if (masteryName.equals("Piercing Thoughts"))
		{
			Ferocity05Thoughts furyM = new Ferocity05Thoughts();
			addMastery(furyM);
		}
		else if (masteryName.equals("Warlord's Bloodlust"))
		{
			Ferocity06Bloodlust furyM = new Ferocity06Bloodlust();
			addMastery(furyM);
		}
		else if (masteryName.equals("Fervor of Battle"))
		{
			Ferocity06Fervor furyM = new Ferocity06Fervor();
			addMastery(furyM);
		}
		else if (masteryName.equals("Deathfire Touch"))
		{
			Ferocity06Deathfire furyM = new Ferocity06Deathfire();
			addMastery(furyM);
		}
		
	}
}
