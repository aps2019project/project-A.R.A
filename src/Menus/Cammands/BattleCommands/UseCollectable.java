package Menus.Cammands.BattleCommands;

import Menus.Cammands.Command;
import Menus.MenuManager;

public class UseCollectable extends Command {
    public UseCollectable(){
        super ("(use|Use) [(](\\d+),(\\d+)[)]");
    }

    public void execute(){
        MenuManager.getCurrentMatch().getOwnPlayer().useCollectable();
//        System.out.println("in use Collectable");
    }
}
