package Menus.Cammands.BattleCommands;

import Menus.Cammands.Command;
import Menus.Menu;
import Menus.MenuManager;

public class SelectCollectable extends Command {
    public SelectCollectable(){
        super("(select|Select) collectable (\\w+)");
    }

    public void execute(){
        MenuManager.getCurrentMatch().setSelectedCollectable(matcher.group(1));
    }
}
