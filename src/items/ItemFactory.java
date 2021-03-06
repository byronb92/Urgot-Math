package items;

import items.items.*;

public class ItemFactory {
	public Item getItem(String itemName)
	{
		// Basic Items
		// Always include the amount of stacks after Manamune.
		if (itemName.equals("Manamune"))
		{
			return new Manamune(0);
		}
		else if (itemName.contains("Manamune"))
		{
			String manaMuneStacks = (String)itemName.subSequence(8, itemName.length());
			int muneStacks = Integer.parseInt(manaMuneStacks);
			return new Manamune(muneStacks);
		}
		
		if (itemName.equals("Tear"))
		{
			return new Tear(0);
		}
		
		else if (itemName.contains("Tear"))
		{
			String manaMuneStacks = (String)itemName.subSequence(4, itemName.length());
			int muneStacks = Integer.parseInt(manaMuneStacks);
			return new Tear(muneStacks);
		}
		
		if (itemName.equals("Sheen"))
		{
			return new Sheen();
		}
		
		if (itemName.equals("Caulfield's Warhammer"))
		{
			return new CaulfieldWarhammer();
		}
		
		if (itemName.equals("Serrated Dirk"))
		{
			return new SerratedDirk();
		}
		
		if (itemName.equals("Phage"))
		{
			return new Phage();
		}
		
		
		
		// Legendary Items
		if (itemName.equals("Black Cleaver"))
		{
			return new BlackCleaver();
		}
		
		if (itemName.equals("Youmuu's Ghostblade"))
		{
			return new YoumuuGhostblade();
		}
		
		if (itemName.equals("Lord Dominik's Regards"))
		{
			return new LordDominiksRegards();
		}
		if (itemName.equals("Maw of Malmortius"))
		{
			return new MawOfMalmortius();
		}
		if (itemName.equals("Trinity Force"))
		{
			return new TrinityForce();
		}
		if (itemName.equals("Death's Dance"))
		{
			return new DeathsDance();
		}
		
		
		if (itemName.equals("Sterak's Gage"))
		{
			return new SteraksGage();
		}
		
		if (itemName.equals("Righteous Glory"))
		{
			return new RighteousGlory();
		}
		
		
		// Defensive Items
		if (itemName.equals("Randuin's Omen"))
		{
			return new RanduinsOmen();
		}
		if (itemName.equals("Thornmail"))
		{
			return new Thornmail();
		}
		if (itemName.equals("Sunfire Cape"))
		{
			return new SunfireCape();
		}
		

		if (itemName.equals("Zz'Rot Portal"))
		{
			return new ZzRotPortal();
		}
		
		if (itemName.equals("Banshee's Veil"))
		{
			return new BansheesVeil();
		}
		
		if (itemName.equals("Muramana"))
		{
			return new Muramana();
		}
		
		if (itemName.equals("Boots of Speed"))
		{
			return new Boots();
		}
		
		if (itemName.equals("Ionian Boots of Lucidity"))
		{
			return new BootsIonian();
		}
		
		if (itemName.equals("Ninja Tabi"))
		{
			return new BootsNinja();
		}
		
		if (itemName.equals("Mercury's Treads"))
		{
			return new BootsTreads();
		}
		
		if (itemName.equals("Iceborn Gauntlet"))
		{
			return new IcebornGauntlet();
		}
		
		if (itemName.equals("Frozen Heart"))
		{
			return new FrozenHeart();
		}
		
		if (itemName.equals("Spirit Visage"))
		{
			return new SpiritVisage();
		}
		
		if (itemName.equals("Dead Man's Plate"))
		{
			return new DeadMansPlate();
		}
		
		if (itemName.equals("Doran's Blade"))
		{
			return new DoransBlade();
		}
		
		if (itemName.equals("Long Sword"))
		{
			return new LongSword();
		}
		
		if (itemName.equals("Cloth Armor"))
		{
			return new ClothArmor();
		}
		
		if (itemName.equals("Sapphire Crystal"))
		{
			return new SapphireCrystal();
		}
		
		if (itemName.equals("Duskblade of Draktharr"))
		{
			return new DuskbladeOfDraktharr();
		}
		
		if (itemName.equals("Corrupting Potion"))
		{
			return new CorruptingPotion();
		}
		
		if (itemName.equals("RefillablePotion"))
		{
			return new RefillablePotion();
		}
		if (itemName.equals("Hextech Gunblade"))
		{
			return new HextechGunblade();
		}
		if (itemName.equals("Locket of the Iron Solari"))
		{
			return new LocketOfTheIronSolari();
		}
		
		if (itemName.equals("Mortal Reminder"))
		{
			return new MortalReminder();
		}
		
		if (itemName.equals("Mercurial Scimitar"))
		{
			return new MercurialScimitar();
		}
		
		if (itemName.equals("Warmog's Armor"))
		{
			return new WarmogsArmor();
		}
		
		
		if (itemName.equals("Frozen Mallet"))
		{
			return new FrozenMallet();
		}
		
		if (itemName.equals("Guardian Angel"))
		{
			return new GuardianAngel();
		}
		
		
		
		System.err.println("Invalid item name: " + itemName);
		return null;
	}

}
