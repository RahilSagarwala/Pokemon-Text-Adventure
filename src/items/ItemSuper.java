package items;

public class ItemSuper {
	String englishName;
	String japaneseName;
	String language;
	int count;

	public ItemSuper(int count) {		
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}
	
	public String getItemName(String theLanguage) {
		if (theLanguage == "English") {
			return englishName;
		}
		
		else {
			return japaneseName;
		}
		
	}

}
