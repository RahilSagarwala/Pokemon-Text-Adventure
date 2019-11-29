// written by: Rahil Sagarwala 
// tested by: Rahil Sagarwala 
// debugged by: Rahil Sagarwala and Luis Siavichay

package pokemon;

import java.util.ArrayList;
//import attacks.Attacks;

import attacks.Growl;
import attacks.Tackle;
import attacks.TailWhip;

public class Squirtle extends PokemonSuper {
	//Squirtle is a Water-type Pokémon
	
	public Squirtle (String location) {
		super(location);
		englishName = "Squirtle";
		japaneseName = "ゼニガメ";
		russianName = "Сквиртл";
		englishType = "Water";
		japaneseType = "みず";
		level = 5;
		number = "007";
		englishStatus = "OK";
		japaneseStatus = "ふつう";
		englishSpecies = "TINYTURTLE";
		japaneseSpecies = "かめのこポケモン";
		englishHeight = "HT    1' 08" + "\"";
		englishWeight = "WT    20lb";
		japaneseHeight = "たかさ　　　　0.5m";
		japaneseWeight = "おもさ　　　　9.0kg";
		englishPokedex = "After birth, its back" + "\n" + "swells and hardens into a" + "\n" + "shell. Powerfully sprays foam"
				+ "\n" + "from its mouth";
		japanesePokedex = "ばがい　くびを　こうちのなかに　ひっこめるとき" + "\n" + "いきおいよく　みずでっぽうを　はっしゃする。";

		Tackle tackle = new Tackle(35);
		attackArrayList.add(tackle);
		TailWhip tailWhip = new TailWhip(35);
		attackArrayList.add(tailWhip);
	}

}
