// written by: Rahil Sagarwala 
// tested by: Rahil Sagarwala 
// debugged by: Rahil Sagarwala 

package items;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JPanel;

import Trainer.Player;
import Trainer.Rival;
import locations.Outside;
import locations.MapScreen;
import Trainer.*;

public class Map extends ItemSuper {
	CardLayout cl;
	JPanel cards;
	MapScreen mapScreen;
	Boolean professorOakVisited;
	Boolean labOutsideButtonEnable;
	TrainerSuper trainer;


	public Map(int count) {
		super(count);
		englishName = "Map";
		japaneseName = "ちず";
		
	}
	
	public void showMap(CardLayout cl, JPanel cards, Font font, String screen, String language, int textSpeed, Player player, Rival rival, Boolean stopTimer, String location, Boolean professorOakVisited,
			Boolean labOutsideButtonEnable, TrainerSuper trainer, int battleScreenText, String color, String previousLocation) {
		mapScreen = new MapScreen(cl, cards, 
    			font, screen, language, textSpeed, 
    			player, rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable, trainer, 
    			battleScreenText, color, previousLocation);
    	cards.add(mapScreen, "mapscreen");
    	  cl.show(cards, "mapscreen"); 
	}
	
	

}
