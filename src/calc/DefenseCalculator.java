package calc;

import scenario.UrgotScenario;

public class DefenseCalculator {
	
	
	public DefenseCalculator()
	{
		
	}
	
	public double findHealthVsPhysical(UrgotScenario sce)
	{
		double healthA = sce.getUrgotStats().getTotalHP();
		//double physicalReductionA = (100 / (100+sce.getUrgotStats().getTotalArmor()));
		
		// http://forums.na.leagueoflegends.com/board/showthread.php?t=601034
		// double trueHP = healthA / physicalReductionA;
		double trueHP = healthA + ((healthA * 0.01)*(sce.getUrgotStats().getTotalArmor()));
		return trueHP;
	}
	
	public double findHealthVsMagic(UrgotScenario sce)
	{
		double healthA = sce.getUrgotStats().getTotalHP();
		//double magicReductionA = (100 / (100+sce.getUrgotStats().getTotalMR()));
		
		//double trueHP = healthA / magicReductionA;
		double trueHP = healthA + ((healthA * 0.01)*(sce.getUrgotStats().getTotalMR()));
		return trueHP;
	}
	
	/**
	 * Determines if the first parameter is tankier than the second.
	 * @param sce
	 * @param sc2
	 * @return
	 */
	public boolean isTankierArmor(UrgotScenario sce, UrgotScenario sc2)
	{
		if (findHealthVsPhysical(sce) > findHealthVsPhysical(sce))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Determines if the first parameter is tankier than the second.
	 * @param sce
	 * @param sc2
	 * @return
	 */
	public boolean isTankierMagic(UrgotScenario sce, UrgotScenario sc2)
	{
		if (findHealthVsMagic(sce) > findHealthVsMagic(sce))
		{
			return true;
		}
		return false;
	}

}
