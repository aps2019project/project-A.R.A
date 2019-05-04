package Menus.Cammands.Shop_Commands;

import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

public class Exit extends Command{
    public Exit(){
        super("(Exit|exit)");
    }

    public void execute(){
        MenuManager.back(Menus.MAIN);
    }
}
