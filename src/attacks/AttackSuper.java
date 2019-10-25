package attacks;

public class AttackSuper {
	String englishName, japaneseName, type;
	double baseAccuracy;
	int pp, basePower;
	
	public AttackSuper(int pp) {
		this.pp = pp;
	}
	
	public String getAttackName(String theLanguage) {
		if (theLanguage == "English") {
			return englishName;
		}
		
		else {
			return japaneseName;
		}
		
	}

}
