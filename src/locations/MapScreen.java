package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import Trainer.Player;
import Trainer.Rival;

public class MapScreen extends JPanel {
	
	CardLayout cl;
	JPanel cards;
	Font font;
	String screen, language, location;
	Boolean stopTimer, professorOakVisited, labOutsideButtonEnable;
	Player player;
	int textSpeed;
	Rival rival;
	ImageIcon mapIcon;
	JLabel mapLabel;
	
	public MapScreen(final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, Rival rival, Boolean stopTimer, String location2, Boolean professorOakVisited, Boolean labOutsideButtonEnable) {
		 this.cl = layout;
	     this.cards = cards;
	     this.font = font;
	     this.screen = screen;
	     this.language = language;
	     this.textSpeed = textSpeed;
	     this.player = player;
	     this.rival = rival;
	     this.stopTimer = stopTimer;
	     this.location = location2;
	     this.labOutsideButtonEnable=labOutsideButtonEnable;
	     
	     
	     setBackground(Color.black);
	     setLayout(new GridBagLayout());
	     GridBagConstraints gb = new GridBagConstraints();
	     
	     
	     JButton returnButton = new JButton ("Return");
	     returnButton.setPreferredSize(new Dimension(150,75));
		 returnButton.setBackground(Color.DARK_GRAY);
		 returnButton.setForeground(Color.cyan);
		 returnButton.setFont(font);
		 
		 if (language == "Japanese") {
	    	 returnButton.setText("とじる");
	     }
		 
		 mapIcon = new ImageIcon(this.getClass().getClassLoader().getResource("map.jpg"));
		 mapLabel = new JLabel(mapIcon);
		 
		 JLabel label1 = new JLabel();
		 label1.setFont(font);
		 label1.setForeground(Color.cyan);
	 
		 gb.gridx=1;
	     gb.gridy=0;
	     gb.weighty = 1;
		 add(returnButton, gb);
		 gb.gridx=1;
	     gb.gridy=2;
		 add(mapLabel, gb);
		 
		 returnButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {  		
         		
	            	Inventory inventory = new Inventory(cl, cards, font, "", language, textSpeed,
	            			player, rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable);
	            	cards.add(inventory, "inventory");
	                layout.show(cards, "inventory");
         	  
	            	
	            }
	        });   
	     
	}

}
 
