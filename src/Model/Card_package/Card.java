package Model.Card_package;

import java.util.ArrayList;

abstract public class Card {
    private static ArrayList<Card> cards;

    private int cost;
    private String ID;
    private int mana;


    protected Card(String ID, int cost, int mana) { //in constructor baraye sakhtan card asli mibashad
        this.cost = cost;
        this.ID = ID;
        this.mana = mana;
    }

    protected Card(String ID, Card mainCard) {// in constructor baraye sakhtan card dar match mibashad
        this.ID = ID;
        this.mana = mainCard.mana;
    }

    abstract public Card getCopy(String ID);

    public void putCard(int x, int y) {

    }

    public boolean isManaEnough(){
        return true; // not complete yet;
    }
}
