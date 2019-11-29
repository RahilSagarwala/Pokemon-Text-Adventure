// written by: Rahil Sagarwala 
// tested by: Rahil Sagarwala 
// debugged by: Rahil Sagarwala 

package mainGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import locations.StartScreen;
import Trainer.Player;
import Trainer.Rival;
import locations.Battle;
import locations.ChooseStarter;
import locations.ChooseStarterConfirmation;
import locations.MenuScreen;
import Trainer.TrainerSuper;
import Trainer.*;

public class Options extends JPanel {
	
	JButton returnButton, smallFontButton, mediumFontButton, largeFontButton, onSoundtrackButton, offSoundtrackButton, 
	onTextToSpeechButton, offTextToSpeechButton, slowTextSpeedButton, fastTextSpeedButton, englishButton, japaneseButton,
	timerOffButton, blackButton, cyanButton;
	CardLayout cl;
    JPanel cards;
    JLabel optionsLabel, fontSizeLabel, soundtrackLabel, textToSpeechLabel, textSpeedLabel, languageLabel, colorLabel;
    Font buttonFont = new Font("SANS_SERIF", Font.BOLD, 30), font1;
    StartScreen startScreen;
    JTextArea startScreenTextArea = new JTextArea();
    MainGame mg;
    String language1, position, fullText2, screen;
    JTextArea textArea;
	Boolean nameOptionsBool, nameOptionsBool2, stopTimer, setVisible, isMenu, professorOakVisited, labOutsideButtonEnable;
	Player player;
	int textSpeed1, buttonWidth, buttonHeight;
	Rival rival;
	Float titleSize;
	TrainerSuper trainer;
	int battleScreenText;
	String color, previousLocation;
	
	
	
