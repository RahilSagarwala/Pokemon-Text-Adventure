package Trainer;

import items.*;
import pokemon.*;
import java.io.*; 
import java.util.*;

import javax.swing.JButton; 

public class TrainerSuper {
	String name = "";
	String language;
	int money;
	int level;
	//ArrayList<PokemonToBox> pokemon = new ArrayList<PokemonToBox>(30);
	ArrayList<ItemSuper> itemArrayList = new ArrayList<ItemSuper>(100);
	ArrayList<PokemonSuper> partyPokemonArrayList = new ArrayList<PokemonSuper>(6);
	
	

	public TrainerSuper() {
		
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int newMoney) {
		money = newMoney;
	}
	
	
	public String getName () {	
		
		return name;	
	}
	
	
	public void setName(String name2) {
		name = name2;
	}
	
	public void addItem(ItemSuper item) {
		itemArrayList.add(item);
	}
	
	public void removeItems () {
		for (int i = 0; i<itemArrayList.size(); i++) {
			if(itemArrayList.get(i).getCount() == 0) {
				itemArrayList.remove(i);
			}
		}
	}
	
	public String getItemNames(String language) {
	
		
		return itemArrayList.get(0).getItemName(language);

	}
	

	
	
	public ArrayList<ItemSuper> getItems() {

		return itemArrayList;

	}

	public String getPartyPokemonName1(String language) {
	
		
		return partyPokemonArrayList.get(0).getPokemonName(language);

	}
	
	public ArrayList<PokemonSuper> getPartyPokemonArrayList() {

		return partyPokemonArrayList;

	}
	
	public void addPokemonToParty(PokemonSuper pokemon) {
		partyPokemonArrayList.add(pokemon);
	}
	
	
	public void setLevel(int level) { 
		this.level = level; 
	}
	
	//Need to add Pokemon to 1 of 12 boxes that hold 30 Pokemon each
	//public void addPokemonToBox(PokemonToBox p) { 
	//	pokemon.add(p); 
	//}
	
	//Need to remove Pokemon
	//public void removePokemonToBox(PokemonToBox p) {
	//	pokemon.remove(p);}
	
}
