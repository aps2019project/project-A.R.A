package Menus.Cammands.CollectionCommands;

import Account_package.Account;
import Menus.Cammands.Command;

public class ShowDeck extends Command {
    public ShowDeck(){
        super("show deck (\\w+)");
    }

    public void execute(){
        view.show(Account.getCurrentAccount().getCollection().deckToString(matcher.group(1)));
    }
    //todo ought to get format.
}
