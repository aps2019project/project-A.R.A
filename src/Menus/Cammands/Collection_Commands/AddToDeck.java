package Menus.Cammands.Collection_Commands;

import Exceptions.*;
import Menus.Buffer;
import Menus.Cammands.Command;
import Model.Card_package.Card;
import Model.Card_package.Hero;
import Model.Collection;
import Model.Item_package.Item;
import Model.Match_package.Deck;

public class AddToDeck extends Command {
    public AddToDeck() {
        super("add (\\w+) to deck (\\w)");
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
            deck.setUsable(((Item) collection.get(matcher.group(1))));
        } else {
            Card card = collection.getCard(matcher.group(1)); // surely is'nt null.
            if (card instanceof Hero) {
                if ((deck.getHero() != null))
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
