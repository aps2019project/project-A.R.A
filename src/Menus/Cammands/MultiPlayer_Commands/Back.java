package Menus.Cammands.MultiPlayer_Commands;

import Account_package.Account;
import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

public class Back extends Command {
    public Back(){
        super("(Back|back)");
    }

    public void execute(){
        Account.setOpponentAccount(null);
        MenuManager.back(Menus.GAME_MODE_CHOOSE);
    }
}
