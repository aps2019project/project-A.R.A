package Menus.Cammands.CollectionCommands;

import Exceptions.DeckNotFoundException;
import Exceptions.UnitNotFoundException;
import Menus.Buffer;
import Menus.Cammands.Command;
import Model.Card_package.Card;
import Model.Card_package.Hero;
import Model.Item_package.Item;
import Model.Match_package.Deck;
import Model.Unit;

public class RemoveFromDeck extends Command {
    public RemoveFromDeck() {
        super("remove (\\w+) from deck (\\w+)");
    }

    public void execute() {
        Deck deck = Buffer.getBufferCollection().getDeck(matcher.group(2));
        if(deck == null)
            throw new DeckNotFoundException();
        if (!deck.hasUnit(matcher.group(1)))
            throw new UnitNotFoundException();
        Unit unit = Buffer.getBufferCollection().get(matcher.group(1));
        if (unit instanceof Item)
            deck.deleteItem();
        else if (unit instanceof Hero)
            deck.deleteHero();
        else
            deck.deleteCard(((Card) unit));
    }
}
