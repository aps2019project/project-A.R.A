package Match_package;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> allDeckCards = new ArrayList<>();
    private Hero hero;
    private Item usable;
    public final int MAX_CAPACITY = 20; // hero + 20 otherCards

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

    public Card getLastCard(){
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

    public int getRemainedCards(){
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

    }
}
