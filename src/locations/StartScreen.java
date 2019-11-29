package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mainGame.*;
import java.awt.*;
import javax.swing.*;
import Trainer.Player;
import Trainer.Rival;
import locations.PalletTownYourHouse;
import mainGame.TimerClass;
import Trainer.*;

public class StartScreen extends JPanel {
	
	CardLayout cl;
    JPanel cards, nameOptionsPanel, nameOptionsPanel2;
    Font textAreaFont = new Font("SANS_SERIF", Font.BOLD, 30), buttonFont = new Font("SANS_SERIF", Font.BOLD, 30);
    JTextArea startScreenText1;
    JButton nextButton1, nextButton2, name1, name2, name3, name4, optionsButton, name5, name6, name7, name8;
    int count = 0, stringLength = 0, textSpeed, buttonWidth, buttonHeight;
    StartScreen ss;
    Timer tm;
    Boolean finish = true, nameOptionsBool = false, setVisible = true, 
    		stopTimer, nameOptionsBool2 = false, professorOakVisited, labOutsideButtonEnable;
    Player player;
    Rival rival;
    String language, nextText, redText, greenText, blueText, yellowText, stringText, screen, fullText2;
    Options options;
    PalletTownYourHouse palletTownYourHouse;
    TimerClass timerClass;
    TrainerSuper trainer = new TrainerSuper();
    String color;


   
	public StartScreen(final CardLayout layout, final JPanel cards, Font font, 
			JTextArea textArea, String screen,
			Boolean nameOptionsBool, Player player2, Boolean setVisible, 
			String language, int textSpeed, String fullText, 
			Rival rival2, Boolean nameOptionsBool2, Boolean stopTimer, int buttonWidth, int buttonHeight,
			Boolean professorOakVisited, Boolean labOutsideButtonEnable, String color) {
		
		 //Attributes passed on from screen to screen, couple of them not needed anymore, player 2 has its name set in case 4
		 this.player = player2;     
		 this.cl = layout;
	     this.cards = cards;
	     this.textAreaFont = font;
	     this.startScreenText1 = textArea;
	     this.screen = screen;
	     this.nameOptionsBool = nameOptionsBool;
	     this.setVisible = setVisible;
	     this.language = language;
	     this.textSpeed = textSpeed;
	     this.fullText2 = fullText;
	     this.rival = rival2;
	     this.nameOptionsBool2 = nameOptionsBool2;
	     this.buttonWidth = buttonWidth;
	     this.buttonHeight = buttonHeight;
	     this.professorOakVisited=professorOakVisited;
	     this.labOutsideButtonEnable=labOutsideButtonEnable;
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
		 startScreenText1 = new JTextArea();		 
		 startScreenText1.setForeground(Color.cyan);
		 startScreenText1.setBackground(Color.black);
		 startScreenText1.setFont(font);
	
		 //Create Options Button first before other buttons in order to access size and text
		 JButton optionsButton = new JButton();
		 optionsButton.setBackground(Color.DARK_GRAY);
		 optionsButton.setForeground(Color.cyan);
		 optionsButton.setFont(font);
		
		 

		 //Elements not used dynamically have their text changed based off of language
		 if (language == "English") {
			 nextText = "Next";
			 blueText = "BLUE";
			 redText = "RED";
			 greenText = "GREEN";
			 yellowText = "YELLOW";
			 optionsButton.setText("Options");	
			 optionsButton.setPreferredSize(new Dimension(200,75));
		 }	 
		 else {
			 
			 nextText = "つぎ ";
			 blueText = "ブルー";
			 redText = "レッド";
			 greenText = "グリーン";
			 yellowText = "イエロー";
			 optionsButton.setText("せっていを かえる ");
			 optionsButton.setPreferredSize(new Dimension(300,75));
		 }
		 
		

	     
		 
		 
			
			
			
			
		 
	
	 //Screen values are initialized on button click action listeners below
		 //fullText2 is used within Timer
	//English main Text
     if (language == "English") { 
    	 switch (screen) {
    	 
    	 case "1":
           	 fullText2 = "*An image of a man in a lab coat appears.* \n\n Oak: Hello there! "
      		 		+ "Welcome to the world of POKEMON! My name is OAK!\r\n" + 
      		 		"            People call me the POKEMON PROF!";    
           	 break;
    	 case "2":

	       		fullText2 = "*An image of a Nidorino appears.*\r\n" + 
             		"Oak: This world is inhabited by creatures called POKEMON! For some\r\n" + 
             		"            people, POKEMON are pets. Others use them for fights. Myself...\r\n" + 
             		"            I study POKEMON as a profession.";
	       		break;
    	 case "3":
    		 fullText2 = "*An image of a boy (the player's character) appears.*\r\n" + 
     				"\r\n" + 
     				"Oak: First, what is your name?";
    		 break;
    		 
    	 case "4":
    		    		
         	fullText2 = "Oak: Right! So your name is " + player.getName() + ".";
    		 break;
    		 
    	 case "5":
    		 fullText2 = "*An image of another boy appears.*\r\n" +  
	       				"Oak: This is my grandson. He's been your rival since you were a baby.\r\n" + 
	       				"\r\n" + 
	       				" ...Erm, what is his name again?\r\n";
    
    		 break;
    		 
    	 case "6":
    		 
    		 fullText2 = "Oak: That's right! I remember now! His name is " + rival.getName() +"!\r\n";    		 
    		
    		 break;
    		 
    	 case "7":
	 
    		 fullText2 = "* " + player.getName() +"'s image reappears.*\r\n" + 
    		 		"\r\n" + 
    		 		"Oak: " + player.getName() +"!" + " Your very own POKEMON legend is about to unfold! A world of\r\n" + 
    		 		"            dreams and adventures with POKEMON awaits! Let's go!";    		 
    		
    		 break;

    	 }
     }
	         //Japanese main text
	         else {
	        	 switch(screen) {
	        	 case "1":
	        	
	        	 fullText2 = "はじめまして！  ポケッ モンスタ- のせかいへ ようこそ！";
	        	 break;
	        	 
	        	 
	        	 case "2":
	        		 fullText2 = "の ポケモン という いきものを ひとは ぺツトに  したり しょうぶに つかったリ。。。\r\n" + 
	            				"そして。。。わたしは この ポケモンの けんきゅを してる というわけだ \r\n" + "では はじめに きみの なまえを おしえて もらおう！";
	        		 break;
	        		 
	        	 case "3":
	        		 fullText2 = "の ポケモン という いきものを ひとは ぺツトに  したり しょうぶに つかったリ。。。\r\n" + 
	            				"そして。。。わたしは この ポケモンの けんきゅを してる というわけだ \r\n" + "では はじめに きみの なまえを おしえて もらおう！";
	        		 break;
	        		 
	        	 case "4": 
       	
	        		 fullText2 = "ふむ。。。" + player.getName() +  " と いうんだな！";
	        		 break;
	        		 
	        	 case "5":
	        		 fullText2 = "こいつは わたしの まご きみの おさななじみであリ ライバル である\r\n" + "。。。えーと？ なまえ わ なんで いつたかな？";
	        		 break;
	        		 
	        	 case "6":

	        		 fullText2 = "そうだ そうだ! おもいだしたぞ " + rival.getName() + " という なまえだ";
	        		 break;
	        		 
	        	 case "7":

	        		 fullText2 = player.getName() + "! いよいよ これから きみの ものがたリの よじまリだ! ゆめと ぼうけんと! ポケ\r\n" + 
	        		 		"\r\n" + 
	        		 		"ットモンスタ-の せかいへ! レッツ ゴ-!";
	        		 break;
	        		 
	        		
	        	 }
	        	 
	        	 
	         }
	        	 
	         
		 //Start timer with stopTimer value set to false. Only true when going into options from this screen to stop any overlay issues

         timerClass = new TimerClass(fullText2, stopTimer, textSpeed , startScreenText1);

  
     	 
     	 
		 //GUI Setup 
		 JButton nextButton1 = new JButton(nextText);
		 nextButton1.setBackground(Color.DARK_GRAY);
		 nextButton1.setForeground(Color.cyan);
		 nextButton1.setPreferredSize(new Dimension(150,75));
		 nextButton1.setFont(font);
		 nextButton1.setVisible(setVisible);
		
		 
		 JButton name1 = new JButton(redText);
		 name1.setPreferredSize(new Dimension(200,75));
		 name1.setBackground(Color.DARK_GRAY);
		 name1.setForeground(Color.red);
		 name1.setFont(font);
		 
		 JButton name2 = new JButton(blueText);
		 name2.setPreferredSize(new Dimension(200,75));
		 name2.setBackground(Color.DARK_GRAY);
		 name2.setForeground(Color.blue);
		 name2.setFont(font);
		 
		 JButton name3 = new JButton(greenText);
		 name3.setPreferredSize(new Dimension(200,75));
		 name3.setBackground(Color.DARK_GRAY);
		 name3.setForeground(Color.green);
		 name3.setFont(font);
		 
		 JButton name4 = new JButton(yellowText);
		 name4.setPreferredSize(new Dimension(200,75));
		 name4.setBackground(Color.DARK_GRAY);
		 name4.setForeground(Color.yellow);
		 name4.setFont(font);
		 
		 JPanel nameOptionsPanel = new JPanel();
		 nameOptionsPanel.setLayout(new GridLayout(1,4));
		 nameOptionsPanel.add(name1);
		 nameOptionsPanel.add(name2);
		 nameOptionsPanel.add(name3);
		 nameOptionsPanel.add(name4);
		 nameOptionsPanel.setVisible(nameOptionsBool);
		
		 
		 JButton name5 = new JButton(redText);
		 name5.setPreferredSize(new Dimension(200,75));
		 name5.setBackground(Color.DARK_GRAY);
		 name5.setForeground(Color.red);
		 name5.setFont(font);
		 
		 JButton name6 = new JButton(blueText);
		 name6.setPreferredSize(new Dimension(200,75));
		 name6.setBackground(Color.DARK_GRAY);
		 name6.setForeground(Color.blue);
		 name6.setFont(font);
		 
		 JButton name7 = new JButton(greenText);
		 name7.setPreferredSize(new Dimension(200,75));
		 name7.setBackground(Color.DARK_GRAY);
		 name7.setForeground(Color.green);
		 name7.setFont(font);
		 
		 JButton name8 = new JButton(yellowText);
		 name8.setPreferredSize(new Dimension(200,75));
		 name8.setBackground(Color.DARK_GRAY);
		 name8.setForeground(Color.yellow);
		 name8.setFont(font);
		 
		 JPanel nameOptionsPanel2 = new JPanel();
		 nameOptionsPanel2.setLayout(new GridLayout(1,4));
		 nameOptionsPanel2.add(name5);
		 nameOptionsPanel2.add(name6);
		 nameOptionsPanel2.add(name7);
		 nameOptionsPanel2.add(name8);
		 nameOptionsPanel2.setVisible(nameOptionsBool2);
		 
	
		 gb.gridx=0;
	     gb.gridy=0;
	     gb.weightx = 1;
		 add(optionsButton, gb);
		 gb.gridx=0;
	     gb.gridy=1;
	     gb.weighty=1;
		 add(startScreenText1, gb);
	     gb.gridx=0;
	     gb.gridy=2;
	     gb.weightx = 1;
	     gb.weighty = 1;
	     add(nameOptionsPanel, gb);
	     gb.gridx=0;
	     gb.gridy=2;
	     add(nameOptionsPanel2, gb);
	     gb.gridx=0;
	     gb.gridy=4;
	     gb.weightx = 1;
	     add(nextButton1, gb);
	     
	 	 
	     
	     //Options Button recreates Options object and shows Options screen with all values already included in StartScreen class (passed on)
	     optionsButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	options = new Options(cl, cards,"startscreen", startScreenText1, screen, 
	            			nameOptionsBool, player, setVisible, language, textSpeed, fullText2,
	            			rival, font, stopTimer, nameOptionsBool2, 55f, buttonWidth, buttonHeight, false, 
	            			professorOakVisited, labOutsideButtonEnable, trainer, 0, color, "");
					cards.add(options, "options");
					cl.show(cards, "options");
					
	                
	            }
	        });
	  
	     
	     //Next button click recreates and shows current screen with updated value for screen string
		 switch (screen) {
		 case "1":
		 nextButton1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	
		       	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1,
		       			"2", false, player, true,
		       			language, textSpeed,fullText2, rival,
		       			false, stopTimer, buttonWidth, buttonHeight, professorOakVisited, labOutsideButtonEnable, color);
                cards.add(ss, "startscreen");
                layout.show(cards, "startscreen");  
             
	                
	            }
	        });
		 break;
		 
		 case "2":
			 nextButton1.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, "3",
		            			true, player, false, language, textSpeed,
		            			fullText2, rival, false, stopTimer, buttonWidth, buttonHeight, 
		            			professorOakVisited, labOutsideButtonEnable, color);
		                cards.add(ss, "startscreen");
		                layout.show(cards, "startscreen");  
	             
		                
		            }
		        });
			 break;
			 
		 
	 
		 case "4":
			 
			 nextButton1.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	
		            	
		            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, "5",
		            			false, player, false, language, textSpeed,
		            			fullText2, rival, true, stopTimer, buttonWidth, buttonHeight, 
		            			professorOakVisited, labOutsideButtonEnable, color);	
		                cards.add(ss, "startscreen");
		                layout.show(cards, "startscreen");  
             
		                
		            }
		        });
			 break;
			 
		 	case "6":
			 
			 nextButton1.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	
		            	
		            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, "7",
		            			false, player, true, language, textSpeed,
		            			fullText2, rival, false, stopTimer, buttonWidth, 
		            			buttonHeight, professorOakVisited, labOutsideButtonEnable, color);	
		                cards.add(ss, "startscreen");
		                layout.show(cards, "startscreen");  
             
		                
		            }
		        });
			 break;
			 
			//Change Location to PalletTownYourHouse
		 	case "7":
			 
			 nextButton1.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	palletTownYourHouse = new PalletTownYourHouse(cl, cards, textAreaFont, 
		                		"8", language, textSpeed, player, rival, stopTimer, "My House",
		                		professorOakVisited, labOutsideButtonEnable, color);
		            	cards.add(palletTownYourHouse, "pallettownyourhouse");
		            	
		                layout.show(cards, "pallettownyourhouse");
		                
          
		                
		            }
		        });
			 break;
			 
			 
			 
			 
		 }
		 
		 //Action listener for name buttons: create player object, set its name, initialize current screen, and show updated screen
		  switch(screen) {
		  case "3":
		 name1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            
	            	if (language == "English") {
	            	player.setName("RED");
	            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, "4",
	            			false, player, true, language, textSpeed,
	            			fullText2, rival, false, stopTimer, buttonWidth, buttonHeight, 
	            			professorOakVisited, labOutsideButtonEnable, color);
	            	 

	            	}
	            	
	            	else {
	            		
	            	 	player.setName("レッド ");	       		    
	            	 	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, "4",
	            	 			false, player, true, language, textSpeed,
	            	 			fullText2, rival, false, stopTimer, buttonWidth, buttonHeight, 
	            	 			professorOakVisited,labOutsideButtonEnable, color);
	            	}
	            	
	           
	                cards.add(ss, "startscreen");
	                layout.show(cards, "startscreen");  
  
	                
	            }
	        });

		 
		 name2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	if (language == "English") {
	            	player.setName("BLUE");
	            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, "4",
	            			false, player, true, language, textSpeed,
	            			fullText2, rival, false, stopTimer, buttonWidth, buttonHeight, 
	            			professorOakVisited, labOutsideButtonEnable, color);
	            	}
	            	
	            	else {
	            	player.setName("ブルー");
	            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, "4",
	            			false, player, true, language, textSpeed,fullText2,
	            			rival, false, stopTimer, buttonWidth, buttonHeight, 
	            			professorOakVisited, labOutsideButtonEnable, color);

	            		
	            	}
	       		   
	            	
	                cards.add(ss, "startscreen");
	                layout.show(cards, "startscreen");    
       
	                
	            }
	        });
		 
		 name3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	if (language == "English") {
	            		player.setName("GREEN");
	            		ss = new StartScreen(cl,cards, textAreaFont, startScreenText1,"4",
	            				false, player, true, language, textSpeed,
	            				fullText2, rival, false, stopTimer, buttonWidth,
	            				buttonHeight, professorOakVisited, labOutsideButtonEnable, color);
	            		
	       		    
	            	}
	            	
	            	else {
	            		player.setName("グリーン");
	            		ss = new StartScreen(cl,cards, textAreaFont, startScreenText1,
	            				"4", false, player, true, language, textSpeed,
	            				fullText2, rival, false, stopTimer, buttonWidth, 
	            				buttonHeight, professorOakVisited, labOutsideButtonEnable, color);
	
	            	}
	       		    
	             
	            	
	                cards.add(ss, "startscreen");
	                layout.show(cards, "startscreen");  
	                
	            }
	        });
		 
		 name4.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	if (language == "English") {
	            	player.setName("YELLOW");
	            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, "4",
	            			false, player, true, language, textSpeed,fullText2,
	            			rival, false, stopTimer, buttonWidth, buttonHeight, 
	            			professorOakVisited, labOutsideButtonEnable, color);
	         
	       		    
	            	}
	            	
	            	else {
	            		player.setName("イエロー"); 
	            		ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, "4",
	            				false, player, true, language, textSpeed,fullText2,
	            				rival, false, stopTimer, buttonWidth, buttonHeight, 
	            				professorOakVisited, labOutsideButtonEnable, color);
	            
	            	}
	       		   
	            	
	                cards.add(ss, "startscreen");
	                layout.show(cards, "startscreen");  
       
	                
	            }
	        });
		 
		 
		 //Action Listener for Rival NPC Trainer's name
		  case "5":
				 name5.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
			            
			            	if (language == "English") {
				            	rival.setName("RED");

				            	}
				            	
				            	else {
				            		rival.setName("レッド");				            					       		 

				            		
				            	}
				       		   
				            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, "6",
				            			false, player, true, language, textSpeed,fullText2,
				            			rival, false, stopTimer, buttonWidth, buttonHeight, 
				            			professorOakVisited, labOutsideButtonEnable, color);
				                cards.add(ss, "startscreen");
				                layout.show(cards, "startscreen");  
			                
			            }
			        });
				 
				 name6.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
 
			            	if (language == "English") {
				            	rival.setName("BLUE");

				            	}
				            	
				            	else {
				            	rival.setName("ブルー");

				            		
				            	}
				       		   
				            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1,"6",
				            			false, player, true, language, textSpeed,fullText2,
				            			rival, false, stopTimer, buttonWidth, 
				            			buttonHeight, professorOakVisited, labOutsideButtonEnable, color);
				                cards.add(ss, "startscreen");
				                layout.show(cards, "startscreen");  
			                
			            }
			        });
				 
				 name7.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
 
			            	if (language == "English") {
			            		rival.setName("GREEN");

				            	}
				            	
				            	else {
				            		rival.setName("グリーン");
				            			

				            		
				            	}
				       		    
				            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, "6",
				            			false, player, true, language, textSpeed,fullText2,
				            			rival, false, stopTimer, buttonWidth, 
				            			buttonHeight, professorOakVisited, labOutsideButtonEnable, color);
				                cards.add(ss, "startscreen");
				                layout.show(cards, "startscreen");  
			                
			            }
			        });
				 
				 name8.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {

			            	if (language == "English") {
			            		rival.setName("YELLOW");

				            	}
				            	
				            	else {
				            		rival.setName("イエロー");

				            		
				            	}
				       		   
				            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, "6", 
				            			false, player, true, language, textSpeed,fullText2,
				            			rival, false, stopTimer, buttonWidth, buttonHeight, 
				            			professorOakVisited, labOutsideButtonEnable, color);
				                cards.add(ss, "startscreen");
				                layout.show(cards, "startscreen");  
			            }
			        });
				 break;
		 
		  }
		 
		 
	
		
	}
	

	

	
	}
	
	
