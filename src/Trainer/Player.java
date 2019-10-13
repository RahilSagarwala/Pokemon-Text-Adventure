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

	
	
	public Player(String name, ArrayList<ItemSuper> itemArrayList, ArrayList<PokemonSuper> partyPokemonArrayList) {
	
		super(name, itemArrayList, partyPokemonArrayList);
	}

}
	
