package runes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public abstract class UtilityRune {
	private ArrayList<Rune> runeCount;
	protected HashMap<String,Double> mapRuneValueLookup;
	public UtilityRune()
	{
		runeCount = new ArrayList<Rune>(3);
		mapRuneValueLookup = new HashMap<String,Double>();
	}
	
	public abstract void setUpRuneTable();
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
				else
				{
					mapRuneTypes.put(runeName, 1);
				}
				

			}
			setUpRuneTable();
			for (Entry<String,Integer> entry : mapRuneTypes.entrySet())
			{
				runeTypes.append(entry.getKey() + " Runes: " + entry.getValue()
				 + " (+" + (getRuneValueByName(entry.getKey())* entry.getValue()) + ")");
				runeTypes.append("\n");
			}
			return runeTypes.toString();
		}
		runeTypes.append("No Runes:");
		return runeTypes.toString();
	}
	public ArrayList<Rune> getRunes()
	{
		return runeCount;
	}
	private double getRuneValueByName(String rn)
	{
		return mapRuneValueLookup.get(rn);
	}
}
