package runes.glyphs;

import runes.BattleRune;

public class Glyphs extends BattleRune {

	@Override
	public void setUpRuneTable() {
		this.mapRuneValueLookup.put("Ability Power", 1.19);
		this.mapRuneValueLookup.put("Cooldown Reduction", 0.83);
		this.mapRuneValueLookup.put("Magic Resist", 1.34);
		this.mapRuneValueLookup.put("Mana", 11.25);
		this.mapRuneValueLookup.put("Scaling Ability Power", 0.17);
		this.mapRuneValueLookup.put("Scaling Cooldown Reduction", 0.09);
		this.mapRuneValueLookup.put("Scaling Magic Resist", 0.16);
		this.mapRuneValueLookup.put("Scaling Mana", 1.42);
	}

}
