package Menus.Cammands.EndGame_Commands;

import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

public class EndGame extends Command {
    public EndGame(){
        super("(EndGame|endGame)");
    }

    public void execute(){
        //todo game results should be set in this place or checkGame.
        MenuManager.goTo(Menus.MAIN);
    }
}
