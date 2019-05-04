package Model.Card_package;

import Model.Match_package.Coordination;
import Model.Match_package.Player;
import Model.Unit;

import java.util.ArrayList;

abstract public class Card extends Unit {
    private static ArrayList<Card> cards;

    private Player owner;

    protected Card(String name, String ID, int cost, int mana) {
        super(name, ID, cost, mana);
        this.owner = null;
    }//for make a card

    protected Card(Card mainCard, Player player, String ID) {
        super(mainCard.getName(), ID, mainCard.getPrice(), mainCard.getMana());
        this.owner = player;
    }//for copy a card

    public boolean canPut(Coordination coordination){
        if (owner.hasEnoughManaFor(this))
            return true;
        return false;
    }

    public boolean isTeammate(Card card) {
        if (this.owner == card.owner)
            return true;
        return false;
    }

    public Player getPlayer(){
        return owner;
    }

}
