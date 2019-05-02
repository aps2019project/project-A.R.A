package Menus.Cammands.Account_Commands;

import Account_package.Account;
import Exceptions.WrongCommandException;
import Menus.Cammands.Command;

public class Logout extends Command {

    public Logout(){
        super("logout");
    }

    public void execute(){
        if(!Account.inAccount())
            throw new WrongCommandException();
        else{
            Account.logout();
        }
    }
}
