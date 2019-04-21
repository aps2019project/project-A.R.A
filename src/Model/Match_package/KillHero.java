package Model.Match_package;

public class KillHero extends Match {

    KillHero(){
        super();
    }

    Player checkGame(){
        Deck noUseDeck = new Deck("no use");
        Player winner = new Player(noUseDeck); // todo gonna need to change whole things here;
        return winner;
    }

}