	public Options (final CardLayout layout, final JPanel cards, String position,
			JTextArea textArea, String screen, Boolean nameOptionsBool,
			Player player2, Boolean setVisible, String language, int textSpeed, String fullText,
			Rival rival2, Font font, Boolean stopTimer1, Boolean nameOptionsBool2, Float titleSize2,
			int buttonWidth2, int buttonHeight2, Boolean isMenu2, Boolean professorOakVisited, 
			Boolean labOutsideButtonEnable, TrainerSuper trainer, int battleScreenText, String color2, String previousLocation) {
		 this.cl = layout;
	     this.cards = cards;
	     this.position = position;
	     this.startScreenTextArea = textArea;
	     this.screen = screen;
	     this.nameOptionsBool = nameOptionsBool;
	     this.player = player2;
	     this.setVisible = setVisible;
	     this.language1 = language;
	     this.textSpeed1 = textSpeed;
	     this.fullText2 = fullText;
	     this.rival = rival2;
	     this.font1 = font;
	     this.stopTimer = stopTimer1;
	     this.nameOptionsBool2 = nameOptionsBool2;
	     this.titleSize = titleSize2;
	     this.buttonWidth = buttonWidth2;
	     this.buttonHeight = buttonHeight2;
	     this.isMenu = isMenu2;
	     this.professorOakVisited=professorOakVisited;
	     this.labOutsideButtonEnable=labOutsideButtonEnable;
	     this.trainer = trainer;
	     this.battleScreenText=battleScreenText;
	     this.color = color2;
	     this.previousLocation = previousLocation;
	 
	     
	     
	     //Create GUI
	     JButton returnButton = new JButton("Return");
		 returnButton.setPreferredSize(new Dimension(150,75));
//		 if (color == "black") {
//		        setBackground(Color.black); 
//			    }
//			    
//			    if (color == "cyan") {
//			        setBackground(Color.cyan); 
//				    }
		 
		 setBackground(Color.black); 
		 returnButton.setBackground(Color.DARK_GRAY);
		 returnButton.setForeground(Color.cyan);
		 returnButton.setFont(font1);
		 
		
		 JLabel optionsLabel = new JLabel("Options");
		 optionsLabel.setFont(font1);
		 optionsLabel.setForeground(Color.cyan);
		 
		 JLabel fontSizeLabel = new JLabel("Font Size: ");
		 fontSizeLabel.setFont(font1);
		 fontSizeLabel.setForeground(Color.cyan);
		 JButton smallFontButton = new JButton("Small");
		 smallFontButton.setFont(font1);
		 smallFontButton.setPreferredSize(new Dimension(400,100));
		 smallFontButton.setBackground(Color.DARK_GRAY);
		 smallFontButton.setForeground(Color.cyan);
		 JButton mediumFontButton = new JButton("Medium");
		 mediumFontButton.setFont(font1);
		 mediumFontButton.setPreferredSize(new Dimension(400,100));
		 mediumFontButton.setBackground(Color.DARK_GRAY);
		 mediumFontButton.setForeground(Color.cyan);
		 JButton largeFontButton = new JButton("Large");
		 largeFontButton.setFont(font1);
		 largeFontButton.setPreferredSize(new Dimension(400,100));
		 largeFontButton.setBackground(Color.DARK_GRAY);
		 largeFontButton.setForeground(Color.cyan);
		 
		 
		 JLabel soundtrackLabel = new JLabel("Soundtrack: ");
		 soundtrackLabel.setFont(font1);
		 soundtrackLabel.setForeground(Color.cyan);
		 JButton onSoundtrackButton = new JButton("On");
		 onSoundtrackButton.setFont(font1);
		 onSoundtrackButton.setPreferredSize(new Dimension(400,100));
		 onSoundtrackButton.setBackground(Color.DARK_GRAY);
		 onSoundtrackButton.setForeground(Color.cyan);
		 JButton offSoundtrackButton = new JButton("Off");
		 offSoundtrackButton.setFont(font1);
		 offSoundtrackButton.setPreferredSize(new Dimension(400,100));
		 offSoundtrackButton.setBackground(Color.DARK_GRAY);
		 offSoundtrackButton.setForeground(Color.cyan);
		 
		 JLabel languageLabel = new JLabel("Language: ");
		 languageLabel.setFont(font1);
		 languageLabel.setForeground(Color.cyan);
		 JButton englishButton = new JButton("English");
		 englishButton.setFont(font1);
		 englishButton.setPreferredSize(new Dimension(400,100));
		 englishButton.setBackground(Color.DARK_GRAY);
		 englishButton.setForeground(Color.cyan);
		 JButton japaneseButton = new JButton("Japanese");
		 japaneseButton.setFont(font1);
		 japaneseButton.setPreferredSize(new Dimension(400,100));
		 japaneseButton.setBackground(Color.DARK_GRAY);
		 japaneseButton.setForeground(Color.cyan);
		 
		 colorLabel = new JLabel("Background Color:      ");
		 colorLabel.setFont(font1);
		 colorLabel.setForeground(Color.cyan);
		 blackButton = new JButton("Black");
		 blackButton.setFont(font1);
		 blackButton.setPreferredSize(new Dimension(400,100));
		 blackButton.setBackground(Color.DARK_GRAY);
		 blackButton.setForeground(Color.cyan);
		 cyanButton = new JButton("Cyan");
		 cyanButton.setFont(font1);
		 cyanButton.setPreferredSize(new Dimension(400,100));
		 cyanButton.setBackground(Color.DARK_GRAY);
		 cyanButton.setForeground(Color.cyan);
		 
		 JLabel textToSpeechLabel = new JLabel("Text To Speech:    ");
		 textToSpeechLabel.setFont(font1);
		 textToSpeechLabel.setForeground(Color.cyan);
		 JButton onTextToSpeechButton = new JButton("On");
		 onTextToSpeechButton.setFont(font1);
		 onTextToSpeechButton.setPreferredSize(new Dimension(400,100));
		 onTextToSpeechButton.setBackground(Color.DARK_GRAY);
		 onTextToSpeechButton.setForeground(Color.cyan);
		 JButton offTextToSpeechButton = new JButton("Off");
		 offTextToSpeechButton.setFont(font1);
		 offTextToSpeechButton.setPreferredSize(new Dimension(400,100));
		 offTextToSpeechButton.setBackground(Color.DARK_GRAY);
		 offTextToSpeechButton.setForeground(Color.cyan);
		 
		 
		 JLabel textSpeedLabel = new JLabel("Text Speed: ");
		 textSpeedLabel.setFont(font1);
		 textSpeedLabel.setForeground(Color.cyan);

		 JButton slowTextSpeedButton = new JButton("Slow");
		 slowTextSpeedButton.setFont(font1);
		 slowTextSpeedButton.setPreferredSize(new Dimension(400,100));
		 slowTextSpeedButton.setBackground(Color.DARK_GRAY);
		 slowTextSpeedButton.setForeground(Color.cyan);
		 
		 JButton fastTextSpeedButton = new JButton("Fast");
		 fastTextSpeedButton.setFont(font1);
		 fastTextSpeedButton.setPreferredSize(new Dimension(400,100));
		 fastTextSpeedButton.setBackground(Color.DARK_GRAY);
		 fastTextSpeedButton.setForeground(Color.cyan);
		 
		 JButton timerOffButton = new JButton("OFF");
		 timerOffButton.setFont(font1);
		 timerOffButton.setPreferredSize(new Dimension(400,100));
		 timerOffButton.setBackground(Color.DARK_GRAY);
		 timerOffButton.setForeground(Color.cyan);
		 
		
		 
		 if (language == "Japanese") {
			 optionsLabel.setText("せっていを かえる ");
			 fontSizeLabel.setText("フォントサイズ :     ");
			 soundtrackLabel.setText("サウンドトラック");
			 textToSpeechLabel.setText("テキストからスピーチ:     ");   
			 textSpeedLabel.setText("テキスト そくど :     ");
			 languageLabel.setText("げんご: ");
			 returnButton.setText("とじる");
			 smallFontButton.setText("ちいさい");
			 mediumFontButton.setText("なか");
			 largeFontButton.setText("おおきい");
			 onSoundtrackButton.setText("つける");
			 offSoundtrackButton.setText("けす");
			 onTextToSpeechButton.setText("つける");
			 offTextToSpeechButton.setText("けす");
			 slowTextSpeedButton.setText("ゆっくり");
			 fastTextSpeedButton.setText("はやい");
			 englishButton.setText("えいご");
			 japaneseButton.setText("にほんご");
			 timerOffButton.setText("けす");
			 colorLabel.setText("はいけいいろ:    ");
			 blackButton.setText("くろい");
			 cyanButton.setText("シアン");
		 }
		 
		 
		 if (language == "English"  || language == "Japanese"){
		 //Add to GridBagLayout with coordinates
		 setLayout(new GridBagLayout());
		 GridBagConstraints gb = new GridBagConstraints();
		 //Column 1
		 gb.anchor=GridBagConstraints.FIRST_LINE_START;
		 gb.gridx=0;
	     gb.gridy=2;
		 add(fontSizeLabel, gb);
		 gb.gridx=0;
	     gb.gridy=3;
		 add(colorLabel, gb);
//		 gb.gridx=0;
//	     gb.gridy=3;
//		 add(soundtrackLabel,gb);
//		 gb.gridx=0;
//	     gb.gridy=4;
//		 add(textToSpeechLabel,gb);
		 gb.gridx=0;
	     gb.gridy=5;
		 add(textSpeedLabel,gb);
		 gb.gridx=0;
	     gb.gridy=6;
		 add(languageLabel,gb);
		 

	     
	     //Column 2
		 if (language == "English") {
		 gb.gridx=1;
	     gb.gridy=0;
	     gb.weighty = 1;
		 add(returnButton, gb);
		 }
		 
		 if (language == "Japanese") {
			 gb.insets = new Insets(0,50,0,0);
			 gb.gridx=1;
		     gb.gridy=0;
		     gb.weighty = 1;
			 add(returnButton, gb);
			 gb.insets = new Insets(0,0,0,0);
		 }
		 gb.gridx=1;
	     gb.gridy=1;
		 add(optionsLabel, gb);
		 gb.gridx=1;
	     gb.gridy=2;
		 add(smallFontButton,gb);
		 gb.gridx=1;
	     gb.gridy=3;
		 add(blackButton,gb);
//		 gb.gridx=1;
//	     gb.gridy=3;
//		 add(onSoundtrackButton,gb);
//		 gb.gridx=1;
//	     gb.gridy=4;
//		 add(onTextToSpeechButton,gb);
		 gb.gridx=1;
	     gb.gridy=5;
		 add(slowTextSpeedButton,gb);
		 gb.gridx=1;
	     gb.gridy=6;
		 add(englishButton,gb);
		 
		 if (language == "English") {
		 gb.insets = new Insets(0,30,0,0);
		 }
		 
		 if (language == "Japanese") {
			 gb.insets = new Insets(0,-20,0,0);
			 }
		 
		 
		 //Column 3
		 gb.gridx=2;
	     gb.gridy=2;
		 add(mediumFontButton,gb);
		 gb.gridx=2;
	     gb.gridy=3;
		 add(cyanButton,gb);
//		 gb.gridx=2;
//	     gb.gridy=3;
//		 add(offSoundtrackButton,gb);
//		 gb.gridx=2;
//	     gb.gridy=4;
//		 add(offTextToSpeechButton,gb);
		 gb.gridx=2;
	     gb.gridy=5;
		 add(fastTextSpeedButton,gb);
		 gb.gridx=2;
	     gb.gridy=6;
		 add(japaneseButton,gb);
	
		 
		 
		 //Column 4
		 gb.gridx=3;
	     gb.gridy=2;
	     gb.insets = new Insets(0,15,0,0);
		 add(largeFontButton,gb);
		 
		 if (language == "English") {
		 gb.gridx=3;
	     gb.gridy=5;
	     gb.insets = new Insets(0,-10,0,0);
		 add(timerOffButton,gb);
		 }
		 
		 if (language == "Japanese") {
			 gb.gridx=3;
		     gb.gridy=5;
		     gb.insets = new Insets(0,25,0,0);
			 add(timerOffButton,gb);
			 }
		 
		 }
	

		 //Each screen has a position, thus Options knows where to return to
		 returnButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	switch(position) {
	            	case "startscreen":
	            		 startScreen = new StartScreen(cl, cards, font1, startScreenTextArea,screen, nameOptionsBool,
	            				 player,setVisible,language1, textSpeed1, fullText2, rival, nameOptionsBool2,
	            				 stopTimer, buttonWidth, buttonHeight, professorOakVisited, labOutsideButtonEnable, color);	          
		            	    cards.add(startScreen, "startscreen");
		            	    layout.show(cards, "startscreen");
		            	    break;
	            	
	            	
	            	case "mainscreen":

	            		 try {
							Clip clip = null;
							mg = new MainGame(cl, cards, font1, language1, textSpeed1, stopTimer, titleSize, buttonWidth, 
							    		buttonHeight, player, rival, professorOakVisited, labOutsideButtonEnable, color, clip, "on", "no");
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
	            		  layout.show(cards, position);	  
	            		  break;
	            		  
	            	case "menu":	            		
	            		
	            		MenuScreen menu = new MenuScreen(cl, cards, font1, screen, language1, textSpeed1, player,
	            				rival, stopTimer, screen, professorOakVisited, labOutsideButtonEnable, trainer,
	            				battleScreenText, color, "");
	            		cards.add(menu, "menu");
	            	    layout.show(cards, "menu");
	            	    break;
	            	    
	            	case "choosestarter":	            		
	            		
	            		ChooseStarter chooseStarter = new ChooseStarter(cl, cards, font1, screen, language1, textSpeed1, player,
	            				rival, stopTimer, screen, professorOakVisited, labOutsideButtonEnable, color);
	            		cards.add(chooseStarter, "choosestarter");
	            	    layout.show(cards, "choosestarter");
	            	    break;
	            	    
	            	case "battle":	            		
	            		Battle battle = new Battle(cl, cards, font1, 
		                		"12", language, textSpeed, player, rival, stopTimer, "battle", professorOakVisited, 
		                		labOutsideButtonEnable, rival, battleScreenText, color, false, "", "", "", previousLocation);
		            	cards.add(battle, "battle");
		            	
		                layout.show(cards, "battle");
	            	    break;
	            		           	
	            }
	            	
	            		            
	        	  
	                
	            				}	
	            			}
				 		);
		 
		 //All subsequent Action Listeners must update any relevant screen with new variables
		 smallFontButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            		font1 = new Font("SANS_SERIF", Font.BOLD, 20);
	            		titleSize = 40f;
	            		buttonWidth = 100;
	            		buttonHeight = 50;
          	
	            	    
	            	   Options options = new Options(cl, cards, position, startScreenTextArea, screen, nameOptionsBool,
	            	    		player, setVisible, language1, textSpeed1, fullText2, rival, font1, stopTimer,
	            	    		nameOptionsBool2, titleSize, buttonWidth, buttonHeight, false, 
	            	    		professorOakVisited, labOutsideButtonEnable, trainer, battleScreenText, color, previousLocation);

	            	    cards.add(options, "options");
	            	    layout.show(cards, "options");
	            	    
	            	  
		               
	            				}	
	            			}
				 		);
		 
		 mediumFontButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	font1 = new Font("SANS_SERIF", Font.BOLD, 30);
	            	titleSize = 55f;
	            	buttonWidth = 150;
            		buttonHeight = 75;
	            		          
	            	 Options options = new Options(cl, cards, position, startScreenTextArea, screen, nameOptionsBool,
	            	    		player, setVisible, language1, textSpeed1, fullText2, rival, font1, stopTimer,
	            	    		nameOptionsBool2, titleSize, buttonWidth, buttonHeight, false, professorOakVisited, 
	            	    		labOutsideButtonEnable, trainer, battleScreenText, color, previousLocation);

	            	    cards.add(options, "options");
	            	    layout.show(cards, "options");
	                
	                
	            				}	
	            			}
				 		);
		
		 
		 
		 largeFontButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	font1 = new Font("SANS_SERIF", Font.BOLD, 50);
	            	titleSize = 65f;
	            	buttonWidth = 200;
            		buttonHeight = 100;
	            	
	            	    
	            	    Options options = new Options(cl, cards, position, startScreenTextArea, screen, nameOptionsBool,
	            	    		player, setVisible, language1, textSpeed1, fullText2, rival, font1, stopTimer,
	            	    		nameOptionsBool2, titleSize, buttonWidth, buttonHeight, false, professorOakVisited, 
	            	    		labOutsideButtonEnable, trainer, battleScreenText, color, previousLocation);

	            	    cards.add(options, "options");
	            	    layout.show(cards, "options");
	                
	            				}	
	            			}
				 		);
		 
		 englishButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 language1 = "English";
	            	 
	            	 switch (player.getName()) {
	            	 case "ブルー": player.setName("BLUE");
	            		 break;
	            	 case "レッド": player.setName("RED");
	            		 break;
	            	 case "グリーン": player.setName("GREEN");
	            		 break;
	            	 case "イエロー": player.setName("YELLOW");
	            		 break;
	            	 default: player.setName(player.getName());
	            		 break;
	            	 }
	            	 
	            	 switch (rival.getName()) {
	            	 case "ブルー": rival.setName("BLUE");
	            		 break;
	            	 case "レッド": rival.setName("RED");
	            		 break;
	            	 case "グリーン": rival.setName("GREEN");
	            		 break;
	            	 case "イエロー": rival.setName("YELLOW");
	            		 break;
	            	 default: rival.setName(rival.getName());
	            		 break;
	            	 }

	            	 
	            	 Options options = new Options(cl, cards, position, startScreenTextArea, screen, nameOptionsBool,
	            	    		player, setVisible, language1, textSpeed1, fullText2, rival, font1, stopTimer,
	            	    		nameOptionsBool2, titleSize, buttonWidth, buttonHeight, false, professorOakVisited, 
	            	    		labOutsideButtonEnable, trainer, battleScreenText, color, previousLocation);

	            	    cards.add(options, "options");
	            	    layout.show(cards, "options");
	            
	            	   
	                
	            				}	
	            			}
				 		);
		 
		 japaneseButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 language1 = "Japanese";
	            	 
	            	 switch (player.getName()) {
	            	 case "BLUE": player.setName("ブルー");
	            		 break;
	            	 case "RED": player.setName("レッド");
	            		 break;
	            	 case "GREEN": player.setName("グリーン");
	            		 break;
	            	 case "YELLOW": player.setName("イエロー");
	            		 break;
	            	 default: player.setName(player.getName());
	            		 break;
	            	 }
            	 

	            	 switch (rival.getName()) {
	            	 case "BLUE": rival.setName("ブルー");
	            		 break;
	            	 case "RED": rival.setName("レッド");
	            		 break;
	            	 case "GREEN": rival.setName("グリーン");
	            		 break;
	            	 case "YELLOW": rival.setName("イエロー");
	            		 break;
	            	 case "": rival.setName("");
            		 break;
	            	 default: 
	            		 break;
	            	 }
	            	 	    	     		     	
	            	 
	            	 Options options = new Options(cl, cards, position, startScreenTextArea, screen, nameOptionsBool,
	            	    		player, setVisible, language1, textSpeed1, fullText2, rival, font1, stopTimer,
	            	    		nameOptionsBool2, titleSize, buttonWidth, buttonHeight, false, 
	            	    		professorOakVisited, labOutsideButtonEnable, trainer, battleScreenText, color, previousLocation);

	            	    cards.add(options, "options");
	            	    layout.show(cards, "options");
	            	
	            	   
	                
	            				}	
	            			}
				 		);
		 
		 onSoundtrackButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	            				}	
	            			}
				 		);
		 
		 offSoundtrackButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	            				}	
	            			}
				 		);
		 
		 onTextToSpeechButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	            				}	
	            			}
				 		);
		 
		 offTextToSpeechButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	              
	            				}	
	            			}
				 		);
		 
		 blackButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	              color = "black";
	              Options options = new Options(cl, cards, position, startScreenTextArea, screen, nameOptionsBool,
          	    		player, setVisible, language1, textSpeed1, fullText2, rival, font1, stopTimer,
          	    		nameOptionsBool2, titleSize, buttonWidth, buttonHeight, false, professorOakVisited, 
          	    		labOutsideButtonEnable, trainer, battleScreenText, color, previousLocation);

          	    cards.add(options, "options");
          	    layout.show(cards, "options");
	            				}	
	            			}
				 		);
		 
		 cyanButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	              color = "cyan";
	              Options options = new Options(cl, cards, position, startScreenTextArea, screen, nameOptionsBool,
          	    		player, setVisible, language1, textSpeed1, fullText2, rival, font1, stopTimer,
          	    		nameOptionsBool2, titleSize, buttonWidth, buttonHeight, false, professorOakVisited, 
          	    		labOutsideButtonEnable, trainer, battleScreenText, color, previousLocation);

          	    cards.add(options, "options");
          	    layout.show(cards, "options");
	            				}	
	            			}
				 		);
		 
		 //The higher the number, the slower the speed
		 //Initialized in UI Class as default
		 slowTextSpeedButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            		textSpeed1 = 100;
	    
	            		stopTimer = false;
	                  	
		            	 try {
							Clip clip = null;
							mg = new MainGame(cl, cards, font, language, textSpeed1, stopTimer, titleSize, 
									 buttonWidth, buttonHeight, player, rival, professorOakVisited, labOutsideButtonEnable,
									 color, clip, "on", "no");
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
		            	 startScreen = new StartScreen(cl, cards, font1, startScreenTextArea,screen, 
		            			 nameOptionsBool, player,setVisible,language1, textSpeed1,
		            			 fullText2, rival, false, true, buttonWidth, buttonHeight, professorOakVisited,
		            			 labOutsideButtonEnable, color);
		            	 cards.add(mg, "mainscreen");
		            	 cards.add(startScreen, "startscreen");
		            	
	            				}	
	            			}
				 		);
		 
		 fastTextSpeedButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	textSpeed1 = 50;
	            	stopTimer = false;
	              	
	            	 try {
						Clip clip = null;
						mg = new MainGame(cl, cards, font, language, textSpeed1, stopTimer, titleSize, 
								 buttonWidth, buttonHeight, player, rival, professorOakVisited, labOutsideButtonEnable, color,
								 clip, "on", "no");
					} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            	 startScreen = new StartScreen(cl, cards, font1, startScreenTextArea,screen,
	            			 nameOptionsBool, player,setVisible,language1, textSpeed1, fullText2,
	            			 rival, false, true, buttonWidth, buttonHeight, professorOakVisited, labOutsideButtonEnable, color);
	            	 cards.add(mg, "mainscreen");
	            	 cards.add(startScreen, "startscreen");
	            	
	            				}	
	            			}
				 		);
		 timerOffButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 stopTimer = true;

	            	 try {
						Clip clip = null;
						//On instead of off for Music on as default
						mg = new MainGame(cl, cards, font, language, textSpeed1, stopTimer, titleSize, buttonWidth, buttonHeight
								 , player, rival, professorOakVisited, labOutsideButtonEnable, color, clip, "off", "no");
					} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            	 startScreen = new StartScreen(cl, cards, font1, startScreenTextArea,screen, 
	            			 nameOptionsBool, player,setVisible,language1, textSpeed1, 
	            			 fullText2, rival, false, true, buttonWidth, buttonHeight, professorOakVisited, 
	            			 labOutsideButtonEnable, color);
	            	 cards.add(mg, "mainscreen");
	            	 cards.add(startScreen, "startscreen");
	            				}	
	            			}
				 		);
		 
	}
	

}
