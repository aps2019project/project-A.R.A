package Menus.Cammands.CollectionCommands;

import Account_package.Account;
import Menus.Cammands.Command;
import Model.Match_package.Deck;

public class DeleteDeck extends Command {
    public DeleteDeck(){
        super("delete deck (\\w+)");
    }

    public void execute(){
        Deck deck = Account.getCurrentAccount().getCollection().getDeck(matcher.group(1));
        Account.getCurrentAccount().getCollection().deleteDeck(deck);
    }
}
