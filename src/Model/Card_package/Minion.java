package Model.Card_package;

public class Minion extends Force {

    public Minion(String ID, int cost, int mana, int ap, int hp) {
        super(ID, cost, mana, ap, hp);
    }

    public Minion(String ID, Minion mainMinion) {
        super(ID, mainMinion);
    }

    public Minion getCopy(String ID) {
        return new Minion(ID, this);
    }
}
