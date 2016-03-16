package battle.dynamic;


public class DynamicResistModifier {
	
	private String name;
	private double armorReduc_Flat;
	private double armorReduc_Percent;
	private double armorPen_Percent;
	private double armorPenBonus_Percent; 		// Last Whisper
	private double armorPen_Flat;
	
	private double magicReduc_Flat;
	private double magicReduc_Percent;
	private double magicPen_Percent;
	private double magicPen_Flat;
	
	public DynamicResistModifier(String name)
	{
		this.name = name;
	}
	public String getName() { return name; }
	
	public void setArmorModifications(
			double armorReduc_Flat, double armorReduc_Percent,
			double armorPen_Percent, double armorPenBonus_Percent, double armorPen_Flat)
	{
		this.armorReduc_Flat = armorReduc_Flat;
		this.armorReduc_Percent = armorReduc_Percent;
		this.armorPen_Percent = armorPen_Percent;
		this.armorPenBonus_Percent = armorPenBonus_Percent;
		this.armorPen_Flat = armorPen_Flat;
	}
	public void setMagicResistanceModifications(
			double magicReduc_Flat, double magicReduc_Percent,
			double magicPen_Percent, double magicPen_Flat)
	{
		this.magicReduc_Flat = magicReduc_Flat;
		this.magicReduc_Percent = magicReduc_Percent;
		this.magicPen_Percent = magicPen_Percent;
		this.magicPen_Flat = magicPen_Flat;
	}
	public double getTrueEnemyArmor(double enemyBaseArmor, double enemyBonusArmor)
	{
		// Armor reduction is split between base and bonus armor.
		double trueEnemyBaseArmor = enemyBaseArmor - (armorReduc_Flat/2);
		double trueEnemyBonusArmor = enemyBonusArmor - (armorReduc_Flat/2);
		
		
		trueEnemyBaseArmor = trueEnemyBaseArmor * (armorReduc_Percent);
		trueEnemyBonusArmor = trueEnemyBonusArmor * armorReduc_Percent;
		
		trueEnemyBaseArmor = trueEnemyBaseArmor - (trueEnemyBaseArmor * armorPen_Percent);
		trueEnemyBonusArmor = trueEnemyBonusArmor - (trueEnemyBonusArmor * armorPen_Percent);
		trueEnemyBonusArmor = trueEnemyBonusArmor - (trueEnemyBonusArmor * armorPenBonus_Percent);
		
		
		double enemyTrueArmor = trueEnemyBaseArmor + trueEnemyBonusArmor;
		enemyTrueArmor = enemyTrueArmor - armorPen_Flat;
		return enemyTrueArmor;
		
		/*
		 * 		double armorReduc_Flat = 0; // Urgot has no flat armor reduction.
		double armorReduc_Percent = sce.getUrgotStats().getPercentArmorReduc();
		double armorPen_Percent = sce.getUrgotStats().getPercentArmorPen();
		double armorPen_BonusPercent = sce.getUrgotStats().getBonusPercentArmorPen();
		double armorPen_Flat = sce.getUrgotStats().getFlatArmorPen();
		
		// Armor reduction is split between base and bonus armor.
		double trueEnemyBaseArmor = enemyBaseArmor - (armorReduc_Flat/2);
		double trueEnemyBonusArmor = enemyBonusArmor - (armorReduc_Flat/2);


		trueEnemyBaseArmor = trueEnemyBaseArmor * (armorReduc_Percent);
		trueEnemyBonusArmor = trueEnemyBonusArmor * armorReduc_Percent;

		trueEnemyBaseArmor = trueEnemyBaseArmor - (trueEnemyBaseArmor * armorPen_Percent);
		trueEnemyBonusArmor = trueEnemyBonusArmor - (trueEnemyBonusArmor * armorPen_Percent);
		trueEnemyBonusArmor = trueEnemyBonusArmor - (trueEnemyBonusArmor * armorPen_BonusPercent);


		double enemyTrueArmor = trueEnemyBaseArmor + trueEnemyBonusArmor;
		enemyTrueArmor = enemyTrueArmor - armorPen_Flat;
		return enemyTrueArmor;
		 */
	}
	public double getTrueEnemyMR(double enemyBaseMR, double enemyBonusMR)
	{
		double trueEnemyBaseMR = enemyBaseMR - (magicReduc_Flat/2);
		double trueEnemyBonusMR = enemyBonusMR - (magicReduc_Flat/2);
		
		
		trueEnemyBaseMR = trueEnemyBaseMR * (magicReduc_Percent);
		trueEnemyBonusMR = trueEnemyBonusMR * magicReduc_Percent;
		
		trueEnemyBaseMR = trueEnemyBaseMR - (trueEnemyBaseMR * magicPen_Percent);
		trueEnemyBonusMR = trueEnemyBonusMR - (trueEnemyBonusMR * magicPen_Percent);
		
		
		double enemyTrueMR = trueEnemyBaseMR+ trueEnemyBonusMR;
		enemyTrueMR = enemyTrueMR - magicPen_Flat;
		return enemyTrueMR;
	}
	
}
