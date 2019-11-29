package pokemon;

import java.util.ArrayList;
//import attacks.Attacks;

import attacks.AttackSuper;
import attacks.Growl;
import attacks.Tackle;

public class Bulbasaur extends PokemonSuper {
	//Bulbasaur is a dual-type Grass/Poison Pokémon
	
	public Bulbasaur(String location) {
		super(location);
		englishName = "Bulbasaur";
		japaneseName = "フシギダネ";
		russianName = "Бульбазавр";
		englishType = "Grass";
		japaneseType = "くさ";
		englishType2 = "Poison";
		japaneseType2 = "どく";
		level = 5;
		number = "001";
		englishStatus = "OK";
		japaneseStatus = "ふつう";
		englishSpecies = "SEED";
		japaneseSpecies = "たねポケモン";
		englishHeight = "HT    2' 04" + "\"";
		englishWeight = "WT    15.0lb";
		japaneseHeight = "たかさ　　　　0.7m";
		japaneseWeight = "おもさ　　　　6.9kg";
		englishPokedex = "A strange seed was planted on" + "\n" + "its back at birth. The plant" + "\n" + 
		"sprouts and grows with this POKEMON";
		japanesePokedex = "うまれたときから　せなかに　しょくぶつの"+"\n" + "チタネガ　あって　すこしづつ"+"\n"+"おおきく　そだつ。　";
		Tackle tackle = new Tackle(35);
		attackArrayList.add(tackle);
		Growl growl = new Growl(35);
		attackArrayList.add(growl);
	}

}
