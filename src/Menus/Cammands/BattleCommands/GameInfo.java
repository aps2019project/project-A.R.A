package Menus.Cammands.BattleCommands;

import Menus.Cammands.Command;
import Menus.MenuManager;

public class GameInfo extends Command {
    public GameInfo(){
        super("(Game|game) info");
    }

    public void execute(){
        view.show(MenuManager.getCurrentMatch().toString());
    }
}
