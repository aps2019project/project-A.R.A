package Model;

import Exceptions.DeckNotFoundException;
import Exceptions.DuplicateDeckNameException;
import Exceptions.NoDeckExistsException;
import Exceptions.UnitNotFoundException;
import Model.Card_package.Card;
import Model.Card_package.Hero;
import Model.Card_package.Minion;
import Model.Card_package.Spell;
import Model.Card_package.usable.Usable;
import Model.Match_package.Deck;
import Model.Card_package.Item;

import java.util.ArrayList;

public class Collection {
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<Deck> decks = new ArrayList<>();
    private ArrayList<Usable> usAbles = new ArrayList<>();
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


    public void add(Unit unit) {
        if (unit instanceof Usable) {
            usAbles.add((Usable)(unit));
        }
        else if (unit instanceof Card)
            cards.add((Card)unit);
    }



    public void addToDeck(String deckName, String unitName){
        Unit unit = get(unitName);
        Deck deck = getDeck(deckName);
        deck.add(unit);
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
        for (Card card : cards)
            if (card.getID().equals(cardID))
                return card;
        return null; // show error card not found.
    }

    public Item getItem(String id) {
        for (Item item : usAbles)
            if (item.getID().equals(id))
                return item;
        return null; // show error card not found.
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
        return cards.contains(card);
    }

    public boolean hasCard(String id) {
        for (Card card : cards)
            if (card.getID().equals(id))
                return true;

        return false;
    }

    public boolean hasCardOfType(String type) {
        for (Card card : cards)
            if (card.getName().equals(type))
                return true;
        return false;
    }

    public void deleteCard(Card card) {
        if (this.hasCard(card))
            cards.remove(card);
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

    public ArrayList<Usable> getUsAbles() {
        return usAbles;
    }

    void deleteItem(Item item) {
        if (this.hasItem(item))
            usAbles.remove(item);
        for (Deck deck : decks)
            if (hasItem(item))
                deck.deleteItem();
    }

    public void deleteItem(Deck deck, Item item) {
        if (this.hasDeck(deck))
            if (deck.hasItem(item))
                deck.deleteItem();
    }

    void addCard(Card card) {
        cards.add(card);
    }
    private boolean hasItem(Item item) {
        return usAbles.contains(item);
    }

    private boolean hasItemOfType(String type) {
        for (Item item : usAbles)
            if (item.getName().equals(type))
                return true;
        return false;
    }

    public boolean hasUnit(String type) {
        return (this.hasItemOfType(type) || this.hasCardOfType(type));
    }

    public Unit get(String name) {
        for (Card card : cards) {
            if (card.getName().equals(name))
                return card;
        }
        for (Usable usable : usAbles)
            if (usable.getName().equals(name))
                return usable;
        throw new UnitNotFoundException();
    }

    public ArrayList<Unit> getUnitsOfType(UnitType type) {
        ArrayList<Unit> resultUnits = new ArrayList<>();
        if(type.equals(UnitType.ITEM)) {
            resultUnits.addAll(usAbles);
            return resultUnits;
        }
        for (Card card : cards) {
            if ((card instanceof Hero && type.equals(UnitType.HERO)) || (card instanceof Minion && type.equals(UnitType.MINION)) || (card instanceof Spell && type.equals(UnitType.SPELL)))
                resultUnits.add(card);
        }
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
            for (Card card : cards)
                if (card instanceof Hero)
                    stringBuilder.append(((Hero) card).toString() + "--" + card.getID() + "\n");
        }
        if (!usAbles.isEmpty()) {
            stringBuilder.append("Items : \n");
            for (Item item : usAbles)
                stringBuilder.append(item.toString() + "--" + item.getID() + "\n");
        }
        if (this.containsSpell() || this.containsMinion()) {
            stringBuilder.append("Cards : \n");
            for (Card card : cards)
                if (card instanceof Spell)
                    stringBuilder.append(((Spell) card).toString() + "--" + card.getID() + "\n");
            for (Card card : cards)
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
        for (Card card : cards)
            if (card instanceof Hero)
                return true;
        return false;
    }

    private boolean containsMinion() {
        for (Card card : cards)
            if (card instanceof Minion)
                return true;
        return false;
    }

    private boolean containsSpell() {
        for (Card card : cards)
            if (card instanceof Spell)
                return true;
        return false;
    }

    public String deckToString(String name) {
        return getDeck(name).toString();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public String toStringInShop() {
        StringBuilder buffer = new StringBuilder("Hero");

        buffer.append("Heroes : \n");
        for (Card card : cards)
            if (card instanceof Hero)
                buffer.append(((Hero) card).toString() + " Price : " + card.getPrice() * 0.65 + "\n");
        buffer.append("Usables : \n");
        for (Item item : usAbles)
            buffer.append(item.toString() + " Price : " + item.getPrice() * 0.65 + "\n");
        buffer.append("Cards : \n");
        for (Card card : cards)
            if (card instanceof Spell)
                buffer.append(((Spell) card).toString() + " Price : " + card.getPrice() * 0.65 + "\n");
        for (Card card : cards)
            if (card instanceof Minion)
                buffer.append(((Minion) card).toString() + " Price : " + card.getPrice() * 0.65 + "\n");
        return buffer.toString();
    }

    public ArrayList<Deck> getDecks(){
        return decks;
    }


}
