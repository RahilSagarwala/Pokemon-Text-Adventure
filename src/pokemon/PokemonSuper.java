package pokemon;

import java.util.ArrayList;
import java.util.Random;

import items.ItemSuper;
import attacks.*;

public class PokemonSuper {
	String englishName;
	String japaneseName;
	String russianName;
	String language;
	String englishType, japaneseType, englishType2, japaneseType2, owner, number, englishSpecies,japaneseSpecies, 
	englishHeight, englishWeight, 
	japaneseHeight, japaneseWeight, englishPokedex, japanesePokedex;
	int level, experience, hp, attack, defense, special, speed, maxHp, id;
	double catchRate, ecounterRate;
	ArrayList<AttackSuper> attackArrayList = new ArrayList<AttackSuper>(4);
	String location, englishStatus, japaneseStatus;
	Random random = new Random();
	
	public PokemonSuper(String location) {	
		this.location = location;
	}
	
	public void generateStats() {
		//Random stats based upon level
		if (level == 5) {
			int randomHp = 15 + random.nextInt(5);
			maxHp = randomHp;
			int randomAttack = 8 + random.nextInt(4);
			attack = randomAttack;
			int randomDefense = 8 + random.nextInt(4);
			defense = randomDefense;
			int randomSpecial = 8 + random.nextInt(4);
			special = randomSpecial;
			int randomSpeed = 8 + random.nextInt(4);
			speed = randomSpeed;
			
		}
		
		hp = maxHp;
		
		//For testing 
//		hp = maxHp - 10;
	} 
	
	
	
	public void generateId() {
		 Random random = new Random();
		 id = Math.abs(random.nextInt());
	}
	
	public void generateOwner(String newOwner) {
		owner = newOwner;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getHeight(String theLanguage) {
		if (theLanguage == "English") {
			return englishHeight;
		}
		
		else {
			return japaneseHeight;
		}
	}
	
	public String getweight(String theLanguage) {
		if (theLanguage == "English") {
			return englishWeight;
		}
		
		else {
			return japaneseWeight;
		}
	}
	
	public String getSpecies(String theLanguage) {
		if (theLanguage == "English") {
			return englishSpecies;
		}
		
		else {
			return japaneseSpecies;
		}
	}
	
	public String getPokedex(String theLanguage) {
		if (theLanguage == "English") {
			return englishPokedex;
		}
		
		else {
			return japanesePokedex;
		}
	}
	
	
	public String getStatus(String theLanguage) {
		if (theLanguage == "English") {
			return englishStatus;
		}
		
		else {
			return japaneseStatus;
		}
	}
	
	public void setStatus(String newEnglishStatus, String newJapaneseStatus) {
		englishStatus = newEnglishStatus;
		japaneseStatus = newJapaneseStatus;
		
	}
	
	public String getOwner() {
		return owner;
	}
	
	public int getExperience() {
		return experience;
	}
	
	public String getType(String theLanguage) {
		if (theLanguage == "English") {
			return englishType;
		}
		
		else {
			return japaneseType;
		}
	}
	
	public String getType2(String theLanguage) {
		if (theLanguage == "English") {
			return englishType2;
		}
		
		else {
			return japaneseType2;
		}
	}
	
	
	public ArrayList<AttackSuper> getAttacks() {
		return attackArrayList;
	}
	
	public void setAttacks(AttackSuper attack) {
		if(attackArrayList.size() < 4) {
		attackArrayList.add(attack);
		}
		else {
			//Remove an attack and add another attack
			return;
		}
	}
	
	
	public String getPokemonName(String theLanguage) {
		if (theLanguage == "English") {
			return englishName;
		}
		else if (theLanguage == "Japanese") {
			return japaneseName;
		}
		else {
			return russianName;
		}
		
	}
	
	public void setPokemonName(String name) {
		englishName = name;
		japaneseName = name;
		russianName = name;
	}
	
	public int getMaxHp() {
		return maxHp;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void setHp(int newHp) {
		hp = newHp;
	}
	
	public void setAttack (int newAttack) {
		attack = newAttack;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public void setDefense (int newDefense) {
		defense = newDefense;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public void setSpecial (int newSpecial) {
		special = newSpecial;
	}
	
	public int getSpecial() {
		return special;
	}
	
	public void setSpeed (int newSpeed) {
		speed = newSpeed;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setLevel (int newLevel) {
		level = newLevel;
	}
	
	public int getLevel() {
		return level;
	}
	
}
