package runes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class BattleRune {
	
	private ArrayList<Rune> runeCount;
	public BattleRune()
	{
		runeCount = new ArrayList<Rune>(9);
	}
	public ArrayList<Rune> getRuneCount() {
		return runeCount;
	}
	public void addRune(Rune rune)
	{
		runeCount.add(rune);
	}
	public String getRuneTypes()
	{
		StringBuilder runeTypes = new StringBuilder();
		if (runeCount.size() > 0)
		{
			HashMap<String, Integer> mapRuneTypes = 
					new HashMap<String, Integer>(runeCount.size());
			String runeName;
			int currentRuneCount;
			for (Rune rune : runeCount)
			{
				runeName = rune.getRuneName();
				if (mapRuneTypes.containsKey(runeName))
				{
					currentRuneCount = mapRuneTypes.get(runeName) + 1;
					mapRuneTypes.put(runeName, currentRuneCount);
				}

			}
			
			for (Entry<String,Integer> entry : mapRuneTypes.entrySet())
			{
				runeTypes.append(entry.getKey() + " Runes: " + entry.getValue());
			}
			return runeTypes.toString();
		}
		runeTypes.append("No Runes:");
		return runeTypes.toString();
	}
}

