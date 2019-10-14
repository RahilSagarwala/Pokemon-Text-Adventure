package mainGame;

import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import locations.StartScreen;
import Trainer.Player;
import Trainer.Rival;


public class MainGame extends JPanel {

    JPanel cards, namesPanel, titlePanel, frontBoxPanel, backBoxPanel, logoPanel, mainScreenPanel;
    JButton feedbackButton, newGameButton, continueButton, creditsButton, optionsButton;
    JLabel namesLabel, titleLabel, logoLabel;
	Font titleFont, italicFont = new Font("SANS_SERIF", Font.ITALIC, 25), 
			buttonFont = new Font("SANS_SERIF", Font.BOLD, 10), font;
	final static String mainScreenString = "mainscreen";
    CardLayout cl;
    Options options;
    Trade trade;
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
    ImageIcon logoIcon;
    
    
    
    public MainGame(final CardLayout layout, final JPanel cards, Font font, 
    		String language, int textSpeed, Boolean stopTimer, Float titleSize, int buttonWidth, int buttonHeight, 
    		Player player, Rival rival, Boolean professorOakVisited, Boolean labOutsideButtonEnable) {
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
	    
	   
    	
	    setLayout(new GridBagLayout());
        setBackground(Color.black); 
     

         
        //Title Font
        if (language == "English") {
    	try {
		    titleFont = Font.createFont(Font.TRUETYPE_FONT, 
		            this.getClass().getClassLoader().getResourceAsStream("PokemonHollow.ttf")).deriveFont(titleSize);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    ge.registerFont(titleFont);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
        }
        else {
        	try {
    		    titleFont = Font.createFont(Font.TRUETYPE_FONT, 
    		            this.getClass().getClassLoader().getResourceAsStream("japanesetitle.otf")).deriveFont(65f);
    		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    		    ge.registerFont(titleFont);
    		} catch (IOException e) {
    		    e.printStackTrace();
    		} catch(FontFormatException e) {
    		    e.printStackTrace();
    		}
        }
    	
    	//Create GUI
		titlePanel = new JPanel();
		titlePanel.setBackground(Color.black);
		titleLabel = new JLabel();
		titleLabel = new JLabel("Pokémon Text Adventure ");
		titleLabel.setForeground(Color.LIGHT_GRAY);
		titleLabel.setFont(titleFont);	
		titlePanel.add(titleLabel);


		
		namesPanel = new JPanel();
		namesPanel.setLayout(new BorderLayout());
		namesPanel.setBackground(Color.black);
		namesLabel = new JLabel("By: Rahil Sagarwala, Gary Ray, Chad Mendenhall, and Luis Siavchay");
		namesLabel.setForeground(Color.LIGHT_GRAY);
		namesLabel.setFont(italicFont);
		namesPanel.add(namesLabel);
		
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//	    this.setSize(screenSize.width, screenSize.height);
		
		
		
		
		newGameButton = new JButton("New Game");
		newGameButton.setBackground(Color.DARK_GRAY);
		newGameButton.setForeground(Color.cyan);
		newGameButton.setFont(font);
		
		
		continueButton = new JButton("Continue");
		continueButton.setBackground(Color.DARK_GRAY);
		continueButton.setForeground(Color.cyan);
		continueButton.setFont(font);
		
		creditsButton = new JButton("Credits");
		creditsButton.setBackground(Color.DARK_GRAY);
		creditsButton.setForeground(Color.cyan);
		creditsButton.setFont(font);
	
		
		optionsButton = new JButton("Options");
		optionsButton.setBackground(Color.DARK_GRAY);
		optionsButton.setForeground(Color.cyan);
		optionsButton.setFont(font);
		
		
		feedbackButton = new JButton("Feedback");
		feedbackButton.setBackground(Color.DARK_GRAY);
		feedbackButton.setForeground(Color.cyan);
		feedbackButton.setFont(font);
		
		
		feedbackButton.setPreferredSize(new Dimension(400,100));
		newGameButton.setPreferredSize(new Dimension(400,100));
		continueButton.setPreferredSize(new Dimension(400,100));
		creditsButton.setPreferredSize(new Dimension(400,100));
		optionsButton.setPreferredSize(new Dimension(400,80));
		
		 if(language == "Japanese") {
			 feedbackButton.setText("フィードバック");
			 newGameButton.setText("さいしょからはじめる");
			 continueButton.setText("つづきからはじめる");
			 creditsButton.setText("エンドクレジット");
			 optionsButton.setText("せっていを かえる");
			 titleLabel.setText("<html>ポケットモンスターテキスト<br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp アドベンチャー<html>");
	
				feedbackButton.setPreferredSize(new Dimension(400,100));
				newGameButton.setPreferredSize(new Dimension(400,100));
				continueButton.setPreferredSize(new Dimension(400,100));
				creditsButton.setPreferredSize(new Dimension(400,100));
				optionsButton.setPreferredSize(new Dimension(400,100));
		 }
		
		

		logoIcon = new ImageIcon(this.getClass().getClassLoader().getResource("logo4.png"));
		 logoLabel = new JLabel(logoIcon);
		  

		
		//GridBagLayout
		//Add GUI Elements to GridBagLayout
		GridBagConstraints gb = new GridBagConstraints();
		
		
		gb.gridy=0;	
		gb.gridx=2;
		gb.insets = new Insets(0,80,0,0);
		add(logoLabel,gb);

		gb.insets = new Insets(0,225,0,0);	
		gb.gridx=0;
		gb.gridy=0;	
//		gb.weighty = 1;
		add(titlePanel,gb);
		
		
		
//		gb.gridx=0;
//		gb.gridy=1;			
//		gb.insets = new Insets(-8,0,0,0);
//		add(namesPanel,gb);
		
//		gb.weighty = 1;
		gb.gridx=0;
		gb.gridy=2;
		gb.insets = new Insets(0,300,0,0);
//		gb.insets = new Insets(-75,0,0,0);
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
				
				 
					newGame = new NewGame(cl, cards, font, language, textSpeed, stopTimer, buttonWidth,
							buttonHeight, player, rival, professorOakVisited, labOutsideButtonEnable);
					 cards.add(newGame, "newgame");
					cl.show(cards, "newgame");
				 
					
	            }
	        });
		 
		 optionsButton.addActionListener(new ActionListener() {
				
			 public void actionPerformed(ActionEvent e) {
					options = new Options(cl, cards,"mainscreen", startScreenTextArea, "1",
							false, player, true, language, textSpeed, fullText2, rival, font,
							false, stopTimer, titleSize, buttonWidth, buttonHeight, false, professorOakVisited, labOutsideButtonEnable);
					cards.add(options, "options");
					cl.show(cards, "options");
					
	            }
	        });
		 
		 feedbackButton.addActionListener(new ActionListener() {
				
			 public void actionPerformed(ActionEvent e) {
				 try {
					    Desktop.getDesktop().browse(new URL("http://rsagarwala.infprojects.fhsu.edu/PokemonTextAdventure/").toURI());
					} catch (Exception ex) {}
					
	            }
	        });
        
		 creditsButton.addActionListener(new ActionListener() {
				
			 public void actionPerformed(ActionEvent e) {
				    trade = new Trade(cl, cards, language, font, textSpeed, player, rival, stopTimer, titleSize, 
				 			buttonWidth, buttonHeight, professorOakVisited, labOutsideButtonEnable);
				 	cards.add(trade, "trade");
					cl.show(cards, "trade");
					
	            }
	        });
		 
		 continueButton.addActionListener(new ActionListener() {
				
			 public void actionPerformed(ActionEvent e) {
				 	continu = new ContinueGame(cl, cards, language, font, textSpeed, player, rival, stopTimer, titleSize, 
				 			buttonWidth, buttonHeight, professorOakVisited, labOutsideButtonEnable);
				    cards.add(continu, "continue");
					cl.show(cards, "continue");
					
	            }
	        });
		 
		 
    }



}
 
