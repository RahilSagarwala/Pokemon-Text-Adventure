// written by: Rahil Sagarwala 
// tested by: Rahil Sagarwala 
// debugged by: Rahil Sagarwala 

package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mainGame.*;
import java.awt.*;
import javax.swing.*;
import Trainer.Player;
import Trainer.Rival;
import locations.PalletTownYourHouse;
import Trainer.*;

public class ChooseStarter extends JPanel {
	
	CardLayout cl;
	JPanel cards;
	Font textAreaFont;
	String screen, language, location;
	Boolean stopTimer, professorOakVisited, labOutsideButtonEnable;
	Player player;
	int textSpeed;
	Rival rival;
	JButton menuButton;
	JTextArea textArea;
	TrainerSuper trainer = new TrainerSuper();
	String color;

   
	public ChooseStarter(final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, Rival rival, Boolean stopTimer, String location2, Boolean professorOakVisited,
			Boolean labOutsideEnable, String color) {
		
		 //Attributes passed on from screen to screen, couple of them not needed anymore, player 2 has its name set in case 4
		 this.cl = layout;
	     this.cards = cards;
	     this.textAreaFont = font;
	     this.screen = screen;
	     this.language = language;
	     this.textSpeed = textSpeed;
	     this.player = player;
	     this.rival = rival;
	     this.stopTimer = stopTimer;
	     this.location = location2;
	     this.professorOakVisited = professorOakVisited;
	     this.labOutsideButtonEnable = labOutsideEnable;
	     this.color = color;
	     
	     
	     //Extension of JFrame, set layout and attributes for layout
//	     if (color == "black") {
//	         setBackground(Color.black); 
//	 	    }
//	 	    
//	 	    if (color == "cyan") {
//	 	        setBackground(Color.cyan); 
//	 		    }
	     
	     setBackground(Color.black); 
		 setLayout(new GridBagLayout());
		 GridBagConstraints gb = new GridBagConstraints();
		 textArea = new JTextArea("Choose a Pokémon");		 
		 textArea.setForeground(Color.cyan);
		 textArea.setBackground(Color.black);
		 textArea.setFont(font);
	
		 //Create Options Button first before other buttons in order to access size and text
		 JButton optionsButton = new JButton();
		 optionsButton.setBackground(Color.DARK_GRAY);
		 optionsButton.setForeground(Color.cyan);
		 optionsButton.setFont(font);
	 
	         
		 //Start timer with stopTimer value set to false. Only true when going into options from this screen to stop any overlay issues

		 JButton returnButton = new JButton("Return");
	     returnButton.setBackground(Color.DARK_GRAY);
		 returnButton.setForeground(Color.cyan);
		 returnButton.setFont(font);
		 returnButton.setPreferredSize(new Dimension(200,100));
		 
		 optionsButton = new JButton("Options");
	     optionsButton.setBackground(Color.DARK_GRAY);
		 optionsButton.setForeground(Color.cyan);
		 optionsButton.setFont(font);
		 optionsButton.setPreferredSize(new Dimension(200,100));
		 
		 JButton charmanderButton = new JButton("Charmander");
		 charmanderButton.setPreferredSize(new Dimension(225,75));
		 charmanderButton.setBackground(Color.DARK_GRAY);
		 charmanderButton.setForeground(Color.red);
		 charmanderButton.setFont(font);
		 
		 JButton squirtleButton = new JButton("Squirtle");
		 squirtleButton.setPreferredSize(new Dimension(200,75));
		 squirtleButton.setBackground(Color.DARK_GRAY);
		 squirtleButton.setForeground(Color.blue);
		 squirtleButton.setFont(font);
		 
		 JButton bulbasaurButton = new JButton("Bulbasaur");
		 bulbasaurButton.setPreferredSize(new Dimension(200,75));
		 bulbasaurButton.setBackground(Color.DARK_GRAY);
		 bulbasaurButton.setForeground(Color.green);
		 bulbasaurButton.setFont(font);
		 
		 JPanel nameOptionsPanel = new JPanel();
		 nameOptionsPanel.setLayout(new GridLayout(1,3));
		 nameOptionsPanel.add(charmanderButton);
		 nameOptionsPanel.add(squirtleButton);
		 nameOptionsPanel.add(bulbasaurButton);
		 
		 //Elements not used dynamically have their text changed based off of language
		 if (language == "Japanese") {
			 returnButton.setText("とじる");
			 charmanderButton.setText("ヒトカゲ");
			 squirtleButton.setText("ゼニガメ");
			 bulbasaurButton.setText("フシギダゼニガメネ");
			 optionsButton.setText("せっていを かえる");
			 textArea.setText("ポケモンをえらぶ");
			 
		 }	 


		 gb.gridx=0;
	     gb.gridy=0;
	     gb.insets = new Insets(0,-400,0,0);
		 add(returnButton, gb);
		 gb.gridx=0;
	     gb.gridy=0;
	     gb.insets = new Insets(0,400,0,0);
		 add(optionsButton, gb);
		 gb.gridx=0;
	     gb.gridy=2;
	     gb.weighty=1;
	     gb.insets = new Insets(50,0,0,0);
		 add(textArea, gb);
	     gb.gridx=0;
	     gb.gridy=3;
	     gb.weightx = 1;
	     gb.weighty = 1;
	     gb.insets = new Insets(-100,0,0,0);
	     add(nameOptionsPanel, gb);
	     
	 	 
	     
	     //Options Button recreates Options object and shows Options screen with all values already included in StartScreen class (passed on)
	     returnButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	PalletTownLab palletTownLab = new PalletTownLab(cl, cards, textAreaFont, "9", language, textSpeed,
	            			player, rival, stopTimer, "pallettownlab", professorOakVisited, labOutsideButtonEnable, color);
	            	cards.add(palletTownLab, "pallettownlab");
	                layout.show(cards, "pallettownlab"); 
	           
					
	                
	            }
	        });
	  

		 charmanderButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	ChooseStarterConfirmation chooseStarterConfirmation = new ChooseStarterConfirmation(layout, cards, 
	            			textAreaFont, screen, language, textSpeed, 
	            			player, rival, stopTimer, "choosestartervonfirmation", professorOakVisited, labOutsideButtonEnable,
	            			"charmander", color);
	            	cards.add(chooseStarterConfirmation, "choosestarterconfirmation");
	            	  layout.show(cards, "choosestarterconfirmation");
	                
	            }
	        });
		 
		 squirtleButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	ChooseStarterConfirmation chooseStarterConfirmation = new ChooseStarterConfirmation(layout, cards, 
	            			textAreaFont, screen, language, textSpeed, 
	            			player, rival, stopTimer, "choosestartervonfirmation", professorOakVisited, labOutsideButtonEnable,
	            			"squirtle", color);
	            	cards.add(chooseStarterConfirmation, "choosestarterconfirmation");
	            	  layout.show(cards, "choosestarterconfirmation");
	                
	            }
	        });
		 
		 bulbasaurButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	ChooseStarterConfirmation chooseStarterConfirmation = new ChooseStarterConfirmation(layout, cards, 
	            			textAreaFont, screen, language, textSpeed, 
	            			player, rival, stopTimer, "choosestartervonfirmation", professorOakVisited, labOutsideButtonEnable,
	            			"bulbasaur", color);
	            	cards.add(chooseStarterConfirmation, "choosestarterconfirmation");
	            	  layout.show(cards, "choosestarterconfirmation");
	                
	            }
	        });
		 
		 optionsButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	  
	    	     JTextArea blankTextArea = new JTextArea();
	            	
	            	Options options = new Options(cl,cards, "choosestarter", blankTextArea, location, false, player, false, language, textSpeed, "",
	            			rival, font, false, false, 65f, 0,0, true, professorOakVisited, 
	            			labOutsideButtonEnable, trainer, 0, color, "");
	            	cards.add(options, "options");
	                layout.show(cards, "options");  
	            	
	            	
	            }
	        });
	
		
	}
	
	
	}
	
	
