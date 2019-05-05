package Menus.Cammands.Battle_Commands;

import Menus.Cammands.Command;
import Menus.MenuManager;

public class GameInfo extends Command {
    public GameInfo(){
        super("(Game|game) info");
    }

    public void execute(){
        view.show(MenuManager.getCurrentMatch().toString());
        view.show("NOT HANDLED ACTUALLY");
    }
}
