package Model.Match_package;

import Model.Card_package.Card;
import Model.Card_package.Hero;
import Model.Card_package.Minion;
import Model.Card_package.Spell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GraveYard {
    // ought to change word Object with word Card
    private ArrayList<Card> deadCards = new ArrayList<>();

    public void addToDeadCards(Card card) {
        deadCards.add(card);
    }

    public ArrayList<Card> getDeadCards() {
        Collections.sort(deadCards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                int o1Priority = getTypeValue(o1);
                int o2Priority = getTypeValue(o2);
                return o1Priority - o2Priority;
            }
        });
        return deadCards;
    }

    private static int getTypeValue(Card card) {
        if (card instanceof Hero)
            return 1;
        if (card instanceof Minion)
            return 2;
        if (card instanceof Spell)
            return 3;
        return 0; // not possible
    }

    public Card getCard(String id) {
        for (Card card : deadCards)
            if (card.getID().equals(id))
                return card;
        return null;//show error.
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (Card card : deadCards) {
            buffer.append(card.toString());
        }
        return buffer.toString();
    }
}
