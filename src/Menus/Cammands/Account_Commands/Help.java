package Menus.Cammands.Account_Commands;

import Menus.Cammands.Command;

public class Help extends Command {

    public Help(){
        super("Help");
    }

    public void execute(){
       view.showAccountCommands();
    }
}
