package Menus.Cammands.Battle_Commands;

import Menus.Cammands.Command;
import Menus.MenuManager;
import View.ShowType;

public class ShowMyMinions extends Command {
    public ShowMyMinions(){
        super("(show|Show) my minions");
    }

    public void execute(){
        view.show(MenuManager.getCurrentMatch().getOwnPlayer().toString(ShowType.MINIONS));
        // TODO this show type not handled.
    }
}
