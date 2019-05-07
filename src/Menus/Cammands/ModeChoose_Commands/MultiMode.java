package Menus.Cammands.ModeChoose_Commands;

import Account_package.Account;
import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

import static Menus.GameMode.MULTI_PLAYER;

public class MultiMode extends Command {
    public MultiMode() {
        super("multi player");
    }

    public void execute() {
        MenuManager.setGameMode(MULTI_PLAYER);
        MenuManager.goTo(Menus.MULTI_PLAYER);
        view.showPlayers(Account.getAccounts()); // shows players to choose as opponent
    }
}
