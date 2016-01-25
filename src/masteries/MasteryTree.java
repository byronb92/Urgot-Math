package masteries;

import java.util.ArrayList;

public abstract class MasteryTree {
	private ArrayList<Mastery> listTreeMasteries;
	public MasteryTree()
	{
		setListTreeMasteries(new ArrayList<Mastery>(6));
	}
	public ArrayList<Mastery> getListTreeMasteries() {
		return listTreeMasteries;
	}
	public void setListTreeMasteries(ArrayList<Mastery> listTreeMasteries) {
		this.listTreeMasteries = listTreeMasteries;
	}
	public void addMastery(Mastery mastery)
	{
		int zeroBasedIndex = mastery.getTier() - 1;
		listTreeMasteries.add(zeroBasedIndex, mastery);
	}
	public abstract void addMasteryByName(String masteryName);
	
	

}
