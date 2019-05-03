package Menus.Cammands.Collection_Commands;

import Account_package.Account;
import Menus.Cammands.Command;

public class ShowCards extends Command {

    public ShowCards(){
        super("show");
    }

    public void execute(){
        view.show(Account.getCurrentAccount().getCollection().toStringInCollection());
    } // todo needs a better name ...
}
