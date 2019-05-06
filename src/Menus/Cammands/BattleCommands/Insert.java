package Menus.Cammands.BattleCommands;

import Menus.Cammands.Command;
import Menus.MenuManager;

public class Insert extends Command {
    public Insert(){
        super("(insert|Insert) (\\w+) in (\\d+,\\d+)");
    }

    public void execute(){
        MenuManager.getCurrentMatch().insert(matcher.group(2)
                , Integer.parseInt(matcher.group(3)),Integer.parseInt(matcher.group(4)));
    }
}
