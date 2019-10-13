package pokemon;

import java.util.ArrayList;
import attacks.AttackSuper;

public class Bulbasaur extends PokemonSuper {
	//Bulbasaur is a grass type pokemon
	
	public Bulbasaur(ArrayList<AttackSuper> attackArrayList, int level, int experience, int hp,
			int attack, int defense, int spattack, int spdefense) {
	    super(attackArrayList, level, experience, hp, attack, defense, spattack, spdefense);
		englishName = "Bulbasaur";
		japaneseName = "フシギダネ";
		type = "grass";
		hp = 20;
//		attackArrayList.add()
//		attackArrayList.add()
	}

}
