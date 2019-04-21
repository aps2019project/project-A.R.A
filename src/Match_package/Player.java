package Match_package;

import Card_package.Card;

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
    public boolean isManaEnoughFor(Card card) {
        if (mana >= card.getMana())
            return true;
        return false;
    }
}
