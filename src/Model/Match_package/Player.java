package Model.Match_package;

import Model.Card_package.Card;
import Model.Card_package.Force;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> allPlayerCards = new ArrayList<>();
    protected Hand hand;
    protected Deck deck;
    protected GraveYard graveYard = new GraveYard();
    private int mana;

    public Player(Deck deck) {
        this.deck = deck.getCopy();
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

    public void moveCard(Coordination coordination){
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

    public void normalAttack(Coordination coordination){

    }

    public void setAllPlayerCards(){
        allPlayerCards.add(deck.getHero());
        allPlayerCards.addAll(hand.getHandCards());
        allPlayerCards.add(hand.getNextCard());
        allPlayerCards.addAll(deck.getAllDeckCards());
    }

    public void setMana(){
        mana = Match.getInstance().defaultMana;
    }

    public boolean hasCard(Card card){
        return allPlayerCards.contains(card);
    }
    public boolean isManaEnoughFor(Card card) {
        if (mana >= card.getMana())
            return true;
        return false;
    }
}
