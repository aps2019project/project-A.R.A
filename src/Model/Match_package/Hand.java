package Model.Match_package;

import Model.Card_package.Card;

import java.util.ArrayList;
import java.util.Random;

public class Hand {
    private ArrayList<Card> hiddenCards = new ArrayList<>();
    private ArrayList<Card> showAbleCards = new ArrayList<>();

    Hand(ArrayList<Card> cards) {
        int index;
        Random random = new Random();
        while (cards.size() > 0) {
            index = random.nextInt(cards.size());
            hiddenCards.add(cards.get(index));
            cards.remove(index);
        }
        for (int i = 0; i < 5; i++) {
            showAbleCards.add(hiddenCards.get(0));
            hiddenCards.remove(0);
        }
    }

    public ArrayList<Card> getShowAbleCards() {
        return showAbleCards;
    }

    public Card getNextCard(){
        if (hiddenCards.size() > 0)
            return hiddenCards.get(0);
        return null;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("Hand Cards : \n");
        for(Card card: showAbleCards)
            stringBuilder.append(" - " + card.getID() + "\n");
        if (hiddenCards.size() > 0)
            stringBuilder.append("Next card : " + hiddenCards.get(0).getID());
        else
            stringBuilder.append("Next card : not found");
        return stringBuilder.toString();
    }
}
