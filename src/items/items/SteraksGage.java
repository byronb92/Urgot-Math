package items.items;

import items.Item;
import urgot.UrgotStats;

// TODO: Redo numbers with sheen and trinity force, base AD calculations are mucked up.
// TODO: To-DO: Does (0.4375) When the passive procs, does it give you
// 0.25+ more base damage.
public class SteraksGage extends Item {

	private int hp = 500;
	private double baseAD = 0.25;
	private UrgotStats urgot;
	private boolean passiveApplied = false;
	
	@Override
	public void applyPassive(UrgotStats urgot) {
		passiveApplied = true;
		this.urgot = urgot;
		setDetails();
	}

	@Override
	public void addItemStats(UrgotStats urgot) {
		urgot.addBonusBaseAD(baseAD);
		urgot.addBonusHP(hp);
		
	}

	@Override
	protected void setCost() {
		cost = 2700;
		
	}

	@Override
	protected void setName() {
		name = "Sterak's Gage";
		
	}

	@Override
	protected void setDetails() {
		if (passiveApplied)
		{
			details = "Damage needed to take for activation per level:" 
					+ "5:400, 6:400 , 7:440 , 8:500, 9:580, 10:700, 11:825, "
					+ "12:950, 13:1100, 14:1250, 15:1400, 16:1550, 17:1700, 18:1800\n" 
					+ "Max HP decaying Shield: ( " + urgot.getTotalHP() + ")";
		}
		else
		{
			details = "Damage needed to take for activation per level:" 
					+ "5:400, 6:400 , 7:440 , 8:500, 9:580, 10:700, 11:825, "
					+ "12:950, 13:1100, 14:1250, 15:1400, 16:1550, 17:1700, 18:1800\n" 
					+ "Max HP decaying Shield: (30% max hp) for 8 seconds ";
		}
		
	}
	
	
	@Override
	protected void setCategory() {
		category.put("Health", "");
		category.put("Attack Damage", "");
		
	}
	

}
