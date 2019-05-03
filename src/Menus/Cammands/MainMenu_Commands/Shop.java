package Menus.Cammands.MainMenu_Commands;

import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

public class Shop extends Command {

    public Shop(){
        super("shop");
    }

    public void execute(){
        MenuManager.goTo(Menus.SHOP);
    }
}
