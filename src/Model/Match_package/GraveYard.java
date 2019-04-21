package Model.Match_package;

import Model.Card_package.Card;

import java.util.ArrayList;

class GraveYard {
    // ought to change word Object with word Card
    private ArrayList<Card> deadCards = new ArrayList<>();

    public void addToDeadCards(Card card){
        deadCards.add(card);
    }

    public ArrayList<Card> getDeadCards(){
        Sort.cards(deadCards);
        return deadCards;
    }
}
