package Model.Card_package;

import java.util.ArrayList;

abstract public class Card {
    private static ArrayList<Card> allCards;
    private int price;
    private String ID;
    private int mana;

    protected Card(String ID, int cost, int mana) { //in constructor creating the original card
        this.price = cost;
        this.ID = ID;
        this.mana = mana;
    }

    protected Card(String ID, Card mainCard) {// in constructor : creating card in match mode
        this.ID = ID;
        this.mana = mainCard.mana;
    }

    public String getID(){
        return ID;
    }

    abstract public Card getCopy(String ID);

    public void putCard(int x, int y){
    }


    public boolean equals(Card card){
        return card.getID().equals(this.ID);
    }

    public boolean equals(String cardID){
        return this.ID.equals(cardID);
    }
}
