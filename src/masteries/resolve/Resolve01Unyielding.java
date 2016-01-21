package masteries.resolve;

import urgot.UrgotStats;

public class Resolve01Unyielding extends Mastery {

	public Resolve01Unyielding() {
		super(1);
	}

	@Override
	public void runMasteryCalculations(UrgotStats urgot) {
		double bonusUnyieldingArmor = urgot.getBonusArmor() * 0.05;
		double bonusUnyieldingMR = urgot.getBonusMR() * 0.05;
		urgot.addBonusArmor(bonusUnyieldingArmor);
		urgot.addBonusMR(bonusUnyieldingMR);
		setMasteryDetails("Unyielding: 5% bonus armor (+" + bonusUnyieldingArmor 
				+ ")  and 5% bonus MR. (+ " + bonusUnyieldingMR + ")");
		
	}

}
