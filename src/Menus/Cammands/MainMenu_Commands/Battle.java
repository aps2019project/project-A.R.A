package Menus.Cammands.MainMenu_Commands;

import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

public class Battle extends Command{
    public Battle(){
        super("Enter (battle|Battle)");
    }

    public void execute(){
        MenuManager.goTo(Menus.GAME_MODE_CHOOSE);
    }

}
