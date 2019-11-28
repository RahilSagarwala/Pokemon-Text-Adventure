package mainGame;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import locations.StartScreen;
import Trainer.Player;
import Trainer.Rival;
import Trainer.*;
import java.io.*;





public class MainGame extends JPanel {

    JPanel cards, namesPanel, titlePanel, frontBoxPanel, backBoxPanel, logoPanel, mainScreenPanel;
    JButton feedbackButton, newGameButton, continueButton, creditsButton, optionsButton, musicOffButton, musicOnButton;
    JLabel namesLabel, titleLabel, logoLabel, logoLabel2, logoLabel3;
	Font titleFont, italicFont = new Font("SANS_SERIF", Font.ITALIC, 25), 
			buttonFont = new Font("SANS_SERIF", Font.BOLD, 10), font;
	final static String mainScreenString = "mainscreen";
    CardLayout cl;
    Options options;
    Credits credits;
    NewGame newGame;
    ContinueGame continu;
    StartScreen startScreen;
    ConfirmContinue confirmContinue;
    String chosenSave = "", fullText2, language;
    JTextArea startScreenTextArea = new JTextArea();
    Player player;
    int textSpeed, buttonWidth, buttonHeight;
    Rival rival;
    Boolean stopTimer, professorOakVisited, labOutsideButtonEnable;
    Float titleSize;
    ImageIcon logoIcon, logoIcon2, logoIcon3;
    TrainerSuper trainer = new TrainerSuper();
    String color, musicMain, fromUi;
    Clip clip;
    
    
    
    
//    public static synchronized void stopSound() {
//	  	  new Thread(new Runnable() {
//	  	    public void run() {
//	  	      try {
//	  	        Clip clip = AudioSystem.getClip();
//	  	       
//	  	        clip.stop(); 
//	  	        clip.close();       
//	  	        clip.flush();
//
//	  	      } catch (Exception e) {
//	  	        System.err.println(e.getMessage());
//	  	      }
//	  	    }
//	  	  }).run();
//
//	  	}
    
