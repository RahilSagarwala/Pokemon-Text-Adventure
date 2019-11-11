package pokemon;

import java.util.ArrayList;
import attacks.*;

public class Charmander extends PokemonSuper {
	//Charmander is a Fire-type Pokémon
	
	public Charmander(String location) {
		super(location);
		englishName = "Charmander";
		japaneseName = "ヒトカゲ";
		russianName = "Чармандер";
		englishType = "Fire";
		japaneseType = "ほのお";
		level = 5;
		number = "004";
		englishStatus = "OK";
		japaneseStatus = "ふつう";
		englishSpecies = "LIZARD";
		japaneseSpecies = "とかげポケモン";
		englishHeight = "HT    2' 00" + "\"";
		englishWeight = "WT    19.0lb";
		japaneseHeight = "たかさ　　　　0.6m";
		japaneseWeight = "おもさ　　　　8.5kg";
		englishPokedex = "Obviously prefers hot places." + "\n" + "When it rains, steam is" + "\n" + 
		"said to spout from the tip" + "\n" + "of its tail";
		japanesePokedex = "うまれたときから　しっぽに　ほのおが" + "\n" + "ともっている。　ほのおが　きえたとき　その" + "\n" + "いのちは　おわって　しまう。";
		
		Scratch scratch = new Scratch(35);
		attackArrayList.add(scratch);
		Leer leer = new Leer(35);
		attackArrayList.add(leer);
	}

}
