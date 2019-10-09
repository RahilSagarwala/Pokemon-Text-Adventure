package Trainer;

import java.util.ArrayList;

import javax.swing.JPanel;

import items.*;
import items.Map;
import pokemon.*;

import java.awt.CardLayout;
import java.awt.Font;
import java.io.*; 
import java.util.*; 

public class Player extends TrainerSuper {
	int i;
	CardLayout cl;
	JPanel cards;

	
	
	public Player(String name, ArrayList<ItemSuper> itemArrayList) {
	
		super(name, itemArrayList);
	}
	
	public void showMap(CardLayout cl, JPanel cards, Font font, String screen, String language, int textSpeed, Player player, Rival rival, Boolean stopTimer, String location) {
		Map map = new Map(i);
		map.showMap(cl, cards, font, screen, language, textSpeed, player, rival, stopTimer, location);
		
	}

}
	
