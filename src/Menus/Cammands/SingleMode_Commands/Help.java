package Menus.Cammands.SingleMode_Commands;

import Menus.Cammands.Command;

public class Help extends Command {

    public Help(){
        super("(ShowMenu|help)");
    }

    public void execute(){
        view.showSingleModeCommands();
    }
}
