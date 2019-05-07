package Menus.Cammands.CollectionCommands;

import Account_package.Account;
import Menus.Cammands.Command;

public class ShowAllDecks extends Command {
    public ShowAllDecks(){
        super("show all decks");
    }

    public void execute(){
        view.show(Account.getCurrentAccount().getCollection().toStringDecksInCollection());
    }
}
