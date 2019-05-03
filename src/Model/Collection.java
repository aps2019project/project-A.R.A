package Model;

import Model.Card_package.Card;
import Model.Match_package.Deck;
import Model.Item_package.Item;

import java.util.ArrayList;

public class Collection {
    private ArrayList<Card> allCards = new ArrayList<>();
    private ArrayList<Deck> decks = new ArrayList<>();
    public ArrayList<Item> items = new ArrayList<>();
    private Deck mainDeck;

    public Collection() {
    }

    public void setMainDeck(Deck mainDeck) {
        this.mainDeck = mainDeck;
    }

    public Deck getMainDeck() {
        return mainDeck;
    }

    public void addToDecks(Deck deck){
        decks.add(deck);
    }

    public Collection add(Card card) {
        if (!this.hasCard(card))
            allCards.add(card);
        else {
            // show error : prevent to loose money for a repetitive card
            //ought to set one or 2 steps before this.
        }
        return this;
    } // adds card to collection

    public boolean checkDeckValidity() {
        if (mainDeck != null)
            return mainDeck.isValid();
        else {
            // show error: got no main deck
            return false;
        }
    }  // checks main deck

    public boolean checkDeckValidity(Deck deck) {
        if (deck == null) {
            // show error : deck بهم ندادی
            return false;
        } else if (this.hasDeck(deck))
            return deck.isValid();
        else
            return false;
    }

    public Deck getDeck(String deckName) {
        for (Deck deck : decks)
            if (deck.getDeckName().equals(deckName))
                return deck;
        return null;
    }

    public void deleteDeck(Deck deck){
        decks.remove(deck);
    }

    public boolean checkDeckValidity(String deckName) {
        for (Deck deck : decks)
            if (deck.equals(deckName))
                return checkDeckValidity(deck);
        return false; // not an available deck in collection;
    }

    public Card getCard(String cardID) {
        for (Card card : allCards)
            if (card.getID().equals(cardID))
                return card;
        return null; // show error card not found.
    }

    public Collection addCardToDeck(Deck deck, Card card) {
        if (!this.hasDeck(deck))
            return null; // show error
        else {
            deck.addToCards(card);
            return this;
        }
    }

    public boolean hasDeck(Deck deck) {
        return decks.contains(deck);
    }

    public boolean hasDeck(String deckName) {
        for (Deck deck : decks)
            if (deck.getDeckName().equals(deckName))
                return true;
        return false;
    }

    public boolean hasCard(Card card) {
        return allCards.contains(card);
    }

    public boolean hasCard(String id) {
        for (Card card : allCards)
            if (card.getID().equals(id))
                return true;

        return false;
    }

    public boolean hasCardOfType(String type) {
        for (Card card : allCards)
            if (card.getName().equals(type))
                return true;
        return false;
    }

    public Collection deleteCard(Card card) {
        if (this.hasCard(card))
            allCards.remove(card); // deck cards not considered to be deleted
        return this;
    }

    public Collection deleteCard(Card card, Deck deck) {
        if (this.hasDeck(deck))
            if (deck.hasCard(card))
                deck.deleteCard(card);
        return this;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void deleteItem(Item item) {
        if (this.hasItem(item))
            items.remove(item); // deck items not considered
    }

    public void deleteItem(Deck deck, Item item) {
        if (this.hasDeck(deck))
            if (deck.hasItem(item))
                deck.deleteItem();
    }

    public Collection addItem(Item item) {
        items.add(item);
        return this;
    }

    public boolean hasItem(Item item) {
        return items.contains(item);
    }

    public boolean hasItem(String ID) {
        for (Item item : items)
            if (item.getID().equals(ID))
                return true;
        return false;
    }

    public boolean hasItemOfType(String type) {
        for (Item item : items)
            if (item.getName().equals(type))
                return true;
        return false;
    }

    public boolean hasUnit(String ID) {
        return (this.hasItem(ID) || this.hasCard(ID));
    }

    public boolean hasUnitOfType(String type) {
        return (this.hasItemOfType(type) || this.hasCardOfType(type));
    }

    public Unit get(String ID) {
        for (Card card : allCards)
            if (card.getID().equals(ID))
                return card;
        for (Item item : items)
            if (item.getID().equals(ID))
                return item;
        return null;// error
    }

    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder();
        int counter = 1;
        for (Deck deck : decks) {
            buff.append(counter++ + "- " + deck.getDeckName() +
                    " : Hero -> " + deck.getHero().getName() + " -- " + (deck.isValid() ? "Ready\n" : "Not Ready\n"));
        }
        return buff.toString();
    }

    public String toStringInCollection() {
        return "particular string depends on Abolfazl's job"; // todo adjust surely
    }
}
