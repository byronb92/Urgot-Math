package battle;

import java.util.ArrayList;
import java.util.HashMap;

public class UrgotAbilityLevels {
	HashMap<SkillRankType, ArrayList<UrgotSkillRank>> abilityRanks;
	
	
	
	public UrgotAbilityLevels()
	{
		abilityRanks = new HashMap<SkillRankType, ArrayList<UrgotSkillRank>>();
		addStandardAbilities();
		addShieldStartAbilities();
	}
	
	private void addStandardAbilities()
	{
		ArrayList<UrgotSkillRank> standardRank = new ArrayList<UrgotSkillRank>(18);
		standardRank.add(new UrgotSkillRank(1,0,0,0));
		standardRank.add(new UrgotSkillRank(1,0,1,0));
		standardRank.add(new UrgotSkillRank(2,0,1,0));
		standardRank.add(new UrgotSkillRank(2,1,1,0));
		standardRank.add(new UrgotSkillRank(3,1,1,0));
		standardRank.add(new UrgotSkillRank(3,1,1,1));
		standardRank.add(new UrgotSkillRank(4,1,1,1));
		standardRank.add(new UrgotSkillRank(4,1,2,1));
		standardRank.add(new UrgotSkillRank(5,1,2,1));
		standardRank.add(new UrgotSkillRank(5,1,3,1));
		standardRank.add(new UrgotSkillRank(5,1,3,2));
		standardRank.add(new UrgotSkillRank(5,1,4,2));
		standardRank.add(new UrgotSkillRank(5,1,5,2));
		standardRank.add(new UrgotSkillRank(5,2,5,2));
		standardRank.add(new UrgotSkillRank(5,3,5,2));
		standardRank.add(new UrgotSkillRank(5,3,5,3));
		standardRank.add(new UrgotSkillRank(5,4,5,3));
		standardRank.add(new UrgotSkillRank(5,5,5,3));
		abilityRanks.put(SkillRankType.STANDARD, standardRank);
	}
	
	private void addShieldStartAbilities()
	{
		ArrayList<UrgotSkillRank> shieldStart = new ArrayList<UrgotSkillRank>(18);
		shieldStart.add(new UrgotSkillRank(0,1,0,0));
		shieldStart.add(new UrgotSkillRank(1,1,0,0));
		shieldStart.add(new UrgotSkillRank(2,1,0,0));
		shieldStart.add(new UrgotSkillRank(2,1,1,0));
		shieldStart.add(new UrgotSkillRank(3,1,1,0));
		shieldStart.add(new UrgotSkillRank(3,1,1,1));		// Level 6
		shieldStart.add(new UrgotSkillRank(4,1,1,1));
		shieldStart.add(new UrgotSkillRank(4,2,1,1));
		shieldStart.add(new UrgotSkillRank(5,2,1,1));
		shieldStart.add(new UrgotSkillRank(5,3,1,1));
		shieldStart.add(new UrgotSkillRank(5,3,1,2));		// Level 11
		shieldStart.add(new UrgotSkillRank(5,4,1,2));
		shieldStart.add(new UrgotSkillRank(5,5,1,2));
		shieldStart.add(new UrgotSkillRank(5,5,2,2));
		shieldStart.add(new UrgotSkillRank(5,5,3,2));
		shieldStart.add(new UrgotSkillRank(5,5,3,3));		// Level 16
		shieldStart.add(new UrgotSkillRank(5,5,4,3));
		shieldStart.add(new UrgotSkillRank(5,5,5,3));
		abilityRanks.put(SkillRankType.TRADE, shieldStart);
	}
	
	
	public int getUrgotQBasedOnLevel(SkillRankType rankType, int urgotLevel)
	{
		return abilityRanks.get(rankType).get(urgotLevel-1).getQLevel();
	}
	
	public int getUrgotWBasedOnLevel(SkillRankType rankType, int urgotLevel)
	{
		return abilityRanks.get(rankType).get(urgotLevel-1).getWLevel();
	}
	
	public int getUrgotEBasedOnLevel(SkillRankType rankType, int urgotLevel)
	{
		return abilityRanks.get(rankType).get(urgotLevel-1).getELevel();
	}
	
	public int getUrgotRBasedOnLevel(SkillRankType rankType, int urgotLevel)
	{
		return abilityRanks.get(rankType).get(urgotLevel-1).getRLevel();
	}


}
