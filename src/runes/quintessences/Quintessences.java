package runes.quintessences;

import runes.UtilityRune;

public class Quintessences extends UtilityRune {

	@Override
	public void setUpRuneTable() {
		this.mapRuneValueLookup.put("Ability Power", 4.95);
		this.mapRuneValueLookup.put("Armor", 4.26);
		this.mapRuneValueLookup.put("Gold", 1.0);
		this.mapRuneValueLookup.put("Health", 26.0);
		this.mapRuneValueLookup.put("Health Regeneration", 2.7);
		this.mapRuneValueLookup.put("Mana", 37.5);
		this.mapRuneValueLookup.put("Mana Regeneration", 1.25);
		this.mapRuneValueLookup.put("Percent Health", 0.0125);
		this.mapRuneValueLookup.put("Scaling Mana Regeneration", 0.24);
		
		// Secondary
		this.mapRuneValueLookup.put("Attack Damage", 2.25);
		this.mapRuneValueLookup.put("Armor Penetration", 2.56);
		this.mapRuneValueLookup.put("Attack Speed", 0.045);
		
	}
	

}
