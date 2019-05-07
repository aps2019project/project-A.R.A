package Model.Match_package;

import Account_package.Account;
import Account_package.MatchResult;
import Account_package.MatchResultType;
import Exceptions.*;
import Menus.GameMode;
import Model.Card_package.Card;
import Model.Card_package.Force;
import Model.Item_package.Collectable;
import Model.Match_package.Battle_Type.MatchType;
import Model.Match_package.Battle_Type.SelectedCardPosition;

abstract public class Match {
    private Player ownPlayer;
    private Player opponent;
    private Map map = new Map();
    private int turn = 1;
    private MatchType matchType;

    public Match(Account account) {
        ownPlayer = new Player(account.getName(), account.getCollection().getMainDeck());
    }


//    protected void checkGame()

    public void changeTurn() {
        //handle mana
//        ownPlayer.setMana();
//        opponent.setMana();
        switchPlayers();
        ownPlayer.setSelectedCard(null, null);
    } // anything done at the turn change.



    public void addToGraveYard(Card card) {
        card.getPlayer().getGraveYard().addToDeadCards(card);
    }


    public Map getMap() {
        return map;
    }



    public void setSelectedCollectable(String id) throws UnitNotFoundException {
        for (Collectable collectable : ownPlayer.getCollectables()) {
            if (collectable.getID() == id) {
                ownPlayer.setSelectedCollectable(collectable);
                return;
            }
        }
        throw new UnitNotFoundException();
    }

    public void setSelectedCard(String id) throws UnitNotFoundException {
        for (Force force : map.getForcesInMap(ownPlayer))
            if (force.getID().equals(id)) {
                ownPlayer.setSelectedCard(force, SelectedCardPosition.IN_MAP);
                return;
            }
        for (Card card : ownPlayer.getHand().getShowAbleCards())
            if (card.getID().equals(id)) {
                ownPlayer.setSelectedCard(card, SelectedCardPosition.IN_HAND);
                return;
            }
        throw new UnitNotFoundException();
    }
    // sets selected card or throw a particular exception



    public void insert(String id, int x, int y) { // always gets
//        Card card = ownPlayer.getHand().getCard(id);
//
//        if (ownPlayer.getMana()<card.getMana())
//            throw new NotEnoughManaException();
//
//        Cell cell = map.getCell(x, y);
//
//        if (cell.hasItem() || cell.hasCard())
//            throw new FullCellException();
//
//        cell.setCard(card);
//        ownPlayer.reduceMana(card.getMana());
//        //todo something missed me unable to figure out
    } // commented


    // todo create method
    public void move(int x, int y) {
//        map.move(card, x, y);
    }
    public int getTurn() {
        return turn;
    }

    public Player getCardOwner(Card card) {
        return card.getPlayer();
    }

    protected void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    private void switchPlayers() {
        Player temp = ownPlayer;
        ownPlayer = opponent;
        opponent = temp;
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public void setOwnPlayer(Player player) {
        this.ownPlayer = player;
    }

    public void setOpponent(Player player) {
        this.opponent = opponent;
    }

    public Player getOwnPlayer() {
        return ownPlayer;
    }

    public Player getOpponent() {
        return opponent;
    }

    public void setWinner(Player winnerPlayer, Player loserPlayer, GameMode mode) {
        Account winner = Account.findAccount(winnerPlayer.getName());
        Account loser = Account.findAccount(loserPlayer.getName());
        if (mode.equals(GameMode.MULTI_PLAYER)) {
            winner.earn(1000);
            loser.pay(1000); // todo money to come to game not checked
        }
        winner.addToMatchHistory(new MatchResult(loser, MatchResultType.WON));
        loser.addToMatchHistory(new MatchResult(winner, MatchResultType.LOST));
    }

    @Override // TODO TODO TODO TODO TODO TODO
    public String toString(){
        StringBuilder buffer = new StringBuilder("Game mode : ");
//        buffer.append()
        return null;
    }
}