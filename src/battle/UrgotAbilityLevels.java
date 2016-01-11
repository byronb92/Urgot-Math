package battle;

import java.util.ArrayList;
import java.util.HashMap;

public class UrgotAbilityLevels {
	HashMap<SkillRankType, ArrayList<UrgotSkillRank>> abilityRanks;
	
	
	
	public UrgotAbilityLevels()
	{
		abilityRanks = new HashMap<SkillRankType, ArrayList<UrgotSkillRank>>();
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


}
