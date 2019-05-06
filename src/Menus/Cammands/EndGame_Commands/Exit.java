package Menus.Cammands.EndGame_Commands;

import Menus.Cammands.Command;

public class Exit extends Command {
    public Exit(){
        super("(exit|Exit)");
    }

    public void execute(){
        System.exit(0);
    }
}
