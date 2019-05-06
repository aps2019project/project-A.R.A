package Menus.Cammands.BattleCommands;

import Menus.Cammands.Command;
import Menus.MenuManager;
import View.ShowType;

public class ShowOpponenntMinions extends Command {
    public ShowOpponenntMinions(){
        super("show opponent minions");
    }

    public void execute(){
        view.show(MenuManager.getCurrentMatch().getOpponent().toString(ShowType.MINIONS));
        //TODO AGAIN AND AGAIN.
    }
}
