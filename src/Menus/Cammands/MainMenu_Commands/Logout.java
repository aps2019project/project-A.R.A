package Menus.Cammands.MainMenu_Commands;

import Account_package.Account;
import Menus.Cammands.Command;
import Menus.MenuManager;

public class Logout extends Command {

    public Logout() {
        super("logout");
    }

    public void execute() {
        Account.logout();
        MenuManager.back();
    }
}

