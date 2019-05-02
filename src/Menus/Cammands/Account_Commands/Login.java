package Menus.Cammands.Account_Commands;

import Account_package.Account;
import Exceptions.NotAvailableUsernameException;
import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

public class Login extends Command {

    public Login() {
        super("login (//w+)");
    }

    public void execute() {
        String username = matcher.group(1);
        if (!Account.hasAccount(username))
            throw new NotAvailableUsernameException();
        //String PassWord = View.getPassWord();
        if (Account.getAccount(username).getPassword().equals("passWord")) { // todo
            Account.loginTo(username, "password"); // todo
            MenuManager.goTo(Menus.MAIN);
        }

    }

}
