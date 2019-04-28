package Model.Card_package;

import Model.Match_package.Cell;
import Model.Match_package.Coordination;
import Model.Match_package.Player;

import java.util.ArrayList;

abstract public class Card {
    private static ArrayList<Card> cards;

    private String name;
    private String ID;
    private int cost;
    private int mana;
    private Player player;


    protected Card(String name, String ID, int cost, int mana) {
        this.name = name;
        this.ID = ID;
        this.cost = cost;
        this.mana = mana;
        this.player = null;
    }
    protected Card(Card mainCard, Player player) {
        this(mainCard.name, mainCard.ID, mainCard.cost, mainCard.mana);
        this.player = player;
    }

    public boolean canPut(Coordination coordination){
        if (player.isManaEnoughFor(this))
            return true;
        return false;
    }

    public int getMana(){
        return mana;
    }

    public boolean isTeammate(Card card) {
        if (this.player == card.player)
            return true;
        return false;
    }






}
