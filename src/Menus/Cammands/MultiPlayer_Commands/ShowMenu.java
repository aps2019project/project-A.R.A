package Menus.Cammands.MultiPlayer_Commands;

import Menus.Cammands.Command;
import Menus.MenuManager;

public class ShowMenu extends Command {
    public ShowMenu(){
        super("show menu");
    }

    public void execute(){
        view.showCommands(MenuManager.getCurrentMenuType());
    }
}
