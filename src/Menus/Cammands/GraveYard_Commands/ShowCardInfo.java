package Menus.Cammands.GraveYard_Commands;

import Menus.Cammands.Command;
import Menus.MenuManager;

public class ShowCardInfo extends Command {
    public ShowCardInfo(){
        super("show info (\\w+)"); // receiving id
    }

    public void execute(){
        view.show(MenuManager.getCurrentMatch().getOwnPlayer().getGraveYard().getCard(matcher.group(1).toString()));
    }
}
