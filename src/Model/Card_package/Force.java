package Model.Card_package;

import Model.Match_package.Buff;

import java.util.ArrayList;

abstract public class Force extends Card {
    protected ArrayList<Buff> continuousBuffs = new ArrayList<>();
    protected ArrayList<Buff> continualBuffs = new ArrayList<>();

    protected Force(String ID, int cost, int mana) {
        super(ID, cost, mana);
    }

    protected Force(String ID, Force mainForce) {
        super(ID, mainForce);
    }
}
