package masteries.resolve;

import masteries.MasteryTree;


public class Resolve extends MasteryTree {

	@Override
	public void addMasteryByName(String masteryName) {
		if (masteryName.equals("Recovery"))
		{
			Resolve01Recovery resolveM = new Resolve01Recovery();
			addMastery(resolveM);
		}
		else if (masteryName.equals("Unyielding"))
		{
			Resolve01Unyielding resolveM = new Resolve01Unyielding();
			addMastery(resolveM);
		}
		else if (masteryName.equals("Explorer"))
		{
			Resolve02Explorer resolveM = new Resolve02Explorer();
			addMastery(resolveM);
		}
		else if (masteryName.equals("Tough Skin"))
		{
			Resolve02ToughSkin resolveM = new Resolve02ToughSkin();
			addMastery(resolveM);
		}
		else if (masteryName.equals("Runic Armor"))
		{
			Resolve03Runic resolveM = new Resolve03Runic();
			addMastery(resolveM);
		}
		else if (masteryName.equals("Veteran's Scars"))
		{
			Resolve03Veteran resolveM = new Resolve03Veteran();
			addMastery(resolveM);
		}
		else if (masteryName.equals("Insight"))
		{
			Resolve04Insight resolveM = new Resolve04Insight();
			addMastery(resolveM);
		}
		else if (masteryName.equals("Perseverance"))
		{
			Resolve04Perseverance resolveM = new Resolve04Perseverance();
			addMastery(resolveM);
		}
		else if (masteryName.equals("Swiftness"))
		{
			Resolve05Swiftness resolveM = new Resolve05Swiftness();
			addMastery(resolveM);
		}
		else if (masteryName.equals("Legendary Guardian"))
		{
			Resolve05Guardian resolveM = new Resolve05Guardian();
			addMastery(resolveM);
		}
		else if (masteryName.equals("Grasp of the Undying"))
		{
			Resolve06Grasp resolveM = new Resolve06Grasp();
			addMastery(resolveM);
		}
		else if (masteryName.equals("Strength of the Ages"))
		{
			Resolve06Strength resolveM = new Resolve06Strength();
			addMastery(resolveM);
		}
		else if (masteryName.equals("Bond of Stone"))
		{
			Resolve06Bond resolveM = new Resolve06Bond();
			addMastery(resolveM);
		}
		
	}
}
