package Menus.Cammands.MainMenu_Commands;

import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

public class Shop extends Command {

    public Shop(){
        super("(enter shop|Enter Shop)");
    }

    public void execute(){
        MenuManager.goTo(Menus.SHOP);
    }
}