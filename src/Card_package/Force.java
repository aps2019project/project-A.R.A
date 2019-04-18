package Card_package;

abstract public class Force extends Card {


    protected Force(String ID, int cost, int mana) {
        super(ID, cost, mana);
    }
    protected Force(String ID, Force mainForce) {
        super(ID, mainForce);
    }
}
