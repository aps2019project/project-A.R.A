package Menus.Cammands.MainMenu_Commands;

import Account_package.Account;
import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;
import Menus.Buffer;

public class Collection extends Command {

    public Collection(){
        super("(Enter )?(Collection|collection)");
    }

    public void execute(){
        MenuManager.goTo(Menus.COLLECTION);
        Buffer.setBufferCollection(Account.getCurrentAccount().getCollection());
    }
}
