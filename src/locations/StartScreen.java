package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.border.EmptyBorder;
import mainGame.ConfirmContinue;
import mainGame.Options;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import Trainer.Player;
import Trainer.Rival;

public class StartScreen extends JPanel {
	
	CardLayout cl;
    JPanel cards, nameOptionsPanel, nameOptionsPanel2;
    Font textAreaFont = new Font("SANS_SERIF", Font.BOLD, 30), buttonFont = new Font("SANS_SERIF", Font.BOLD, 30);
    JTextArea startScreenText1;
    JButton nextButton1, nextButton2, name1, name2, name3, name4, optionsButton, name5, name6, name7, name8;
    int count = 0, stringLength = 0, textSpeed;
    StartScreen ss;
    Timer tm;
    Boolean finish, nameOptionsBool = false, setVisible = true, stopTimer, nameOptionsBool2 = false;
    Player player;
    Rival rival;
    String language, nextText, redText, greenText, blueText, yellowText, stringText, screen, fullText2;
    Options options;

    
	public void timerStart(String text,Boolean stopTimer){
		String text2 = text;
		count = 0;
		
	
		
		if (stopTimer) {
			tm = new Timer(textSpeed, new ActionListener() {
				
			    public void actionPerformed(ActionEvent arg0) {
			    	

			    	 startScreenText1.setText(text2);
			    	}

					 });
				
				 if (finish == true) {
					
					   tm.stop();
				   }
			
			  tm.start();
		}
		
		else {
		tm = new Timer(textSpeed, new ActionListener() {
			
	    public void actionPerformed(ActionEvent arg0) {
	    	

	    	   stringLength = 0;
			   stringLength = text2.length();
			
			   count++;
			   if(count > stringLength || stringLength == 0) {
				   		 
				    finish = true;	
			   } 	
			   
			   else {
				   
			    startScreenText1.setText(text2.substring(0,count));
			    finish = false;
					   }
	    	}

			 });
		
		 if (finish == true) {
			
			   tm.stop();
		   }
	
	  tm.start();
	}

		}
	
	

   
	public StartScreen(final CardLayout layout, final JPanel cards, Font font, JTextArea textArea, Boolean finish, String screen,
			Boolean nameOptionsBool, Player player2, Boolean setVisible, String language, int textSpeed, String fullText, 
			Rival rival2, Boolean nameOptionsBool2, Boolean stopTimer) {
		
		 //Attributes passed on from screen to screen, couple of them not needed anymore, player 2 has its name set in case 4
		 this.player = player2;     
		 this.cl = layout;
	     this.cards = cards;
	     this.textAreaFont = font;
	     this.startScreenText1 = textArea;
	     this.finish = finish;
	     this.screen = screen;
	     this.nameOptionsBool = nameOptionsBool;
	     this.setVisible = setVisible;
	     this.language = language;
	     this.textSpeed = textSpeed;
	     this.fullText2 = fullText;
	     this.rival = rival2;
	     this.nameOptionsBool2 = nameOptionsBool2;
//	     this.stopTimer = stopTimer;
	     
	     
	     //Extension of JFrame, set layout and attributes for layout
		 setBackground(Color.black);
		 setLayout(new GridBagLayout());
		 GridBagConstraints gb = new GridBagConstraints();
		 startScreenText1 = new JTextArea();		 
		 startScreenText1.setForeground(Color.cyan);
		 startScreenText1.setBackground(Color.black);
		 startScreenText1.setFont(textAreaFont);
	
		 //Create Options Button first before other buttons in order to access size and text
		 JButton optionsButton = new JButton();
		 optionsButton.setBackground(Color.DARK_GRAY);
		 optionsButton.setForeground(Color.cyan);
		 optionsButton.setFont(buttonFont);
		 

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
    		 if (player.getName() == "ブルー") {
 				player.setName("BLUE");
 			}

 			if (player.getName() == "レッド") {	
 				player.setName("RED");
 			}

 			if (player.getName() == "グリーン") {
 				player.setName("GREEN");
 			}

 			if (player.getName() == "イエロー") {
 				player.setName("YELLOW");
 			}
    		 
         	fullText2 = "Oak: Right! So your name is " + player.getName() + ".";
    		 break;
    		 
    	 case "5":
    		 fullText2 = "*An image of another boy appears.*\r\n" +  
	       				"Oak: This is my grandson. He's been your rival since you were a baby.\r\n" + 
	       				"\r\n" + 
	       				" ...Erm, what is his name again?\r\n";
    
    		 break;
    		 
    	 case "6":
    		 if (rival.getName() == "ブルー") {
  				rival.setName("BLUE");
  			}

  			if (rival.getName() == "レッド") {	
  				rival.setName("RED");
  			}

  			if (rival.getName() == "グリーン") {
  				rival.setName("GREEN");
  			}

  			if (rival.getName() == "イエロー") {
  				rival.setName("YELLOW");
  			}
    		 
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
	        		 if (player.getName() == "BLUE") {
	      				player.setName("ブルー");	
	      			}
	        		 
	        		 if (player.getName() == "RED") {
	     				player.setName("レッド");
	     			}
	     			
	     			if (player.getName() == "GREEN") {
	     				player.setName("グリーン");
	     			}
	     			
	     			if (player.getName() == "YELLOW") {
	     				player.setName("イエロー");
	     			}
	         		
	         	
	        		 fullText2 = "ふむ。。。" + player.getName() +  " と いうんだな！";
	        		 break;
	        		 
	        	 case "5":
	        		 fullText2 = "こいつは わたしの まご きみの おさななじみであリ ライバル である\r\n" + "。。。えーと？ なまえ わ なんで いつたかな？";
	        		 break;
	        		 
	        	 case "6":
	        		 if (rival.getName() == "BLUE") {
		      				rival.setName("ブルー");	
		      			}
		        		 
		        		 if (rival.getName() == "RED") {
		     				rival.setName("レッド");
		     			}
		     			
		     			if (rival.getName() == "GREEN") {
		     				rival.setName("グリーン");
		     			}
		     			
		     			if (rival.getName() == "YELLOW") {
		     				rival.setName("イエロー");
		     			}
	        		 
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

     	 
         timerStart(fullText2, stopTimer);

  
     	 
     	 
		 //GUI Setup 
		 JButton nextButton1 = new JButton(nextText);
		 nextButton1.setPreferredSize(new Dimension(150,75));
		 nextButton1.setBackground(Color.DARK_GRAY);
		 nextButton1.setForeground(Color.cyan);
		 nextButton1.setFont(buttonFont);
		 nextButton1.setVisible(setVisible);
		
		 
		 JButton name1 = new JButton(redText);
		 name1.setPreferredSize(new Dimension(200,75));
		 name1.setBackground(Color.DARK_GRAY);
		 name1.setForeground(Color.red);
		 name1.setFont(buttonFont);
		 
		 JButton name2 = new JButton(blueText);
		 name2.setPreferredSize(new Dimension(200,75));
		 name2.setBackground(Color.DARK_GRAY);
		 name2.setForeground(Color.blue);
		 name2.setFont(buttonFont);
		 
		 JButton name3 = new JButton(greenText);
		 name3.setPreferredSize(new Dimension(200,75));
		 name3.setBackground(Color.DARK_GRAY);
		 name3.setForeground(Color.green);
		 name3.setFont(buttonFont);
		 
		 JButton name4 = new JButton(yellowText);
		 name4.setPreferredSize(new Dimension(200,75));
		 name4.setBackground(Color.DARK_GRAY);
		 name4.setForeground(Color.yellow);
		 name4.setFont(buttonFont);
		 
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
		 name5.setFont(buttonFont);
		 
		 JButton name6 = new JButton(blueText);
		 name6.setPreferredSize(new Dimension(200,75));
		 name6.setBackground(Color.DARK_GRAY);
		 name6.setForeground(Color.blue);
		 name6.setFont(buttonFont);
		 
		 JButton name7 = new JButton(greenText);
		 name7.setPreferredSize(new Dimension(200,75));
		 name7.setBackground(Color.DARK_GRAY);
		 name7.setForeground(Color.green);
		 name7.setFont(buttonFont);
		 
		 JButton name8 = new JButton(yellowText);
		 name8.setPreferredSize(new Dimension(200,75));
		 name8.setBackground(Color.DARK_GRAY);
		 name8.setForeground(Color.yellow);
		 name8.setFont(buttonFont);
		 
		 JPanel nameOptionsPanel2 = new JPanel();
		 nameOptionsPanel2.setLayout(new GridLayout(1,4));
		 nameOptionsPanel2.add(name5);
		 nameOptionsPanel2.add(name6);
		 nameOptionsPanel2.add(name7);
		 nameOptionsPanel2.add(name8);
		 nameOptionsPanel2.setVisible(nameOptionsBool2);
		 
	
		 gb.gridx=0;
	     gb.gridy=0;
		 add(optionsButton, gb);
		 gb.gridx=0;
	     gb.gridy=1;
	     gb.weighty=1;
		 add(startScreenText1, gb);
	     gb.gridx=0;
	     gb.gridy=2;
	     add(nameOptionsPanel, gb);
	     gb.gridx=0;
	     gb.gridy=2;
	     add(nameOptionsPanel2, gb);
	     gb.gridx=0;
	     gb.gridy=4;
	     add(nextButton1, gb);
	     
	     //Options Button recreates Options object and shows Options screen with all values already included in StartScreen class (passed on)
	     optionsButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	options = new Options(cl, cards,"startscreen", startScreenText1, finish, screen, nameOptionsBool, player, setVisible, language, textSpeed, fullText2, rival, font, stopTimer, nameOptionsBool2);
					cards.add(options, "options");
					cl.show(cards, "options");
					timerStart(fullText2, true);
	                
	            }
	        });
	  
	     
	     //Next button click recreates and shows current screen with updated value for screen string
		 switch (screen) {
		 case "1":
		 nextButton1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	
		       	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "2", false, player, true, language, textSpeed,fullText2, rival, false, stopTimer);
                cards.add(ss, "startscreen");
                layout.show(cards, "startscreen");  
             
	                
	            }
	        });
		 break;
		 
		 case "2":
			 nextButton1.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "3", true, player, false, language, textSpeed,fullText2, rival, false, stopTimer);
		                cards.add(ss, "startscreen");
		                layout.show(cards, "startscreen");  
	             
		                
		            }
		        });
			 break;
			 
		 
	 
		 case "4":
			 
			 nextButton1.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	
		            	
		            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "5", false, player, false, language, textSpeed,fullText2, rival, true, stopTimer);	
		                cards.add(ss, "startscreen");
		                layout.show(cards, "startscreen");  
             
		                
		            }
		        });
			 break;
			 
		 	case "6":
			 
			 nextButton1.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	
		            	
		            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "7", false, player, true, language, textSpeed,fullText2, rival, false, stopTimer);	
		                cards.add(ss, "startscreen");
		                layout.show(cards, "startscreen");  
             
		                
		            }
		        });
			 break;
			 
			//Change Location to PalletTownYourHouse
		 	case "7":
			 
			 nextButton1.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	
		            	
