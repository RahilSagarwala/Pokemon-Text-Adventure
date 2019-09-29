package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import Trainer.Player;
import Trainer.Rival;

public class PalletTownYourHouse extends JPanel {
	
	CardLayout cl;
	JPanel cards;
	Font textAreaFont;
	String screen, language, location;
	Boolean stopTimer;
	Player player;
	int textSpeed;
	Rival rival;
	JButton locationButton, talktoMomButton;
	JLabel locationLabel;
	
	public PalletTownYourHouse(final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, Rival rival, Boolean stopTimer, String location2) {
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
	     
	     
	     setBackground(Color.black);
	     setLayout(new GridBagLayout());
	     GridBagConstraints gb = new GridBagConstraints();
	     
	     locationLabel = new JLabel();
		 locationLabel.setForeground(Color.LIGHT_GRAY);
		 locationLabel.setFont(font);
	     
	     JButton talkToMomButton = new JButton();
	     talkToMomButton.setPreferredSize(new Dimension(225,75));
	     talkToMomButton.setBackground(Color.DARK_GRAY);
	     talkToMomButton.setForeground(Color.cyan);
	     talkToMomButton.setFont(font);
	     
	     JButton goOutsideButton = new JButton();
	     goOutsideButton.setPreferredSize(new Dimension(200,75));
	     goOutsideButton.setBackground(Color.DARK_GRAY);
	     goOutsideButton.setForeground(Color.cyan);
	     goOutsideButton.setFont(font);
	     
	     JButton playSnesButton = new JButton();
	     playSnesButton.setPreferredSize(new Dimension(200,75));
	     playSnesButton.setBackground(Color.DARK_GRAY);
	     playSnesButton.setForeground(Color.cyan);
	     playSnesButton.setFont(font);
	     
	     JButton watchTvButton = new JButton();
	     watchTvButton.setPreferredSize(new Dimension(200,75));
	     watchTvButton.setBackground(Color.DARK_GRAY);
	     watchTvButton.setForeground(Color.cyan);
	     watchTvButton.setFont(font);
	     
	     JButton menuButton = new JButton();
	     menuButton.setPreferredSize(new Dimension(200,75));
	     menuButton.setBackground(Color.DARK_GRAY);
	     menuButton.setForeground(Color.cyan);
	     menuButton.setFont(font);
	     
	     if (language == "English") {
	    	 locationLabel.setText("<html> Location: <br> My House <html>");
	    	 talkToMomButton.setText("Talk to Mom");
	    	 goOutsideButton.setText("Go Outside");
	    	 playSnesButton.setText("Play SNES");
	    	 watchTvButton.setText("Watch TV");
	    	 menuButton.setText("Menu");
	        	
	     }
	     
	     else {
	    	 locationLabel.setText("<html>ロケーション :<br> わたしのうち<html>");
	    	 talkToMomButton.setText("ははとはなす");
	    	 goOutsideButton.setText("そとにいく");
	    	 playSnesButton.setText("<html>スーパーファミコン<br>をする<html>");
	    	 watchTvButton.setText("てれびおみる");
	    	 menuButton.setText("メニユー");
	    	 playSnesButton.setPreferredSize(new Dimension(325,100));
	    	 watchTvButton.setPreferredSize(new Dimension(225,75));
	    	 
	     }
		 
	    //column 1
		 gb.gridx = 0;
		 gb.gridy = 2;
		 gb.weightx = 1;
		 add(watchTvButton, gb);
		
		 
	     
	     
	     //column 2
		 gb.gridx = 1;
		 gb.gridy = 0;
		 gb.weighty =1;
		 gb.insets = new Insets(0,0,78,0);
		 add(menuButton, gb);
		 
		 gb.gridx = 1;
		 gb.gridy = 1;
		 add(talkToMomButton, gb);
		 
		 gb.gridx = 1;
		 gb.gridy = 2;
		 add(locationLabel, gb);
		 
		 gb.gridx = 1;
		 gb.gridy = 3;
		 add(goOutsideButton, gb);
		 
		 //column 3
		 gb.gridx = 2;
		 gb.gridy = 2;
		 add(playSnesButton, gb);
		 
		 talkToMomButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
            	
//	                cards.add(ss, "startscreen");
//	                layout.show(cards, "startscreen");  	                
	            }
	        });
		 
		 watchTvButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {

	            	
	            }
	        });
		 
		 playSnesButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {

	            	
	            }
	        });
		 
		 goOutsideButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {

	            	
	            }
	        });
		 
		 menuButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {

	            	
	            }
	        });
		 
		 
	     
	     
	}

}
 
