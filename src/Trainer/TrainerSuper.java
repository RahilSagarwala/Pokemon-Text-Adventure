package Trainer;

import items.*;
import pokemon.*;
import java.io.*; 
import java.util.*; 

public class TrainerSuper {
	String name = "";
	String language;
	int money;
	ArrayList<ItemSuper> itemArrayList = new ArrayList<ItemSuper>(100);
	ArrayList<PokemonSuper> partyPokemonArrayList = new ArrayList<PokemonSuper>(6);
	

	public TrainerSuper() {
		
	}
	
	public int getMoney() {
		return money;
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
	
	public String getItemNames(String language) {
	
		
		return itemArrayList.get(0).getItemName(language);

	}
	

	
	
	public ArrayList<ItemSuper> getItems() {

		return itemArrayList;

	}

	public String getPartyPokemonNames(String language) {
	
		
		return partyPokemonArrayList.get(0).getPokemonName(language);

	}
	
	public ArrayList<PokemonSuper> getPartyPokemonArrayList() {

		return partyPokemonArrayList;

	}
	
	public void addPokemonToParty(PokemonSuper pokemon) {
		partyPokemonArrayList.add(pokemon);
	}
	
	
	
	//Need to add Pokemon to 1 of 12 boxes that hold 30 Pokemon each
	public void addPokemonToBox(PokemonSuper pokemon) {
		
	}
	
	
}
