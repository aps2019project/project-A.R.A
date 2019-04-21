package Model;

import Model.Card_package.Card;
import Model.Match_package.Deck;

import java.util.ArrayList;

public class Collection {
    private ArrayList<Card> allCards = new ArrayList<>();
    private ArrayList<Deck> decks = new ArrayList<>();
    private Deck mainDeck;

    public Collection() {
    }

    public Collection(ArrayList<Card> allCards, ArrayList<Deck> decks, Deck mainDeck) {
        this.allCards = allCards;
        this.decks = decks;
        this.mainDeck = mainDeck;
    }

    public void setMainDeck(Deck mainDeck) {
        this.mainDeck = mainDeck;
    }

    public Deck getMainDeck() {
        return mainDeck;
    }

    public Collection add(Card card) {
        if (!allCards.contains(card))
            allCards.add(card);
        else {
            // show error : prevent to loose money for a repetetive card
            //ought to set one or 2 steps before this.
        }
        return this;
    }

    public boolean checkDeckvalidity() {
        if (mainDeck != null)
            return mainDeck.isValid();
        else {
            // show error: got no main deck
            return false;
        }
    }

    public boolean checkDeckValidity(Deck deck) {
        if (deck == null) {
            // show error : deck بهم ندادی
            return false;
        } else if (decks.contains(deck))
            return deck.isValid();
        else
            return false;
    }

    public boolean checkDeckValidity(String deckName) {
        for (Deck deck : decks)
            if (deck.equals(deckName))
                return deck.isValid();
        return false; // not an available deck in collection;
    }

    public Card getCard(String cardID) {
        for (Card card : allCards)
            if (card.equals(cardID))
                return card;
        return null; // show error card not found.
    }

    public Collection addCardToDeck(Deck deck, Card card) {
        if (!decks.contains(deck))
            return null;
        else {
            deck.addToCards(card);
            return this;
        }
    }

    public boolean hasDeck(Deck deck){
        return decks.contains(deck);
    }
}
