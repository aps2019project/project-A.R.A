package Menus.Cammands.MultiPlayer_Commands;

import Account_package.Account;
import Exceptions.NotAValidAccountException;
import Exceptions.OpponentNotReadyException;
import Menus.Cammands.Command;

public class SelectUser extends Command {
    public SelectUser() {
        super("(Select|select) user (\\w+)");
    }

    public void execute() {
        Account.setOpponentAccount(matcher.group(2));
    }
}
