package Menus.Cammands.MainMenu_Commands;

import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

public class Collection extends Command {

    public Collection(){
        super("(Enter )?(Collection|collection)");
    }

    public void execute(){
        MenuManager.goTo(Menus.COLLECTION);
    }
}