//		            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "7", false, player, true, language, textSpeed,fullText2, rival, false);	
//		                cards.add(ss, "startscreen");
//		                layout.show(cards, "startscreen");  
          
		                
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
	            	Player player3 = new Player("RED");
	            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player3, true, language, textSpeed,fullText2, rival, false, stopTimer);
	            	 

	            	}
	            	
	            	else {
	            		
	            	 	Player player3 = new Player("レッド ");	       		    
	            	 	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player3, true, language, textSpeed,fullText2, rival, false, stopTimer);
	            	}
	            	
	           
	                cards.add(ss, "startscreen");
	                layout.show(cards, "startscreen");  
  
	                
	            }
	        });

		 
		 name2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	if (language == "English") {
	            	Player player3 = new Player("BLUE");
	            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player3, true, language, textSpeed,fullText2, rival, false, stopTimer);
	            	}
	            	
	            	else {
	            	Player player3 = new Player("ブルー");
	            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player3, true, language, textSpeed,fullText2, rival, false, stopTimer);

	            		
	            	}
	       		   
	            	
	                cards.add(ss, "startscreen");
	                layout.show(cards, "startscreen");    
       
	                
	            }
	        });
		 
		 name3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	if (language == "English") {
	            		Player player3 = new Player("GREEN");
	            		ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player3, true, language, textSpeed,fullText2, rival, false, stopTimer);
	            		
	       		    
	            	}
	            	
	            	else {
	            		Player player3 = new Player("グリーン");
	            		ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player3, true, language, textSpeed,fullText2, rival, false, stopTimer);
	
	            	}
	       		    
	             
	            	
	                cards.add(ss, "startscreen");
	                layout.show(cards, "startscreen");  
	                
	            }
	        });
		 
		 name4.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	if (language == "English") {
	            	Player player3 = new Player("YELLOW");
	            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player3, true, language, textSpeed,fullText2, rival, false, stopTimer);
	         
	       		    
	            	}
	            	
	            	else {
	            		Player player3 = new Player("イエロー"); 
	            		ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player3, true, language, textSpeed,fullText2, rival, false, stopTimer);
	            
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
				            	rival = new Rival("RED");

				            	}
				            	
				            	else {
				            	rival = new Rival("レッド");				            					       		 

				            		
				            	}
				       		   
				            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "6", false, player, true, language, textSpeed,fullText2, rival, false, stopTimer);
				                cards.add(ss, "startscreen");
				                layout.show(cards, "startscreen");  
			                
			            }
			        });
				 
				 name6.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
 
			            	if (language == "English") {
				            	rival = new Rival("BLUE");

				            	}
				            	
				            	else {
				            	rival = new Rival("ブルー");

				            		
				            	}
				       		   
				            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "6", false, player, true, language, textSpeed,fullText2, rival, false, stopTimer);
				                cards.add(ss, "startscreen");
				                layout.show(cards, "startscreen");  
			                
			            }
			        });
				 
				 name7.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
 
			            	if (language == "English") {
				            	rival = new Rival("GREEN");

				            	}
				            	
				            	else {
				            	rival = new Rival("グリーン");
				            			

				            		
				            	}
				       		    
				            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "6", false, player, true, language, textSpeed,fullText2, rival, false, stopTimer);
				                cards.add(ss, "startscreen");
				                layout.show(cards, "startscreen");  
			                
			            }
			        });
				 
				 name8.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {

			            	if (language == "English") {
				            	rival = new Rival("YELLOW");

				            	}
				            	
				            	else {
				            	rival = new Rival("イエロー");

				            		
				            	}
				       		   
				            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "6", false, player, true, language, textSpeed,fullText2, rival, false, stopTimer);
				                cards.add(ss, "startscreen");
				                layout.show(cards, "startscreen");  
			            }
			        });
				 break;
		 
		  }
		 
		 
	
		
	}
	

	

	
	}
	
	
