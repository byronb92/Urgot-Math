package items;

import items.items.*;

public class ItemFactory {
	public Item getItem(String itemName)
	{
		// Always include the amount of stacks after Manamune.
		if (itemName.contains("Manamune"))
		{
			String manaMuneStacks = (String)itemName.subSequence(8, itemName.length());
			int muneStacks = Integer.parseInt(manaMuneStacks);
			return new Manamune(muneStacks);
		}
		
		if (itemName.equals("Sheen"))
		{
			return new Sheen();
		}
		
		if (itemName.equals("Caulfield's Warhammer"))
		{
			return new CaulfieldWarhammer();
		}
		
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
			return new YoumuuGhostblade();
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
		
		if (itemName.equals("Righteous Glory"))
		{
			return new RighteousGlory();
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
		return null;
	}

}