    public static synchronized void startSound() {
	  	  new Thread(new Runnable() {
	  	    public void run() {
	  	      try {
	  	        Clip clip = AudioSystem.getClip();
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
    
    
    
    
    public MainGame(final CardLayout layout, final JPanel cards, Font font, 
    		String language, int textSpeed, Boolean stopTimer, Float titleSize, int buttonWidth, int buttonHeight, 
    		Player player, Rival rival, Boolean professorOakVisited, Boolean labOutsideButtonEnable, String color,
    		Clip clip, String musicMain2, String fromUi) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
    	this.cl = layout;
	    this.cards = cards;
	    this.font = font;
	    this.language = language;
	    this.textSpeed = textSpeed;
	    this.stopTimer = stopTimer;
	    this.titleSize = titleSize;
	    this.buttonWidth = buttonWidth;
	    this.buttonHeight = buttonHeight;
	    this.player = player;
	    this.rival = rival;
	    this.professorOakVisited=professorOakVisited;
	    this.labOutsideButtonEnable=labOutsideButtonEnable;
	    this.color = color;
	    this.clip = clip;
	    this.musicMain = musicMain2;
	    this.fromUi = fromUi;
	    
	    Clip clip2 = AudioSystem.getClip();
	    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
		          this.getClass().getClassLoader().getResource("PTAmusic.wav"));
	    clip2.open(inputStream);
	    
	    if (musicMain == "on") {  
	       
	        clip2.start();
	    }
	    if(musicMain == "off") {
	  	        clip2.stop();
	  	        clip2.close();
	  	        
	    }
	    
	    	    
	    
    	
	    setLayout(new GridBagLayout());
	    if (color == "black") {
        setBackground(Color.black); 
	    }
	    
	    if (color == "cyan") {
	        setBackground(Color.cyan); 
		    }
     

         
//        //Title Font
//        if (language == "English") {
//    	try {
//		    titleFont = Font.createFont(Font.TRUETYPE_FONT, 
//		            this.getClass().getClassLoader().getResourceAsStream("PokemonHollow.ttf")).deriveFont(titleSize);
//		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		    ge.registerFont(titleFont);
//		} catch (IOException e) {
//		    e.printStackTrace();
//		} catch(FontFormatException e) {
//		    e.printStackTrace();
//		}
//        }
//        else {
//        	try {
//    		    titleFont = Font.createFont(Font.TRUETYPE_FONT, 
//    		            this.getClass().getClassLoader().getResourceAsStream("japanesetitle.otf")).deriveFont(60f);
//    		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//    		    ge.registerFont(titleFont);
//    		} catch (IOException e) {
//    		    e.printStackTrace();
//    		} catch(FontFormatException e) {
//    		    e.printStackTrace();
//    		}
//        }
    	
    	//Create GUI
		titlePanel = new JPanel();
		titlePanel.setBackground(Color.black);
		titleLabel = new JLabel();
		titleLabel = new JLabel("Pokemon Text Adventure ");
		titleLabel.setForeground(Color.cyan);
		titleLabel.setFont(titleFont);	
		titlePanel.add(titleLabel);


		
		namesPanel = new JPanel();
		namesPanel.setLayout(new BorderLayout());
		namesPanel.setBackground(Color.cyan);
		namesLabel = new JLabel("By: Rahil Sagarwala, Gary Ray, Chad Mendenhall, and Luis Siavchay");
		namesLabel.setForeground(Color.LIGHT_GRAY);
		namesLabel.setFont(italicFont);
		namesPanel.add(namesLabel);
		
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//	    this.setSize(screenSize.width, screenSize.height);
		
		
		
		
		newGameButton = new JButton("New Game");
		newGameButton.setBackground(Color.DARK_GRAY);
		newGameButton.setForeground(Color.white);
		newGameButton.setFont(font);
		
		
		continueButton = new JButton("Continue");
		continueButton.setBackground(Color.DARK_GRAY);
		continueButton.setForeground(Color.white);
		continueButton.setFont(font);
		
		creditsButton = new JButton("Credits");
		creditsButton.setBackground(Color.DARK_GRAY);
		creditsButton.setForeground(Color.white);
		creditsButton.setFont(font);
	
		
		optionsButton = new JButton("Options");
		optionsButton.setBackground(Color.DARK_GRAY);
		optionsButton.setForeground(Color.white);
		optionsButton.setFont(font);
		
		
		feedbackButton = new JButton("Feedback");
		feedbackButton.setBackground(Color.DARK_GRAY);
		feedbackButton.setForeground(Color.white);
		feedbackButton.setFont(font);
		
		JButton expandLogoButton = new JButton("Full Size");
		expandLogoButton.setBackground(Color.DARK_GRAY);
		expandLogoButton.setForeground(Color.white);
		expandLogoButton.setFont(font);
		expandLogoButton.setPreferredSize(new Dimension(160,40));
		
		JButton expandLogoButton2 = new JButton("Full Size");
		expandLogoButton2.setBackground(Color.DARK_GRAY);
		expandLogoButton2.setForeground(Color.white);
		expandLogoButton2.setFont(font);
		expandLogoButton2.setPreferredSize(new Dimension(160,40));
		
		musicOnButton = new JButton("Music On");
		musicOnButton.setBackground(Color.DARK_GRAY);
		musicOnButton.setForeground(Color.white);
		musicOnButton.setFont(font);
		musicOnButton.setPreferredSize(new Dimension(175,40));
		
		musicOffButton = new JButton("Music Off");
		musicOffButton.setBackground(Color.DARK_GRAY);
		musicOffButton.setForeground(Color.white);
		musicOffButton.setFont(font);
		musicOffButton.setPreferredSize(new Dimension(175,40));
		
		
		feedbackButton.setPreferredSize(new Dimension(400,80));
		newGameButton.setPreferredSize(new Dimension(400,80));
		continueButton.setPreferredSize(new Dimension(400,80));
		creditsButton.setPreferredSize(new Dimension(400,80));
		optionsButton.setPreferredSize(new Dimension(400,80));
		
		 if(language == "Japanese") {
			 feedbackButton.setText("フィードバック");
			 newGameButton.setText("さいしょからはじめる");
			 continueButton.setText("つづきからはじめる");
			 creditsButton.setText("エンドクレジット");
			 optionsButton.setText("せっていを かえる");
			 expandLogoButton.setText("フルサイズ");
			 expandLogoButton.setPreferredSize(new Dimension(171,40));
			 expandLogoButton2.setText("フルサイズ");
			 expandLogoButton2.setPreferredSize(new Dimension(171,40));
			 Font f = new Font("SANS_SERIF", Font.BOLD, 26);
			 Font f2 = new Font("SANS_SERIF", Font.BOLD, 21);
			 expandLogoButton.setFont(f);
			 expandLogoButton2.setFont(f);
			 titleLabel.setText("<html>ポケットモンスターテキスト<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp アドベンチャー<html>");
			 musicOnButton.setText("おんがくをおんにする");
			 musicOffButton.setText("おんがくをけす");
			 musicOnButton.setPreferredSize(new Dimension(260,40));
			 musicOnButton.setFont(f2);
			 musicOffButton.setPreferredSize(new Dimension(200,40));
			 musicOffButton.setFont(f2);
		 }
		 
		
		

		logoIcon = new ImageIcon(this.getClass().getClassLoader().getResource("mainLogoStarters2.png"));
		 logoLabel = new JLabel(logoIcon);
			logoIcon2 = new ImageIcon(this.getClass().getClassLoader().getResource("logo1.png"));
			 logoLabel2 = new JLabel(logoIcon2);
			 	if (language == "English") {
			 	logoIcon3 = new ImageIcon(this.getClass().getClassLoader().getResource("PTA3 logo.png"));
			 	logoLabel3 = new JLabel(logoIcon3);
			 	}
			 	
			 	if (language == "Japanese") {
				 	logoIcon3 = new ImageIcon(this.getClass().getClassLoader().getResource("PTA3J logo.png"));
				 	logoLabel3 = new JLabel(logoIcon3);
				 	}
			 	
		  

		
		//GridBagLayout
		//Add GUI Elements to GridBagLayout
		GridBagConstraints gb = new GridBagConstraints();
		
		
		gb.gridy=0;	
		gb.gridx=2;
		gb.insets = new Insets(50,150,0,0);
		add(logoLabel,gb);
		
		if (language == "English") {
		gb.gridy=0;	
		gb.gridx=2;
		gb.insets = new Insets(50,-1750,0,0);
		add(logoLabel2,gb);
		}
		
		if (language == "Japanese") {
			gb.gridy=0;	
			gb.gridx=2;
			gb.insets = new Insets(50,-1890,0,0);
			add(logoLabel2,gb);
			}
		
		gb.gridy=1;	
		gb.gridx=2;
		gb.insets = new Insets(-25,150,0,0);
		add(expandLogoButton,gb);
		
		if (language == "English") {
		gb.gridy=1;	
		gb.gridx=2;
		gb.insets = new Insets(-500,150,0,0);
		add(musicOffButton,gb);
		}
		
		if (language == "Japanese") {
			gb.gridy=1;	
			gb.gridx=2;
			gb.insets = new Insets(-530,175,0,0);
			add(musicOffButton,gb);
			}
		
		if (language == "English") {
		gb.gridy=1;	
		gb.gridx=2;
		gb.insets = new Insets(-25,-1750,0,0);
		add(expandLogoButton2,gb);
		}
		
		if (language == "Japanese") {
			gb.gridy=1;	
			gb.gridx=2;
			gb.insets = new Insets(-25,-1890,0,0);
			add(expandLogoButton2,gb);
			}
		
		if (language == "English") {
		gb.gridy=1;	
		gb.gridx=3;
		gb.insets = new Insets(-500,-2060,0,0);
		add(musicOnButton,gb);
		}
		
		if (language == "Japanese") {
			gb.gridy=1;	
			gb.gridx=3;
			gb.insets = new Insets(-530,-2255,0,0);
			add(musicOnButton,gb);
			}
		


		if (language == "English") {
		gb.gridy=0;	
		gb.gridx=0;
		gb.insets = new Insets(0,300,0,0);
		add(logoLabel3,gb);
		}
		
		if (language == "Japanese") {
			gb.gridy=0;	
			gb.gridx=0;
			gb.insets = new Insets(0,350,0,0);
			add(logoLabel3,gb);
			}
		
		
//		gb.gridx=0;
//		gb.gridy=0;	
//		gb.insets = new Insets(0,225,0,0);
////		gb.weighty = 1;
//		add(titlePanel,gb);
		
		
		
//		gb.gridx=0;
//		gb.gridy=1;			
//		gb.insets = new Insets(-8,0,0,0);
//		add(namesPanel,gb);
		
		
		gb.weighty = 1;
		gb.gridx=0;
		gb.gridy=2;
		if (language == "English") {
		gb.insets = new Insets(-100,300,-90,0);
		}
		if (language == "Japanese") {
			gb.insets = new Insets(-100,350,-90,0);
		}
		add(newGameButton,gb);	
		
		gb.gridx=0;
		gb.gridy=3;
		add(continueButton,gb);
		
		gb.gridx=0;
		gb.gridy=5;
		add(creditsButton,gb);
		
		gb.gridx=0;
		gb.gridy=4;
		add(optionsButton,gb);	
		
		gb.gridx=0;
		gb.gridy=6;
		add(feedbackButton,gb); 
		
		
		 newGameButton.addActionListener(new ActionListener() {
			
			 public void actionPerformed(ActionEvent e) {
				 	
				  if (fromUi == "yes") {
				  clip.stop();
				  }
				  if (musicMain == "on") {
				  clip2.stop();
				  }
					newGame = new NewGame(cl, cards, font, language, textSpeed, stopTimer, buttonWidth,
							buttonHeight, player, rival, professorOakVisited, labOutsideButtonEnable, color);
					 cards.add(newGame, "newgame");
					cl.show(cards, "newgame");
				 
					
	            }
	        });
		 
		 optionsButton.addActionListener(new ActionListener() {
				
			 public void actionPerformed(ActionEvent e) {
				 if (fromUi == "yes") {
					  clip.stop();
					  }
					  if (musicMain == "on") {
					  clip2.stop();
					  }
					options = new Options(cl, cards,"mainscreen", startScreenTextArea, "1",
							false, player, true, language, textSpeed, fullText2, rival, font,
							false, stopTimer, titleSize, buttonWidth, buttonHeight, false,
							professorOakVisited, labOutsideButtonEnable, trainer, 0, color, "");
					cards.add(options, "options");
					cl.show(cards, "options");
					
	            }
	        });
		 
		 feedbackButton.addActionListener(new ActionListener() {
				
			 public void actionPerformed(ActionEvent e) {
				 if (fromUi == "yes") {
					  clip.stop();
					  }
					  if (musicMain == "on") {
					  clip2.stop();
					  }
				 try {
					    Desktop.getDesktop().browse(new URL("https://rahilsagarwala.github.io/Pokemon-Text-Adventure-Feedback/").toURI());
					} catch (Exception ex) {}
					
	            }
	        });
        
		 creditsButton.addActionListener(new ActionListener() {
				
			 public void actionPerformed(ActionEvent e) {
				 if (fromUi == "yes") {
					  clip.stop();
					  }
					  if (musicMain == "on") {
					  clip2.stop();
					  }
				    credits = new Credits(cl, cards, language, font, textSpeed, player, rival, stopTimer, titleSize, 
				 			buttonWidth, buttonHeight, professorOakVisited, labOutsideButtonEnable, color);
				 	cards.add(credits, "trade");
					cl.show(cards, "trade");
					
	            }
	        });
		 
		 expandLogoButton.addActionListener(new ActionListener() {
				
			 public void actionPerformed(ActionEvent e) {
				 if (fromUi == "yes") {
					  clip.stop();
					  }
					  if (musicMain == "on") {
					  clip2.stop();
					  }
				    Logo logo = new Logo(cl, cards, language, font, textSpeed, player, rival, stopTimer, titleSize, 
				 			buttonWidth, buttonHeight, professorOakVisited, labOutsideButtonEnable, color);
				 	cards.add(logo, "logo");
					cl.show(cards, "logo");
					
	            }
	        });
		 
		 expandLogoButton2.addActionListener(new ActionListener() {
				
			 public void actionPerformed(ActionEvent e) {
				 if (fromUi == "yes") {
					  clip.stop();
					  }
					  if (musicMain == "on") {
					  clip2.stop();
					  }
				    Logo2 logo2 = new Logo2(cl, cards, language, font, textSpeed, player, rival, stopTimer, titleSize, 
				 			buttonWidth, buttonHeight, professorOakVisited, labOutsideButtonEnable, color);
				 	cards.add(logo2, "logo2");
					cl.show(cards, "logo2");
					
	            }
	        });
		 
		 continueButton.addActionListener(new ActionListener() {
				
			 public void actionPerformed(ActionEvent e) {
				 if (fromUi == "yes") {
					  clip.stop();
					  }
					  if (musicMain == "on") {
					  clip2.stop();
					  }
				 	continu = new ContinueGame(cl, cards, language, font, textSpeed, player, rival, stopTimer, titleSize, 
				 			buttonWidth, buttonHeight, professorOakVisited, labOutsideButtonEnable, color);
				    cards.add(continu, "continue");
					cl.show(cards, "continue");
					
	            }
	        });
		 
		 musicOffButton.addActionListener(new ActionListener() {
				
			 public void actionPerformed(ActionEvent e) {
				 if (fromUi == "yes") {
					  clip.stop();
					  

					  }
					  if (musicMain == "on") {					  
					  clip2.stop();
					  musicMain = "off";
					  }
				 	
					
	            }
	        });
		 
		 musicOnButton.addActionListener(new ActionListener() {
				
			 public void actionPerformed(ActionEvent e) {

					  if (musicMain == "off") {
						  
					  clip2.start();
					  musicMain = "on";
					  
					  }
					  
					  if (fromUi == "yes") {
						  clip.start();
						  musicMain = "on";

						  }
				 	
					
	            }
	        });
		 
		 
    }



}
 
