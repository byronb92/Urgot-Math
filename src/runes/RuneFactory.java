package runes;
import runes.marks.*;
import runes.seals.*;
import runes.glyphs.*;

public class RuneFactory {

	public Rune getMark(String runeName)
	{
		if (runeName.equals("Armor Penetration"))
		{
			return new MarkArmorPen();
		}
		
		if (runeName.equals("Attack Damage"))
		{
			return new MarkAttackDamage();
		}
		
		if (runeName.equals("Attack Speed"))
		{
			return new MarkAttackSpeed();
		}
		
		if (runeName.equals("Critical Chance"))
		{
			return new MarkCritChance();
		}
		
		if (runeName.equals("Hybrid Penetration"))
		{
			return new MarkHybridPen();
		}
		System.err.println("Invalid rune name: " + runeName);
		return null;
	}
	public Rune getSeal(String runeName)
	{
		if (runeName.equals("Armor"))
		{
			return new SealArmor();
		}
		
		if (runeName.equals("Health"))
		{
			return new SealArmor();
		}
		
		if (runeName.equals("Energy Regen"))
		{
			return new SealEnergyRegen();
		}
		
		if (runeName.equals("Percentage Health"))
		{
			return new SealPercentageHealth();
		}
		
		if (runeName.equals("Health Regeneration"))
		{
			return new SealHealthRegen();
		}
		
		if (runeName.equals("Health Regeneration"))
		{
			return new SealHealthRegen();
		}
		
		if (runeName.equals("Mana Regeneration"))
		{
			return new SealManaRegen();
		}
		
		System.err.println("Invalid rune name: " + runeName);
		return null;
	}
	
	public Rune getGlyph(String runeName)
	{
		if (runeName.equals("Ability Power"))
		{
			return new GlyphAP();
		}
		
		if (runeName.equals("Cooldown Reduction"))
		{
			return new GlyphCD();
		}
		
		if (runeName.equals("Magic Resist"))
		{
			return new GlyphMR();
		}
		
		if (runeName.equals("Mana"))
		{
			return new GlyphMana();
		}
		System.err.println("Invalid rune name: " + runeName);
		return null;
	}
	
	
	public Rune getQuint(String runeName)
	{
		if (runeName.equals("Armor Penetration"))
		{
			
		}
		System.err.println("Invalid rune name: " + runeName);
		return null;
	}

}
