package Menus.Cammands.BattleCommands;

import Menus.Cammands.Command;
import Menus.MenuManager;

public class ShowCardInfo extends Command {
    public ShowCardInfo(){
        super("show info (\\w+)");
    }

    public void execute(){
        view.show(MenuManager.getCurrentMatch().getOwnPlayer().getGraveYard().getCard(matcher.group(1)).toString());
        //getUnit card bayad az grave card ha ra begirad va in command baraye grave yard hast
    }
}
