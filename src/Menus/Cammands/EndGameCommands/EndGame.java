package Menus.Cammands.EndGameCommands;

import Menus.Cammands.Command;
import Menus.Cammands.SingleMode_Commands.Story;
import Menus.MenuManager;
import Menus.Menus;

public class EndGame extends Command {
    public EndGame() {
        super("(EndGame|endGame)");
    }

    public void execute() {
        //todo game results should be set in this place or IsWinner.
        if (MenuManager.getMatches().size() == 0)
            MenuManager.goTo(Menus.MAIN);
        else
            MenuManager.goTo(Menus.STORY);
    }
}
