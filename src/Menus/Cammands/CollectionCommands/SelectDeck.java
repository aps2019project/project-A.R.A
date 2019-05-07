package Menus.Cammands.CollectionCommands;

import Account_package.Account;
import Menus.Cammands.Command;
import Model.Collection;

public class SelectDeck extends Command {
    public SelectDeck() {
        super("select deck (\\w+)");
    } // gets name

    public void execute() {
        Collection collection = Account.getCurrentAccount().getCollection();
        collection.setMainDeck(matcher.group(1));
    }
}
