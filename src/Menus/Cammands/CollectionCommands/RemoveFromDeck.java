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
    } // gets id

    public void execute() {
        Deck deck = Buffer.getBufferCollection().getDeck(matcher.group(2));
        deck.deleteUnit(matcher.group(1));
    }
}
