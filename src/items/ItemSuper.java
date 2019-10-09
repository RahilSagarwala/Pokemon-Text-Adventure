package items;

public class ItemSuper {
	String englishName;
	String japaneseName;
	String language;

	public ItemSuper() {		
		
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
