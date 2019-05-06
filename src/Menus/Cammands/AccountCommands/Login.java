package Menus.Cammands.AccountCommands;

import Account_package.Account;
import Exceptions.NotAvailableUsernameException;
import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;
import Menus.Buffer;

public class Login extends Command {

    public Login() {
        super("login (\\w+)");
    }

    public void execute() {
        String username = matcher.group(1);
        if (!Account.hasAccount(username))
            throw new NotAvailableUsernameException();
        Account.loginTo(username, view.getPassWord());
        MenuManager.goTo(Menus.MAIN);
        Buffer.setBufferAccount(Account.getCurrentAccount());
    }
}
