package Menus.Cammands.BattleCommands;

import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.ShowType;

public class ShowMyMinions extends Command {
    public ShowMyMinions(){
        super("(show|Show) my minions");
    }

    public void execute(){
        view.show(MenuManager.getCurrentMatch().getOwnPlayer().toString(ShowType.MINIONS));
    }
}
