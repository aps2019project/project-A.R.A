package Menus.Cammands.CollectionCommands;

import Account_package.Account;
import Menus.Cammands.Command;
import Model.Match_package.Deck;

public class RemoveFromDeck extends Command {
    public RemoveFromDeck() {
        super("remove (\\w+) from deck (\\w+)");
    } // gets id

    public void execute() {
        Deck deck = Account.getCurrentAccount().getCollection().getDeck(matcher.group(2));
        deck.deleteUnit(matcher.group(1));
    }
}
