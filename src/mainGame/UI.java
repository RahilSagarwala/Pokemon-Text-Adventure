package mainGame;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
import locations.ChooseStarter;
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
    Boolean stopTimer = false, professorOakVisited = false, labOutsideButtonEnable = true;
    MainGame mg;
    Options options;
    Credits credits;
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
    Float titleSize = 60f;
    Dialogue dialogue;
    Outside outside;
    MenuScreen menu;
    ItemSuper itemArray[];
    ArrayList<ItemSuper> itemArrayList = new ArrayList<ItemSuper>(100);
    ArrayList<PokemonSuper> partyPokemonArrayList = new ArrayList<PokemonSuper>(6); 
	Player player = new Player();
	Rival rival = new Rival();
	MapScreen mapScreen;
	TrainerSuper trainer;
	int battleScreenText = 0;
	String color = "black";
	
	//On instead of off for Music on as default
	String music = "on";

	
	 public static synchronized void playSound(Clip c) {
	  	  new Thread(new Runnable() {
	  	    public void run() {
	  	      try {
	  	    	Clip clip = c;
	  	        clip = AudioSystem.getClip();
	  	        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
	  	          this.getClass().getClassLoader().getResource("PTAmusic.wav"));
	  	        clip.open(inputStream);
	  	        clip.start(); 
	  	      } catch (Exception e) {
	  	        System.err.println(e.getMessage());
	  	      }
	  	    }
	  	  }).start();

	  	}
	 
	    


    public void componentHidden(ComponentEvent e) {

    }

    public void componentMoved(ComponentEvent e) {

    }

    public void componentResized(ComponentEvent e) {
    		
    	
//            int width = window.getWidth();
//            font = new Font("SANS_SERIF", Font.BOLD, width/ 30);
//            titleSize = (float) (width/20);
            
       
//            options = new Options(cl, cards, position, startScreenTextArea, "1", 
//        			false, player, true, "English", textSpeed, fullText2, rival, 
//        			font, stopTimer, false, titleSize, buttonWidth, buttonHeight, false);
//            cards.add(options, "options");   
            
      
        	   try {
				Clip clip = null;
				//On instead of off for Music on as default
				mg = new MainGame(cl,cards, font,language, textSpeed, stopTimer, titleSize, 
						   buttonWidth, buttonHeight, player, rival, professorOakVisited, labOutsideButtonEnable, color,
						   clip, "off", "yes");
			} catch (LineUnavailableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedAudioFileException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
    
	public UI() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
		
	
		Clip clip = AudioSystem.getClip();
	    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		          this.getClass().getClassLoader().getResource("PTAmusic.wav"));
	    clip.open(inputStream);
	    if (music == "on") {  
	        
	        clip.start();
	    }
	    if(music == "off") {
	  	        clip.stop();
	  	        
	    }
		
		
		cards = new JPanel();
	
		
		
    	cl = new CardLayout();
   	   window = new JFrame("Pokémon Text Adventure (ポケットモンスターテキストアドベンチャー)");
	   
   	   
   	   //Random ID for player at beginning of game
    	player.generateId();
   
   	   
    	try {
			mg = new MainGame(cl,cards, font,language, textSpeed, stopTimer, titleSize, buttonWidth, 
					buttonHeight, player, rival, professorOakVisited, labOutsideButtonEnable, color, clip, "off", "yes");
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	
    	options = new Options(cl, cards, position, startScreenTextArea, "1", 
    			false, player, true, "English", textSpeed, fullText2, rival, 
    			font, stopTimer, false, titleSize, buttonWidth, buttonHeight, false, 
    			professorOakVisited, labOutsideButtonEnable, trainer, battleScreenText, color, "");
    	credits = new Credits(cl, cards, language, font, textSpeed, player, rival, stopTimer, titleSize, 
	 			buttonWidth, buttonHeight, professorOakVisited, labOutsideButtonEnable, color);
    	Logo logo = new Logo(cl, cards, language, font, textSpeed, player, rival, stopTimer, titleSize, 
	 			buttonWidth, buttonHeight, professorOakVisited, labOutsideButtonEnable, color);
    	Logo2 logo2 = new Logo2(cl, cards, language, font, textSpeed, player, rival, stopTimer, titleSize, 
	 			buttonWidth, buttonHeight, professorOakVisited, labOutsideButtonEnable, color);
    	continu = new ContinueGame(cl, cards, language, font, textSpeed, player, rival, stopTimer, titleSize, 
	 			buttonWidth, buttonHeight, professorOakVisited, labOutsideButtonEnable, color); 
     	newGame = new NewGame(cl, cards, font,language, textSpeed, stopTimer, buttonWidth, buttonHeight, player, rival, professorOakVisited, labOutsideButtonEnable, color);
    	startScreen = new StartScreen(cl,cards,font, startScreenTextArea, "1", false, player, true, 
    			"English", textSpeed, fullText2, rival, false, false, buttonWidth, buttonHeight, professorOakVisited, labOutsideButtonEnable, color);   	
    	palletTownYourHouse = new PalletTownYourHouse(cl, cards, font, 
        		"8", language, textSpeed, player, rival, stopTimer, "pallettownyourhouse", professorOakVisited, labOutsideButtonEnable, color);
    	outside = new Outside(cl, cards, font, 
        		"9", language, textSpeed, player, rival, stopTimer, "outside", professorOakVisited, labOutsideButtonEnable, color);
    	ChooseStarter chooseStarter = new ChooseStarter(cl, cards, font, 
        		"9", language, textSpeed, player, rival, stopTimer, "choosestarter", professorOakVisited, labOutsideButtonEnable, color);
    	palletTownRivalHouse = new PalletTownRivalHouse(cl, cards, font, 
        		"10", language, textSpeed, player, rival, stopTimer, "pallettownrivalhouse", professorOakVisited, labOutsideButtonEnable, color);
    	palletTownHouse3 = new PalletTownHouse3(cl, cards, font, 
        		"11", language, textSpeed, player, rival, stopTimer, "pallettownhouse3", color);
    	palletTownLab = new PalletTownLab(cl, cards, font, 
        		"12", language, textSpeed, player, rival, stopTimer, "pallettownlab", professorOakVisited, labOutsideButtonEnable, color);
    	route1 = new Route1(cl, cards, font, 
        		"13", language, textSpeed, player, rival, stopTimer, "route1", professorOakVisited, trainer, color);
//    	battle = new Battle(cl, cards, font, 
//        		"12", language, textSpeed, player, trainer, stopTimer, "pallettownlab", professorOakVisited, labOutsideButtonEnable, rival);
    	dialogue = new Dialogue(cl, cards, font, 
        		"", language, textSpeed, player, rival, stopTimer, "dialogue", false, professorOakVisited, true, 0, labOutsideButtonEnable, color); 	
    	menu = new MenuScreen(cl, cards, font, 
        		"", language, textSpeed, player, rival, stopTimer, "menu", professorOakVisited, labOutsideButtonEnable, 
        		trainer, battleScreenText, color, "");
    	mapScreen = new MapScreen(cl, cards, font, 
        		"14", language, textSpeed, player, rival, stopTimer, "mapscreen", professorOakVisited, labOutsideButtonEnable,
        		trainer, battleScreenText, color, "");
    	
    	
    
    	
    	//Example Implementation for dynamic buttons for inventory
    	
//    	Potion potion = new Potion(1);
//    	Potion potion2 = new Potion(1);
//     	Potion potion3 = new Potion(1);
//     	Potion potion4 = new Potion(1);
//    	player.addItem(potion);
//    	player.addItem(potion2);
//    	player.addItem(potion3);
//    	player.addItem(potion4);

//    	Charmander charmander = new Charmander("");
//    	player.addPokemonToParty(charmander);
    	
        cards.setLayout(cl);
        cards.add(mg, "mainscreen");
        cards.add(options, "options");
        cards.add(newGame, "newgame");
        cards.add(continu, "continue");
        cards.add(credits, "trade");
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
        cards.add(logo, "logo");
        cards.add(logo2, "logo2");
        cards.add(chooseStarter, "choosestarter");
      
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
	
	
	public static void main(String[] args) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
		new UI();
		
		
	}


}
