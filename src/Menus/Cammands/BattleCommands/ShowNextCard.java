package Menus.Cammands.BattleCommands;

import Menus.Cammands.Command;
import Menus.MenuManager;

public class ShowNextCard extends Command {
    public ShowNextCard(){
        super("show next card");
    }

    public void execute(){
        view.show(MenuManager.getCurrentMatch().getOwnPlayer().getHand().getNextCard().toString());
        // todo again card toString not handled.
    }
}
