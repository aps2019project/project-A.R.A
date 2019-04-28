package Model.Card_package;

import Model.Match_package.Coordination;
import Model.Match_package.Player;
import Model.Unit;

import java.util.ArrayList;

abstract public class Card extends Unit {
    private static ArrayList<Card> cards;

    protected Player owner;

    protected Card(String ID, int price, int mana) { //in constructor baraye sakhtan card asli mibashad
        super(ID, price, mana);
    }

    protected Card(String ID, int mana){
        super(ID, mana);
    }

    public static ArrayList<Card> getCards() {
        return cards;
    }

    protected Card(String ID, Card mainCard) {// in constructor baraye sakhtan card dar match mibashad
        super(ID, mainCard.getMana());
    }

    public Player getPlayer() {
        return owner;
    }

    abstract public Card getCopy(String ID);

    abstract public boolean canPutCard(Coordination coordination);

    abstract public void putCard(Coordination coordination);

    public boolean isTeammate(Card card) {
        if (this.owner == card.owner)
            return true;
        return false;
    }

    public void setOwner(Player owner){
        this.owner = owner;
    }
}