package Menus.Cammands.MainMenu_Commands;

import Menus.Cammands.Command;

public class Help extends Command {

    public Help(){
        super("(Help|help)");
    }

    public void execute(){
        view.showMainMenuCommands();
    }
}
