package mainGame;

import java.awt.*;
import javax.swing.*;
import locations.StartScreen;
import Trainer.Player;
import Trainer.Rival;
import locations.PalletTownYourHouse;
import locations.PalletTownRivalHouse;
import locations.PalletTownHouse3;
import locations.PalletTownLab;
import locations.Route1;
import locations.Battle;

public class UI {
	
	JFrame window;
	JPanel cards;
    JTextArea startScreenTextArea = new JTextArea(); 
    final static String mainScreenString = "mainscreen";
    CardLayout cl;
    Font titleFont, italicNormalFont = new Font("SANS_SERIF", Font.ITALIC, 30),
    		buttonFont = new Font("SANS_SERIF", Font.BOLD, 30), font = new Font("SANS_SERIF", Font.BOLD, 30);
    String language = "English", position = "mainscreen", fullText2="", chosenSave = "";
    int textSpeed = 50, buttonWidth = 150, buttonHeight = 75;
    Boolean stopTimer = false;
    MainGame mg;
    Options options;
    Trade trade;
    NewGame newGame;
    ContinueGame continu;
    StartScreen startScreen;
    ConfirmContinue confirmContinue;
    PalletTownYourHouse palletTownYourHouse;
    PalletTownRivalHouse palletTownRivalHouse;
    PalletTownLab palletTownLab;
    PalletTownHouse3 palletTownHouse3;
    Route1 route1;
    Battle battle;
    Rival rival;
    Player player;
    Float titleSize = 55f;
    
   
    

    
    //Creates window
    //Initializes every screen and sets as card layout
    //Called from main method below
	public UI() {
		
	
		
		
		
		cards = new JPanel();
		
		
		 
	
		
		
    	cl = new CardLayout();
   	   window = new JFrame("Pokémon Text Audio Game");
	   
    	
    	mg = new MainGame(cl,cards, font,language, textSpeed, stopTimer, titleSize, buttonWidth, buttonHeight);
    	options = new Options(cl, cards, position, startScreenTextArea, "1", 
    			false, player, true, "English", textSpeed, fullText2, rival, 
    			font, stopTimer, false, titleSize, buttonWidth, buttonHeight);
    	trade = new Trade(cl, cards);
    	continu = new ContinueGame(cl, cards);
    	player = new Player("");
     	newGame = new NewGame(cl, cards, buttonFont,language, textSpeed, stopTimer, buttonWidth, buttonHeight);
    	startScreen = new StartScreen(cl,cards,font, startScreenTextArea, "1", false, player, true, "English", textSpeed, fullText2, rival, false, false, buttonWidth, buttonHeight);   	
    	palletTownYourHouse = new PalletTownYourHouse(cl, cards, font, 
        		"8", language, textSpeed, player, rival, stopTimer, "pallettownyourhouse");
    	palletTownRivalHouse = new PalletTownRivalHouse(cl, cards, font, 
        		"9", language, textSpeed, player, rival, stopTimer, "pallettownrivalhouse");
    	palletTownHouse3 = new PalletTownHouse3(cl, cards, font, 
        		"10", language, textSpeed, player, rival, stopTimer, "pallettownhouse3s");
    	palletTownLab = new PalletTownLab(cl, cards, font, 
        		"11", language, textSpeed, player, rival, stopTimer, "pallettownlab");
    	route1 = new Route1(cl, cards, font, 
        		"12", language, textSpeed, player, rival, stopTimer, "route1");
    	battle = new Battle(cl, cards, font, 
        		"", language, textSpeed, player, rival, stopTimer, "battle");
    	
  
    	
        cards.setLayout(cl);
        cards.add(mg, "mainscreen");
        cards.add(options, "options");
        cards.add(newGame, "newgame");
        cards.add(continu, "continue");
        cards.add(trade, "trade");
        cards.add(startScreen, "startscreen"); 
        cards.add(palletTownYourHouse, "pallettownyourhouse");
        cards.add(palletTownRivalHouse, "pallettownrivalhouse");
        cards.add(palletTownLab, "pallettownlab");
        cards.add(palletTownHouse3, "pallettownhouse3");
        cards.add(route1, "route1");
      
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		cards.setSize(screenSize.width, screenSize.height);
        
	   	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setSize(1280, 680);
	    window.setVisible(true);
    	window.add(cards);
//    	window.pack();
    	cl.show(cards, "mainscreen");
      
        
	
		
		
	}
	
	public static void main(String[] args) {
		
		new UI();
		
	}


}
