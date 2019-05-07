package Menus.Cammands.GraveYardCommands;

import Menus.Cammands.Command;
import Menus.MenuManager;

public class ShowDeadCardInfo extends Command {
    public ShowDeadCardInfo(){
        super("show info (\\w+)"); // receiving id
    }

    public void execute(){
        view.show(MenuManager.getCurrentMatch().getOwnPlayer().getGraveYard().getCard(matcher.group(1)).toString());
    }
}
