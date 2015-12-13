package runes.seals;

import runes.BattleRune;

public class Seals extends BattleRune {

	@Override
	public void setUpRuneTable() {
		// Primary
		this.mapRuneValueLookup.put("Armor", 1.0);
		this.mapRuneValueLookup.put("Health", 8.0);
		this.mapRuneValueLookup.put("Energy Regen", 0.63);
		this.mapRuneValueLookup.put("Percentage Health", 0.05);
		this.mapRuneValueLookup.put("Health Regeneration", 0.56); // hp per 5
		this.mapRuneValueLookup.put("Mana Regeneration", 0.41); // hp per 5
		this.mapRuneValueLookup.put("Scaling Armor", 0.16);
		this.mapRuneValueLookup.put("Scaling Health", 1.33);
		this.mapRuneValueLookup.put("Scaling Energy Regen", 0.064);
		this.mapRuneValueLookup.put("Scaling Health Regeneration", 0.11);
		this.mapRuneValueLookup.put("Scaling Mana Regeneration", 0.065); // hp per 5
	}

}
