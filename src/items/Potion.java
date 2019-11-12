package items;
import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JPanel;

import Trainer.Player;
import Trainer.Rival;
import Trainer.TrainerSuper;
import locations.MapScreen;
import locations.PartyPokemon;
import pokemon.*;

public class Potion extends ItemSuper {

	public Potion(int count) {
		super(count);
		englishName = "Potion";
		japaneseName = "キズぐすり";
	}
	
	public void showPartyPokemon(CardLayout cl, JPanel cards, Font font, String screen, String language, int textSpeed, Player player, Rival rival, Boolean stopTimer, String location, Boolean professorOakVisited,
			Boolean labOutsideButtonEnable, TrainerSuper trainer, int battleScreenText, String englishName, String japaneseName,
			int itemIndex, String color, String previousLocation) {
		PartyPokemon partyPokemon = new PartyPokemon(cl, cards, font, "", language, textSpeed,
    			player, rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable,
    			trainer, battleScreenText, "potion", itemIndex, color, previousLocation);
    	cards.add(partyPokemon, "partypokemon");
        cl.show(cards, "partypokemon");
	}
	
	public void usePotion(PokemonSuper pokemon) {
		//Make sure Pokemon has not fainted, potion has no effect on fainted Pokemon
		if (pokemon.getHp() > 0) {
		int newHp = pokemon.getHp() + 20;
		pokemon.setHp(newHp);
		if (pokemon.getHp() > pokemon.getMaxHp()) {
			pokemon.setHp(pokemon.getMaxHp());
		}
		}
		else {
			return;
		}
		
	}

}
