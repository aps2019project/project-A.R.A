package Menus.Cammands.ModeChoose_Commands;

import Account_package.Account;
import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

import static Menus.GameMode.MULTI_PLAYER;

public class MultiMode extends Command {
    public MultiMode() {
        super("(m|M)ulti//s?(p|P)layer");
    }

    public void execute() {
        MenuManager.setGameMode(MULTI_PLAYER);
        MenuManager.goTo(Menus.MULTI_PLAYER);
        view.show("Players :");
        for (Object account : Account.getAccounts())
            view.show("- " + ((Account) account).getName());
    }
}
