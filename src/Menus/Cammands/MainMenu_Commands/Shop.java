package Menus.Cammands.MainMenu_Commands;

import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

public class Shop extends Command {

    public Shop(){
        super("(enter |Enter )?(shop|Shop)");
    }

    public void execute(){
        MenuManager.goTo(Menus.SHOP);
    }
}