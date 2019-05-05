package Model.Match_package;

import Account_package.Account;
import Model.Card_package.Card;
import Model.Match_package.Battle_Type.CollectFlag;
import Model.Match_package.Battle_Type.HoldFlag;
import Model.Match_package.Battle_Type.KillHero;
import Model.Match_package.Battle_Type.MatchType;

abstract public class Match {
    public Player ownPlayer;
    public Player opponent;
    public Card selectedCard;
    private Map map  = new Map();
    private int turn = 2;
    int defaultMana = 2;
    private MatchType matchType;

    public Match (Account account){
        ownPlayer = new Player(account.getName(), account.getCollection().getMainDeck());
    }

    public abstract Player checkGame(Player player);

    public void changeTurn() {
        if (turn < 14)
            setDefaultMana(defaultMana + 1);
        ownPlayer.setMana();
        opponent.setMana();
        switchPlayers();
        selectedCard = null;
    } // anything done at the turn change.

    private void switchPlayers(){
        Player temp = ownPlayer;
        ownPlayer = opponent;
        opponent = temp;
    }

    private void setDefaultMana(int num) {
        defaultMana = num;
    }

    protected void setMatchType(MatchType matchType){
        this.matchType = matchType;
    }

    public void addToGraveYard(Player player, Card card) {
        player.graveYard.addToDeadCards(card);
    }

    public Player getCardOwner(Card card){
        if(ownPlayer.hasCard(card))
            return ownPlayer;
        else if (opponent.hasCard(card))
            return opponent;
        else
            return null;
    }

    public Map getMap(){
        return map;
    }

    public MatchType getMatchType(){
        return matchType;
    }

    public void setOwnPlayer(Player player){
        this.ownPlayer = player;
    }

    public void setOpponent(Player player){
        this.opponent = opponent;
    }


}



