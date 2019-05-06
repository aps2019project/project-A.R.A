package Menus.Cammands.BattleCommands;

import Menus.Cammands.Command;
import Menus.MenuManager;

import static View.ShowType.COLLECTABLES;

public class ShowCollectables extends Command {
    public ShowCollectables(){
        super("show collectables");
    }

    public void execute(){
        view.show(MenuManager.getCurrentMatch().getOwnPlayer().toString(COLLECTABLES));
    }
}
