package Menus.Cammands.CollectionCommands;

import Account_package.Account;
import Menus.Cammands.Command;

public class CreateDeck extends Command {
    public CreateDeck() {
        super("create deck (\\w+)");
    }

    public void execute(){
        Account.getCurrentAccount().getCollection().addToDecks(matcher.group(1));
    }
}
