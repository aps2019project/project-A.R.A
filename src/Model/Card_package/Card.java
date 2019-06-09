package Model.Card_package;

import Model.Match_package.Coordination;
import Model.Match_package.Player;
import Model.Unit;

import java.util.ArrayList;

abstract public class Card extends Unit {


    protected Card(String name, int price, int mana, String desc, Player player) {
        super(name, price, mana, desc, player);
    }


    public boolean canPut(Coordination coordination) {
        return (getPlayer().hasEnoughManaFor(this));
    }

    public boolean isTeammate(Card card) {
        if (this.getPlayer() == card.getPlayer())
            return true;
        return false;
    }
}
