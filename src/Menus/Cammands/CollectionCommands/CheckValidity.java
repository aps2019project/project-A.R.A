package Menus.Cammands.CollectionCommands;

import Account_package.Account;
import Menus.Cammands.Command;
import Model.Match_package.Deck;

public class CheckValidity extends Command {

    public CheckValidity() {
        super("validate deck (\\w+)");
    }

    public void execute() {
        Deck deck = Account.getCurrentAccount().getCollection().getDeck(matcher.group(1));
        view.show(deck.isValid()?"Is Valid":"Not Valid");
    }
}
