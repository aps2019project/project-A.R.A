package Model.Match_package;

import Account_package.Account;
import Account_package.MatchResult;
import Account_package.MatchResultType;
import Exceptions.*;
import Menus.GameMode;
import Model.Card_package.Card;
import Model.Card_package.Force;
import Model.Card_package.Spell;
import Model.Item_package.Collectable;
import Model.Match_package.Battle_Type.MatchType;

abstract public class Match {
    private Player ownPlayer;
    private Player opponent;
    private Card selectedCard;
    private Map map = new Map();
    private int turn = 1;
    private MatchType matchType;

    public Match(Account account) {
        ownPlayer = new Player(account.getName(), account.getCollection().getMainDeck());
    }


    public abstract Player checkGame(Player player);

    public void changeTurn() {
        //handle mana
        ownPlayer.setMana();
        opponent.setMana();
        switchPlayers();
        selectedCard = null;
    } // anything done at the turn change.

    private void switchPlayers() {
        Player temp = ownPlayer;
        ownPlayer = opponent;
        opponent = temp;
    }

    protected void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    public void addToGraveYard(Card card) {
        card.getPlayer().getGraveYard().addToDeadCards(card);
    }

    public Player getCardOwner(Card card) {
        return card.getPlayer();
    }

    public Map getMap() {
        return map;
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

    public void setSelectedCard(String id) throws UnitNotFoundException {
        for (Force force : map.getForcesInMap(ownPlayer))
            if (force.getID() == id) {
                selectedCard = force;
                return;
            }
        for (Card card : ownPlayer.getHand().getShowAbleCards())
            if (card.getID() == id) {
                selectedCard = card;
                return;
            }
        throw new UnitNotFoundException();
    }
    // sets selected card or throw a particular exception

    public Player getOwnPlayer() {
        return ownPlayer;
    }

    public Player getOpponent() {
        return opponent;
    }

    public Card getSelectedCard() {
        if (selectedCard == null)
            throw new NoSelectCardException();
        return selectedCard;
    }

    public void insert(String id, int x, int y) { // always gets
        Card card = ownPlayer.getHand().getCard(id);

        if (ownPlayer.getMana()<card.getMana())
            throw new NotEnoughManaException();

        Cell cell = map.getCell(x, y);

        if (cell.hasItem() || cell.hasCard())
            throw new FullCellException();

        cell.setCard(card);
        ownPlayer.reduceMana(card.getMana());
        //todo something missed me unable to figure out
    }

    public void setWinner(Player winnerPlayer, Player loserPlayer, GameMode mode) {
        Account winner = Account.findAccound(winnerPlayer.getName());
        Account loser = Account.findAccound(loserPlayer.getName());
        if (mode.equals(GameMode.MULTI_PLAYER)) {
            winner.earn(1000);
            loser.pay(1000); // todo money to come to game not checked
        }
        winner.addToMatchHistory(new MatchResult(loser, MatchResultType.WON));
        loser.addToMatchHistory(new MatchResult(winner, MatchResultType.LOST));
    }

    // todo create method
    public void move(Card card, int x, int y) {
        map.move(card, x, y);
    }

    @Override // TODO TODO TODO TODO TODO TODO
    public String toString(){
        StringBuilder buffer = new StringBuilder("Game mode : ");
//        buffer.append()
        return null;
    }
}



