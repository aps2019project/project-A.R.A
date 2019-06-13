package Model.Match_package;

import Exceptions.DuplicateUnitException;
import Exceptions.FullDeckException;
import Exceptions.UnitNotFoundException;
import Model.Card_package.Card;
import Model.Card_package.Hero;
import Model.Item_package.Item;
import Model.Item_package.Usable;
import Model.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private String deckName;
    private ArrayList<Card> allDeckCards = new ArrayList<>();
    private Hero hero;
    private Usable usable;
    private final int MAX_CAPACITY = 20; // 20 otherCards
    private ArrayList<String> IDs = new ArrayList<>();

    public Deck(String name) {
        deckName = name;
    }

    public boolean isValid() {
        return !(hero == null || allDeckCards.size() != MAX_CAPACITY || usable == null);
    }

    public void add(Unit unit) {
        if (unit instanceof Hero) {
            if (hero == null)
                hero = ((Hero) unit);
            else throw new DuplicateUnitException();
        } else if (unit instanceof Card) {
            if (allDeckCards.size() < MAX_CAPACITY) {
                allDeckCards.add(((Card) unit));
            } else throw new FullDeckException();
        } else {
            if (usable == null) {
                usable = ((Usable) unit);
            } else throw new DuplicateUnitException();
        }
    }

    public void setUsable(Usable usable) {
        usable = usable;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Card pullLastCard() {
        if (allDeckCards.size() > 0) {
            Card temp = allDeckCards.get(0);
            deleteCard(temp);
            return temp;
        }
        return null;
    }

    public void deleteCard(Card card) {
        try {
            allDeckCards.remove(card);
        } catch (Exception e) {
            //show Error : card not found in deck
        }
    }

    public void deleteHero() {
        hero = null;
    }

    public void deleteItem() {
        if (usable != null)
            usable = null;
        else {
            //show Error : item not found
        }
    }

    public void deleteUnit(String id) {
        if (!this.hasUnit(id))
            throw new UnitNotFoundException();
        if (hasUsable() && usable.getID().equals(id)) {
            deleteItem();
        } else if (hasHero() && hero.getID().equals(id)) {
            deleteHero();
        } else {
            for (Card card : allDeckCards)
                if (card.getID().equals(id)) {
                    allDeckCards.remove(card);
                    return;
                }
        }
    }

    public Usable getUsable() {
        return usable;
    }

    public void mixCards() {
        Random random = new Random();
        for (int i = 0; i < MAX_CAPACITY; i++)
            Collections.swap(allDeckCards, random.nextInt(MAX_CAPACITY), random.nextInt(MAX_CAPACITY));
    }

    public Deck getCopy(Player player) {
        Deck newDeck = new Deck(deckName);
        newDeck.setUsable((Usable) usable.getCopyForCopyDeck(generateIDFormat(usable, player), player));
        newDeck.setHero((Hero) hero.getCopyForCopyDeck(generateIDFormat(hero, player), player)); // set the new ID in match format for new cards
        for (Card card : allDeckCards)
            newDeck.allDeckCards.add((Card) card.getCopyForCopyDeck(generateIDFormat(card, player), player)); // set the new ID in match format for new cards
        return newDeck;
    }

    private String generateIDFormat(Unit unit, Player player) {
        String string = String.format("%s_%s", player.getName(), unit.getName());
        int counter = 1;
        for (String id : IDs) {
            if (id.contains(string))
                counter++;
        }
        String result = String.format("%s_%d", string, counter);
        IDs.add(result);
        return result;
    }

    public Hero getHero() {
        return hero;
    }

    public String getDeckName() {
        return deckName;
    }

    public ArrayList<Card> getAllDeckCards() {
        return allDeckCards;
    }

    public boolean equals(Deck deck) {
        return deck.deckName.equals(this.deckName);
    }

    public boolean equals(String deckName) {
        return deckName.equals(this.deckName);
    }

    public boolean hasCard(Card card) {
        return allDeckCards.contains(card);
    }

    public boolean hasCard(String ID) {
        for (Card card : allDeckCards) {
            if (card.getID().equals(ID))
                return true;
        }
        if (hero.getID().equals(ID))
            return true;
        return false;
    }

    public boolean hasHero() {
        return hero != null;
    }

    public boolean hasItem(Item item) {
        return item.equals(usable);
    }

    public boolean hasItem(String ID) {
        return (usable != null && usable.getID().equals(ID));
    }

    public boolean hasUnit(String ID) {
        return (hasCard(ID) || hasItem(ID));
    }

    public boolean hasUsable() {
        return !(usable == null);
    }

    public ArrayList<Unit> getAllUnits() {
        ArrayList<Unit> units = new ArrayList<>();
        if (hero != null) units.add(hero);
        if (usable != null) units.add(usable);
        units.addAll(allDeckCards);
        return units;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Hero :  \n");
        stringBuilder.append(hasHero() ? hero.toString() : "");
        stringBuilder.append("Item : \n");
        stringBuilder.append(hasUsable() ? usable.toString() + "\n" : "");
        stringBuilder.append("Cards : \n");
        for (Card card : allDeckCards)
            stringBuilder.append(card.toString() + "\n");
        return stringBuilder.toString();
    }
}
