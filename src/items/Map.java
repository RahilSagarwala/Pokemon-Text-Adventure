package items;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JPanel;

import Trainer.Player;
import Trainer.Rival;
import locations.Outside;
import locations.MapScreen;

public class Map extends ItemSuper {
	CardLayout cl;
	JPanel cards;
	MapScreen mapScreen;
	Boolean professorOakVisited;
	Boolean labOutsideButtonEnable;


	public Map(int count) {
		super(count);
		englishName = "Map";
		japaneseName = "ちず";
		
	}
	
	public void showMap(CardLayout cl, JPanel cards, Font font, String screen, String language, int textSpeed, Player player, Rival rival, Boolean stopTimer, String location, Boolean professorOakVisited,
			Boolean labOutsideButtonEnable) {
		mapScreen = new MapScreen(cl, cards, 
    			font, screen, language, textSpeed, 
    			player, rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable);
    	cards.add(mapScreen, "mapscreen");
    	  cl.show(cards, "mapscreen"); 
	}
	
	

}
