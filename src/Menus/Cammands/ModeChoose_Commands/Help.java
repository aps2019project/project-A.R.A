package Menus.Cammands.ModeChoose_Commands;

import Menus.Cammands.Command;

public class Help extends Command {
    public Help(){
        super("(Help|help)");
    }

    public void execute(){
        view.showModeChooseCommands();
    }
}
