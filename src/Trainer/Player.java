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
	int badgeNumber = 0;

	
	public Player() {
		money = 0;	
	}
	
	public int getBadeNumber() {
		return badgeNumber;
	}
	
	public void incrementBadgeNumber() {
		badgeNumber++;
	}

}
	
