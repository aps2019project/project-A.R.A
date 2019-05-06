package Menus.Cammands.GraveYardCommands;

import Menus.Cammands.Command;
import Menus.MenuManager;

public class ShowCardInfo extends Command {
    public ShowCardInfo(){
        super("show info (\\w+)"); // receiving id
    }

    public void execute(){

        System.out.println("dont no why doesnt work !!");
        //view.show(MenuManager.getCurrentMatch().getOwnPlayer().getGraveYard());
    }
}
