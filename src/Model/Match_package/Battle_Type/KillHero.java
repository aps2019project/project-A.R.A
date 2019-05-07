package Model.Match_package.Battle_Type;

import Account_package.Account;
import Model.Match_package.Deck;
import Model.Match_package.Match;
import Model.Match_package.Player;

public class KillHero extends Match {

    public KillHero(Account account){
        super(account); // todo surely something else to do
        setMatchType(MatchType.KILL_HERO);
    }
//
//    public Player IsWinner(Player player){
//        Deck noUseDeck = new Deck("no use");
//        Player winner = new Player("name",noUseDeck); // todo gonna need to change whole things here;
//        return winner;
//    }

}
