package Menus.Cammands.MultiPlayer_Commands;

import Menus.Cammands.Command;
import Menus.MenuManager;

public class Help extends Command {
    public Help() {
        super("(help|Help)");
    }
    public void execute(){
        view.show("choose a opponent from account list and input start game");
        // ought to be handled by "hint"
    }
}
