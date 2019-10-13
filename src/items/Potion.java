package items;
import pokemon.*;

public class Potion extends ItemSuper {

	public Potion(int count) {
		super(count);
		englishName = "Potion";
		japaneseName = "";
	}
	
	public void usePotion(PokemonSuper pokemon) {
		//Make sure Pokemon has not fainted, potion has no effect on fainted Pokemon
		if (pokemon.getHp() > 0) {
		int newHp = pokemon.getHp() + 20;
		pokemon.setHp(newHp);
		}
		else {
			return;
		}
		
	}

}
