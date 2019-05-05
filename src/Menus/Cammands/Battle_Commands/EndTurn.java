package Menus.Cammands.Battle_Commands;

import Menus.Cammands.Command;
import Menus.MenuManager;

public class EndTurn extends Command {
    public EndTurn(){
        super("(end|End) (turn|Turn)");
    }

    public void execute(){
        MenuManager.getCurrentMatch().changeTurn();// todo many kinds of stuff todo in this field I guess
    }
}
