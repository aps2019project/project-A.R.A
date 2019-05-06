package Menus.Cammands.Collection_Commands;

import Exceptions.*;
import Menus.Buffer;
import Menus.Cammands.Command;
import Model.Card_package.Card;
import Model.Card_package.Hero;
import Model.Collection;
import Model.Item_package.Item;
import Model.Item_package.Usable;
import Model.Match_package.Deck;

public class AddToDeck extends Command {
    public AddToDeck() {
        super("add (\\w+) to deck (\\w+)");
    }

    public void execute() {
        Collection collection = Buffer.getBufferCollection();
        Deck deck = collection.getDeck(matcher.group(2));
        if (!collection.hasUnit(matcher.group(1)))
            throw new UnitNotFoundException();
        if (deck.hasUnit(matcher.group(1)))
            throw new DuplicateUnitException();
        if (collection.getCard(matcher.group(1)) == null) {
            if (deck.hasUsable())
                throw new EnoughUnitExistsException();
            deck.setUsable((((Usable) collection.get(matcher.group(1)))));
        } else {
            Card card = collection.getCard(matcher.group(1)); // surely is'nt null. // uses Id
            if (card instanceof Hero) {
                if (deck.hasHero())
                    throw new DuplicateHeroCardException();
                else
                    deck.setHero(((Hero) card));
            } else {
                if (deck.getAllDeckCards().size() == 20)
                    throw new FullDeckException();
                else
                    deck.addToCards(card);
            }
        }
    }
}
