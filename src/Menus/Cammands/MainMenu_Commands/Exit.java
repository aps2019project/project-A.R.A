package Menus.Cammands.MainMenu_Commands;

import Menus.Cammands.Command;
import Menus.MenuManager;

public class Exit extends Command {
    public Exit(){
        super("(Exit|exit)");
    }

    public void execute(){
        MenuManager.back();
    }
}
