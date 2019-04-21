package Model.Match_package;

import Model.Card_package.Card;
import Model.Card_package.Hero;
import Model.Card_package.Minion;
import Model.Card_package.Spell;

import java.util.ArrayList;
import java.util.Collections;

public class Sort{

    static void cards(ArrayList<Card> cards) {
        for(int i = 0; i<cards.size()-1; i++)
            for(int j = i+1; j<cards.size(); j++){
                if(comparePriority(cards.get(i), cards.get(j))<0)
                    Collections.swap(cards, i, j);
            }
    }

    private static int comparePriority(Card a, Card b) {
        int aPriority = getTypeValue(a);
        int bPriority = getTypeValue(b);
        if (aPriority != bPriority)
            return bPriority - aPriority;
        else {
            return 0;
            // or go to next priority
        }
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

}
