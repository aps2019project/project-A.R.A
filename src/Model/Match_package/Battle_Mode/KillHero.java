package Model.Match_package.Battle_Mode;

import Model.Match_package.Deck;
import Model.Match_package.Match;
import Model.Match_package.Player;

public class KillHero extends Match {

    public KillHero(){
        super();
    }

    Player checkGame(){
        Deck noUseDeck = new Deck("no use");
        Player winner = new Player(noUseDeck); // todo gonna need to change whole things here;
        return winner;
    }

}
