package mainGame;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
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
import locations.Dialogue;
import locations.Outside;
import locations.MenuScreen;
import pokemon.*;
import Trainer.*;
import items.*;
import java.io.*; 
import java.util.*; 
import locations.MapScreen;

public class UI implements ComponentListener {
	
	JFrame window;
	JPanel cards;
    JTextArea startScreenTextArea = new JTextArea(); 
    final static String mainScreenString = "mainscreen";
    CardLayout cl;
    Font font = new Font("SANS_SERIF", Font.BOLD, 30);
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
    Float titleSize = 55f;
    Dialogue dialogue;
    Outside outside;
    MenuScreen menu;
    ItemSuper itemArray[];
    ArrayList<ItemSuper> itemArrayList = new ArrayList<ItemSuper>(100);
    
	Player player = new Player("", itemArrayList);
	Rival rival = new Rival("", itemArrayList);
	MapScreen mapScreen;

    
   
    

    
    
    public void componentHidden(ComponentEvent e) {

    }

    public void componentMoved(ComponentEvent e) {

    }

    public void componentResized(ComponentEvent e) {
    		
    	
            int width = window.getWidth();
            font = new Font("SANS_SERIF", Font.BOLD, width/ 30);
            titleSize = (float) (width/20);
            
       
//            options = new Options(cl, cards, position, startScreenTextArea, "1", 
//        			false, player, true, "English", textSpeed, fullText2, rival, 
//        			font, stopTimer, false, titleSize, buttonWidth, buttonHeight, false);
//            cards.add(options, "options");   
            
      
        	   mg = new MainGame(cl,cards, font,language, textSpeed, stopTimer, titleSize, 
        			   buttonWidth, buttonHeight, player, rival);
               cards.add(mg, "mainscreen");
//          
//        	   cl.show(cards, "mainscreen");
//               
//           
//   
//            
//            window.getContentPane().revalidate();
            

    }

    public void componentShown(ComponentEvent e) {

    }
    
	public UI() {
		
	
		
		
		
		cards = new JPanel();
		
	
		
		
    	cl = new CardLayout();
   	   window = new JFrame("Pokémon Text Audio Game");
	   
    	
   
   	   
    	mg = new MainGame(cl,cards, font,language, textSpeed, stopTimer, titleSize, buttonWidth, buttonHeight, player, rival);
    	options = new Options(cl, cards, position, startScreenTextArea, "1", 
    			false, player, true, "English", textSpeed, fullText2, rival, 
    			font, stopTimer, false, titleSize, buttonWidth, buttonHeight, false);
    	trade = new Trade(cl, cards, language, font, textSpeed, player, rival, stopTimer, titleSize, 
	 			buttonWidth, buttonHeight);
    	continu = new ContinueGame(cl, cards, language, font, textSpeed, player, rival, stopTimer, titleSize, 
	 			buttonWidth, buttonHeight); 
     	newGame = new NewGame(cl, cards, font,language, textSpeed, stopTimer, buttonWidth, buttonHeight, player, rival);
    	startScreen = new StartScreen(cl,cards,font, startScreenTextArea, "1", false, player, true, 
    			"English", textSpeed, fullText2, rival, false, false, buttonWidth, buttonHeight);   	
    	palletTownYourHouse = new PalletTownYourHouse(cl, cards, font, 
        		"8", language, textSpeed, player, rival, stopTimer, "pallettownyourhouse");
    	outside = new Outside(cl, cards, font, 
        		"9", language, textSpeed, player, rival, stopTimer, "outside");
    	palletTownRivalHouse = new PalletTownRivalHouse(cl, cards, font, 
        		"10", language, textSpeed, player, rival, stopTimer, "pallettownrivalhouse");
    	palletTownHouse3 = new PalletTownHouse3(cl, cards, font, 
        		"11", language, textSpeed, player, rival, stopTimer, "pallettownhouse3");
    	palletTownLab = new PalletTownLab(cl, cards, font, 
        		"12", language, textSpeed, player, rival, stopTimer, "pallettownlab");
    	route1 = new Route1(cl, cards, font, 
        		"13", language, textSpeed, player, rival, stopTimer, "route1");
    	battle = new Battle(cl, cards, font, 
        		"", language, textSpeed, player, rival, stopTimer, "battle");
    	dialogue = new Dialogue(cl, cards, font, 
        		"", language, textSpeed, player, rival, stopTimer, "dialogue", false); 	
    	menu = new MenuScreen(cl, cards, font, 
        		"", language, textSpeed, player, rival, stopTimer, "menu");
    	mapScreen = new MapScreen(cl, cards, font, 
        		"14", language, textSpeed, player, rival, stopTimer, "mapscreen");
    	
  
    	
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
        cards.add(dialogue, "dialogue");
        cards.add(outside, "outside");
        cards.add(menu, "menu");
        cards.add(mapScreen, "mapscreen");
      
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		cards.setSize(screenSize.width, screenSize.height);
        
	   	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setSize(1280, 680);
	   
	    window.setVisible(true);
    	window.add(cards);
//    	window.pack();
    	 window.addComponentListener(this);
    	cl.show(cards, "mainscreen");
      
        
	
		
		
	}
	
	
	public static void main(String[] args) {
		
		new UI();
		
	}


}
