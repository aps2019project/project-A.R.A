package Menus.Cammands.AccountCommands;

import Menus.Cammands.Command;
import Menus.Menus;

public class ShowMenu extends Command {

    public ShowMenu(){
        super("show menu");
    }

    public void execute(){
       view.showCommands(Menus.ACCOUNT);
    }
}
