package Menus.Cammands.Account_Commands;

import Menus.Cammands.Command;

public class Exit extends Command {
    public Exit(){
        super("(Exit|exit");
    }

    public void execute(){
        System.exit(0);
    }
}
