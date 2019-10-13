package pokemon;

import java.util.ArrayList;
import attacks.AttackSuper;

public class Squirtle extends PokemonSuper {
	
	public Squirtle (ArrayList<AttackSuper> attackArrayList, int level, int experience, int hp,
			int attack, int defense, int spattack, int spdefense) {
	    super(attackArrayList, level, experience, hp, attack, defense, spattack, spdefense);
		englishName = "Squirtle";
		japaneseName = "ゼニガメ";
		type = "water";
		hp = 20;
//		attackArrayList.add()
//		attackArrayList.add()
	}

}
