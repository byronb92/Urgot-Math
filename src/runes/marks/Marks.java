package runes.marks;

import runes.BattleRune;

public class Marks extends BattleRune {

	@Override
	public void setUpRuneTable() {
		// Primary Runes
		this.mapRuneValueLookup.put("Armor Penetration", 1.28);
		this.mapRuneValueLookup.put("Attack Damage", 0.95);
		this.mapRuneValueLookup.put("Attack Speed", 0.017);
		this.mapRuneValueLookup.put("Critical Chance", 0.93);
		this.mapRuneValueLookup.put("Critical Damage", 0.93);
		this.mapRuneValueLookup.put("Hybrid Penetration Armor", 0.9);
		this.mapRuneValueLookup.put("Hybrid Penetration Magic", 0.62);
		this.mapRuneValueLookup.put("Magic Penetration", 0.87);
		this.mapRuneValueLookup.put("Scaling Attack Damage", 0.135);	// Calculate this per level.
		
		
		// Secondary Runes
		this.mapRuneValueLookup.put("Health", 3.47);
		this.mapRuneValueLookup.put("Cooldown Reduction", 0.20);
		this.mapRuneValueLookup.put("Armor", 0.91);
		this.mapRuneValueLookup.put("Ability Power", 0.59);
		this.mapRuneValueLookup.put("Mana", 5.91);
		this.mapRuneValueLookup.put("Mana Regeneration", 0.26);
		this.mapRuneValueLookup.put("Magic Resist", 0.77);
		this.mapRuneValueLookup.put("Scaling Ability Power", 0.1); // Per level
		this.mapRuneValueLookup.put("Scaling Health", 0.54); // Per level
		this.mapRuneValueLookup.put("Scaling Magic Resist", 0.07); // Per leve
		this.mapRuneValueLookup.put("Scaling Mana", 1.17); // Per leve
	}

	
}
