package Model;

import Exceptions.DeckNotFoundException;
import Exceptions.DuplicateDeckNameException;
import Exceptions.NoDeckExistsException;
import Exceptions.UnitNotFoundException;
import Model.Card_package.Card;
import Model.Card_package.Hero;
import Model.Card_package.Minion;
import Model.Card_package.Spell;
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

    public void setMainDeck(String name) {
        this.mainDeck = getDeck(name);
    }

    public Deck getMainDeck() {
        return mainDeck;
    }

    public void addToDecks(String name) {
        if (hasDeck(name))
            throw new DuplicateDeckNameException();
        decks.add(new Deck(name));
    }

    public void add(Card card) {
        if (!this.hasCard(card))
            allCards.add(card);
    }

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
        throw new DeckNotFoundException();
    }

    public void deleteDeck(Deck deck) {
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

    public Item getItem(String id) {
        for (Item item : items)
            if (item.getID().equals(id))
                return item;
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

    public void deleteCard(Card card) {
        if (this.hasCard(card))
            allCards.remove(card);
        if (card instanceof Hero) {
            for (Deck deck : decks)
                if (deck.getHero().equals(card))
                    deck.deleteHero();
        } else
            for (Deck deck : decks)
                if (hasCard(card))
                    deck.deleteCard(card);
    }

    public void deleteUnit(String id) {
        for (Deck deck : decks)
            deck.deleteUnit(id);
        Card card = getCard(id);
        if (card != null)
            deleteCard(card);
        Item item = getItem(id);
        if (item != null)
            deleteItem(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    void deleteItem(Item item) {
        if (this.hasItem(item))
            items.remove(item);
        for (Deck deck : decks)
            if (hasItem(item))
                deck.deleteItem();
    }

    public void deleteItem(Deck deck, Item item) {
        if (this.hasDeck(deck))
            if (deck.hasItem(item))
                deck.deleteItem();
    }

    public void addItem(Item item) {
        items.add(item);
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

    public Unit get(String id) {
        for (Card card : allCards) {
            if (card.getID().equals(id))
                return card;
        }
        for (Item item : items)
            if (item.getID().equals(id))
                return item;
        throw new UnitNotFoundException();
    }

    public ArrayList<Unit> getUnitsOfType(String type) {
        ArrayList<Unit> resultUnits = new ArrayList<>();
        for (Card card : allCards)
            if (card.getName().equals(type))
                resultUnits.add(card);
        for (Item item : items)
            if (item.getName().equals(type))
                resultUnits.add(item);
        return resultUnits;
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
        StringBuilder stringBuilder = new StringBuilder();
        if (this.containsHero()) {
            stringBuilder.append("Heroes : \n");
            for (Card card : allCards)
                if (card instanceof Hero)
                    stringBuilder.append(((Hero) card).toString() + "--" + card.getID() + "\n");
        }
        if (!items.isEmpty()) {
            stringBuilder.append("Items : \n");
            for (Item item : items)
                stringBuilder.append(item.toString() + "--" + item.getID() + "\n");
        }
        if (this.containsSpell() || this.containsMinion()) {
            stringBuilder.append("Cards : \n");
            for (Card card : allCards)
                if (card instanceof Spell)
                    stringBuilder.append(((Spell) card).toString() + "--" + card.getID() + "\n");
            for (Card card : allCards)
                if (card instanceof Minion)
                    stringBuilder.append(((Minion) card).toString() + "--" + card.getID() + "\n");
        }
        return stringBuilder.toString();
    }

    public String toStringDecksInCollection() {
        StringBuilder stringBuilder = new StringBuilder();
        if (mainDeck != null) {
            stringBuilder.append("Main deck : \n");
            stringBuilder.append(mainDeck.toString() + "\n");
        }
        if (!decks.isEmpty()) {
            for (int i = 0; i < decks.size(); i++) {
                stringBuilder.append(i + " : " + decks.get(i).getDeckName() + "\n");
                stringBuilder.append(decks.get(i).toString() + "\n");
            }
        } else
            throw new NoDeckExistsException();
        return stringBuilder.toString();
    }

    private boolean containsHero() {
        for (Card card : allCards)
            if (card instanceof Hero)
                return true;
        return false;
    }

    private boolean containsMinion() {
        for (Card card : allCards)
            if (card instanceof Minion)
                return true;
        return false;
    }

    private boolean containsSpell() {
        for (Card card : allCards)
            if (card instanceof Spell)
                return true;
        return false;
    }

    public String deckToString(String name) {
        return getDeck(name).toString();
    }

    public ArrayList<Card> getAllCards() {
        return allCards;
    }

    public String toStringInShop() {
        StringBuilder buffer = new StringBuilder("Hero");

        buffer.append("Heroes : \n");
        for (Card card : allCards)
            if (card instanceof Hero)
                buffer.append(((Hero) card).toString() + " Price : " + card.getPrice() * 0.65 + "\n");
        buffer.append("Usables : \n");
        for (Item item : items)
            buffer.append(item.toString() + " Price : " + item.getPrice() * 0.65 + "\n");
        buffer.append("Cards : \n");
        for (Card card : allCards)
            if (card instanceof Spell)
                buffer.append(((Spell) card).toString() + " Price : " + card.getPrice() * 0.65 + "\n");
        for (Card card : allCards)
            if (card instanceof Minion)
                buffer.append(((Minion) card).toString() + " Price : " + card.getPrice() * 0.65 + "\n");
        return buffer.toString();
    }
}
