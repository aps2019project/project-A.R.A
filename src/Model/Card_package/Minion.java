package Model.Card_package;

public class Minion extends Force {

    public Minion(String ID, int cost, int mana) {
        super(ID, cost, mana);
    }
    public Minion(String ID, Minion mainMinion) {
        super(ID, mainMinion);
    }

    public Minion getCopy(String ID) {
        return new Minion(ID, this);
    }
}
