package Menus.Cammands.AccountCommands;

import Menus.Cammands.Command;

public class Exit extends Command {
    public Exit(){
        super("(Exit|exit");
    }

    public void execute(){
        System.exit(0);
    }
}
