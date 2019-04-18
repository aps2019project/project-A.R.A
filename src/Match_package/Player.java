package Match_package;

public class Player {
    protected Hand hand;
    protected Deck deck;
    protected GraveYard graveYard;
    private int mana;
    Player(Deck deck){

    }
    public int getMana() {
        return mana;
    }
}
