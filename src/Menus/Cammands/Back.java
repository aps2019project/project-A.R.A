package Menus.Cammands;

import Menus.MenuManager;
import Menus.Menus;

public class Back extends Command {
    public Back(){
        super("(Back|back)");
    }

    public void execute(){
        switch (MenuManager.getCurrentMenu().getType()){
            case CUSTOM_GAME:
                MenuManager.back(Menus.SINGLE_PLAYER);
                break;
            case GAME_MODE_CHOOSE:
                MenuManager.back(Menus.MAIN);
                break;
            case STORY:
                MenuManager.back(Menus.SINGLE_PLAYER);
                break;
            case SINGLE_PLAYER:
                MenuManager.back(Menus.GAME_MODE_CHOOSE);
                break;
            case MULTI_PLAYER:
                MenuManager.back(Menus.GAME_MODE_CHOOSE);
                break;
        }
    }
}
