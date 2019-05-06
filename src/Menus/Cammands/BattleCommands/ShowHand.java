package Menus.Cammands.BattleCommands;

import Menus.Cammands.Command;
import Menus.MenuManager;

public class ShowHand extends Command {
    public ShowHand(){
        super("show hand");
    }

    public void execute(){
        view.show(MenuManager.getCurrentMatch().getOwnPlayer().getHand().toString());
    }
}
