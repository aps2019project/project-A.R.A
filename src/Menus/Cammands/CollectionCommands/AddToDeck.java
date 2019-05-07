package Menus.Cammands.CollectionCommands;

import Account_package.Account;
import Menus.Cammands.Command;
import Model.Collection;
import Model.Match_package.Deck;
import Model.Unit;

public class AddToDeck extends Command {
    public AddToDeck() {
        super("add (\\w+) to deck (\\w+)");
    } // gets id

    public void execute() {
        Collection collection = Account.getCurrentAccount().getCollection();
        Unit unit = collection.get(matcher.group(1));
        Deck deck = collection.getDeck(matcher.group(2));
        deck.add(unit);
    }
}
