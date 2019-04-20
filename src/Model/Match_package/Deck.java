package Model.Match_package;

import Model.Card_package.Card;
import Model.Card_package.Hero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private String deckName;
    private ArrayList<Card> allDeckCards = new ArrayList<>();
    private Hero hero;
    private Item usable;
    private final int MAX_CAPACITY = 20; // 20 otherCards

    Deck(String name){
        deckName = name;
    }

    public boolean isValid(){
        if(hero == null || allDeckCards.size() != MAX_CAPACITY || usable == null)
            return false;
        return true;
    }

    public Deck addToCards(Card card){
        if(allDeckCards.size()<MAX_CAPACITY){
            allDeckCards.add(card);
        }
        else{
            //show Error : deck cards are already completed
        }
        return this;
    }

    public void setUsable(Item item){
        usable = item;
    }

    public void setHero(Hero hero){
        this.hero = hero;
    }

    public Card pullLastCard(){
        if(allDeckCards.size()>0) {
            Card temp = allDeckCards.get(0);
            deleteCard(temp);
            return temp;
        }
        return null;
    }

    public Deck deleteCard(Card card){
        try{
            allDeckCards.remove(card);
        }catch (Exception e){
            //show Error : card not found in deck
        }
        return this;
    }

    public int getNumOfRemainedCards(){
        return allDeckCards.size();
    }

    public void deleteItem(){
        if(usable != null)
            usable = null;
        else {
            //show Error : item not found
        }
    }

    public void mixCards(){
        Random random = new Random();
        for(int i = 0; i<MAX_CAPACITY; i++)
            Collections.swap(allDeckCards, random.nextInt(MAX_CAPACITY), random.nextInt(MAX_CAPACITY));
    }

    public Deck getCopy(){
        Deck newDeck = new Deck(deckName);
        newDeck.setUsable(this.usable.getCopy());
        newDeck.setHero(this.hero.getCopy(hero.getID())); // set the same ID for new cards
        for(Card card: allDeckCards)
            newDeck.allDeckCards.add(card.getCopy(card.getID())); // set the same ID for new cards
        return newDeck;
    }

    public Hero  getHero(){
        return hero;
    }

    public ArrayList<Card> getAllDeckCards(){
        return allDeckCards;
    }

    public boolean equals(Deck deck){
        return deck.deckName.equals(this.deckName);
    }

    public boolean equals(String deckName){
        return deckName.equals(this.deckName);
    }
}