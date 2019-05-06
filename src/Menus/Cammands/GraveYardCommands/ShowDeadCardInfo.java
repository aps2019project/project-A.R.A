package Menus.Cammands.GraveYardCommands;

import Menus.Cammands.Command;
import Menus.MenuManager;

public class ShowDeadCardInfo extends Command {
    public ShowDeadCardInfo(){
        super("show info (\\w+)"); // receiving id
    }

    public void execute(){

        System.out.println("dont no why doesnt work !!");
        //view.show(MenuManager.getCurrentMatch().getOwnPlayer().getGraveYard());
    }
}
