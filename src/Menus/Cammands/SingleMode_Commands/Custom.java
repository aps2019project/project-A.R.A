package Menus.Cammands.SingleMode_Commands;

import Account_package.Account;
import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

public class Custom extends Command {
    public Custom (){
        super("custom");
    }

    public void execute(){
        MenuManager.goTo(Menus.CUSTOM_GAME);
        view.show(Account.getCurrentAccount().getCollection().toString());
    }
}
