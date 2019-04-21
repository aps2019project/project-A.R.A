package Model.Card_package;

public class Hero extends Force {

    public Hero(String ID, int cost, int mana, int ap, int hp) {
        super(ID, cost, mana, ap, hp);
    }

    public Hero(String ID, Hero mainHero) {
        super(ID, mainHero);
    }

    public Hero getCopy(String ID) {
        return new Hero(ID, this);
    }
}
