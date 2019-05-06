package Model.Match_package;

import Model.Card_package.Card;

import java.util.ArrayList;

public class GraveYard {
    // ought to change word Object with word Card
    private ArrayList<Card> deadCards = new ArrayList<>();

    public void addToDeadCards(Card card) {
        deadCards.add(card);
    }

    public ArrayList<Card> getDeadCards() {
        Sort.cards(deadCards);
        return deadCards;
    }

    public Card getCard(String id) {
        for (Card card : deadCards)
            if (card.getID().equals(id))
                return card;
        return null;//show error.
    }

    public String toString() {
        return "grave yard Not handled ";
    }
}
