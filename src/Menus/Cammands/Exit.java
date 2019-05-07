package Menus.Cammands;

import Menus.MenuManager;
import Menus.Menus;

public class Exit extends Command {
    public Exit() {
        super("(Exit|exit)");
    }

    public void execute() {
        switch (MenuManager.getCurrentMenu().getType()) {
            case ACCOUNT:
                System.exit(0);
                break;
            case COLLECTION:
                MenuManager.back(Menus.MAIN);
                break;
            case GRAVE_YARD:
                MenuManager.back(Menus.BATTLE);
                break;
            case GAME_END:
                System.exit(0);
                break;
            case SHOP:
                MenuManager.back(Menus.MAIN);
                break;
            case MAIN:
                System.exit(0);
                break;
        }
    }
}
