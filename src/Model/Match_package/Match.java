package Model.Match_package;

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
    private int round = 1;// using turn not considered .
    int defaultMana = 2;
    private static Match matchInstance;

    abstract Player checkGame();

    public void startNewMatch(MatchType matchType) {
        switch(matchType){
            case KILL_HERO:
                matchInstance = new KillHero();
                break;
            case HOLD_FLAG:
                matchInstance = new HoldFlag();
                break;
            case COLLECT_FLAG:
                matchInstance = new CollectFlag();
        }
        // ought to initialize players ;
    }

    public static Match getInstance() {
        return matchInstance;
    }

    public void changeTurn() {
        Player temp = ownPlayer;
        ownPlayer = opponent;
        opponent = temp;
        selectedCard = null;
    }

    protected void changeRound() {
        if (round > 7)
            setDefaultMana(defaultMana + 1);
        changeTurn();
        ownPlayer.setMana();
        opponent.setMana();
    }

    private void setDefaultMana(int num) {
        defaultMana = num;
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

    public void setOwnPlayer(Player player){
        this.ownPlayer = player;
    }

    public void setOpponent(Player player){
        this.opponent = opponent;
    }


}



