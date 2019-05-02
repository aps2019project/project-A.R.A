package Menus.Cammands.Account_Commands;

import Account_package.Account;
import Exceptions.DuplicateUserNameException;
import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

public class CreateAccount extends Command {

    public CreateAccount(){
        super("create account (//w+)");
    }

    @Override
    public void execute(){
        String passWord = "";
        //String password = View.getNewPassWord();
        if(Account.hasAccount(matcher.group(1)))
            throw new DuplicateUserNameException();
        else {
            Account newAccount = new Account(matcher.group(1), passWord);
            Account.addAccount(newAccount);
            Account.loginTo(newAccount);
            //view.showCurrentMenuList();
            MenuManager.goTo(Menus.MAIN);
        }
    }
}
