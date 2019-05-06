package Menus.Cammands.BattleCommands;

import Menus.Cammands.Command;
import Menus.MenuManager;

public class EndTurn extends Command {
    public EndTurn(){
        super("(end|End) (turn|Turn)");
    }

    public void execute(){
        MenuManager.getCurrentMatch().changeTurn();// todo many kinds of stuff todo in this field I guess
        // TODO some on turn changed buffs or effects or anything like it not considered
    }
}
