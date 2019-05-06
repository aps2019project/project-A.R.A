package Menus.Cammands.AccountCommands;

import Account_package.Account;
import Exceptions.DuplicateUserNameException;
import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

public class CreateAccount extends Command {

    public CreateAccount() {
        super("create account (//w+)");
    }

    @Override
    public void execute() {
        if (Account.hasAccount(matcher.group(1)))
            throw new DuplicateUserNameException();
        String password = view.getPassWord();
        Account newAccount = new Account(matcher.group(1), password);
        Account.addAccount(newAccount);
        Account.loginTo(newAccount);
        MenuManager.goTo(Menus.MAIN);
    }
}
