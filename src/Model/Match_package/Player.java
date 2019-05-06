package Model.Match_package;

import Exceptions.NotEnoughManaException;
import Exceptions.UnitNotFoundException;
import Menus.MenuManager;
import Model.Card_package.Card;
import Model.Card_package.Force;
import Model.Item_package.Collectable;
import View.ShowType;

import java.util.ArrayList;

public class Player {
    public String name;
    private ArrayList<Card> allPlayerCards = new ArrayList<>();
    private Hand hand;
    protected Deck deck;
    private GraveYard graveYard;
    private ArrayList<Collectable> collectables = new ArrayList<>();
    private int mana;


    public Player(String name, Deck deck) {
        this.name = name;
        this.deck = deck.getCopy(this);
        graveYard = new GraveYard();
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            cards.add(deck.pullLastCard());
        hand = new Hand(cards, deck.pullLastCard());
        setAllPlayerCards();
        setMana();
    }

    public void putCard(Card card, Coordination c) {
//        // x & y : 0 , 1, 2, ...
//
//        if (!hand.hasCard(card)) {
//            // show Error Card notFound
//        } else {
//            hand.setCardAsOnGround(card, deck.pullLastCard());
//            if (!Match.getInstance().getMap().cells[c.getX()][c.getY()].hasCard())
//                Match.getInstance().getMap().cells[c.getX()][c.getY()].setCard(card);
//            else {
//                // show error : cell is full
//            }
//        }

        // badan dorost shavad
    }

    public void moveCard(Coordination coordination) {
        // assumed as 0, 1, 2, ...
        //considered that there is a selected card
        // move limitation (default as 2) not considered

//        Cell cell = Match.getInstance().getMap().findPosition(Match.getInstance().selectedCard);
//        if(cell != null){
////            if(Match.getInstance().checkPath())            -- >  // todo checking the path and set a correct way to present cells
//            cell.deleteCard();
//            Cell newPosition = Match.getInstance().getMap().getCell(coordination); // x and y be in range not considered
//            newPosition.setCard(Match.getInstance().selectedCard);
//        }
//        else{
//            // show error card not in the battle field , although it is not possible
//        }
        //todo
    }

    public void normalAttack(Coordination coordination) {

    }

    public void setAllPlayerCards() {
        allPlayerCards.add(deck.getHero());
        allPlayerCards.addAll(hand.getHandCards());
        allPlayerCards.add(hand.getNextCard());
        allPlayerCards.addAll(deck.getAllDeckCards());
    }

    public ArrayList<Card> getAllPlayerCards() {
        return allPlayerCards;
    }

    public Hand getHand() {
        return hand;
    }

    public GraveYard getGraveYard() {
        return graveYard;
    }

    public void setMana() {
        mana = MenuManager.getCurrentMatch().defaultMana;
    }

    public boolean hasCard(Card card) {
        return allPlayerCards.contains(card);
    }

    public Card getCard(String id) throws UnitNotFoundException {
        for (Card card : allPlayerCards)
            if (card.getID().equals(id))
                return card;
        throw new UnitNotFoundException();
    }

    public boolean hasEnoughManaFor(Card card) {
        if (mana >= card.getMana())
            return true;
        return false;
    }

    public void addCollectable(Collectable collectable) {
        collectables.add(collectable);
    }/* todo also need to get overrided to
    todo perform by taking collectable ID.*/

    public ArrayList<Collectable> getCollectables() {
        return collectables;
    }

    public String toString(ShowType showType) {
        switch (showType) {
            case COLLECTABLES:
                return collectableToString();
            case CARDS:
                return cardsToString();
            default:
                return null;
        }
    }

    private String collectableToString() {
        StringBuilder stringBuilder = new StringBuilder("Collectables : \n");
        for (Collectable collectable : collectables)
            stringBuilder.append("- " + collectable.toString() + "\n");
        return stringBuilder.toString();
    }

    private String cardsToString() {
        return "to be handled";
    }

    public Collectable getCollectable(String id) throws UnitNotFoundException{
        for(Collectable collectable:collectables)
            if(collectable.getID().equals(id))
                return collectable;
            throw new UnitNotFoundException();
    }

    public int getMana() {
        return mana;
    }

    public void reduceMana(int amount){
        if(amount>mana)
            throw new NotEnoughManaException();
        mana-=amount;
    }

    public String getName() {
        return name;
    }

    public Deck getDeck() {
        return deck;
    }
}
