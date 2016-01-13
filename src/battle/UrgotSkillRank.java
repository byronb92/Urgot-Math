package battle;

public class UrgotSkillRank {
	private int qRank = 0;
	private int wRank = 0;
	private int eRank = 0;
	private int rRank = 0;
	
	public UrgotSkillRank(int q, int w, int e, int r)
	{
		qRank = q;
		wRank = w;
		eRank = e;
		rRank = r;
	}

	public int getQLevel() { return qRank; }
	public int getWLevel() { return wRank; }
	public int getELevel() { return eRank; }
	public int getRLevel() { return rRank; }
}
