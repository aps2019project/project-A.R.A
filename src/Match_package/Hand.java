package Match_package;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> handCards = new ArrayList<>();
    private Card nextCard;

    Hand(ArrayList<Card> cards, Card nextCard) {
        setNextCard(nextCard);
        handCards.addAll(cards);
    }

    public ArrayList<Card> getHandCards() {
        return handCards;
    }

    public void setNextCard(Card card) {
        nextCard = card;
    }

    public void addNextCard() {
        if (nextCard != null)
            handCards.add(nextCard);
        else {
            // do nothing
        }
    }

}
