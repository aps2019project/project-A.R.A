package Menus.Cammands.BattleCommands;

import Menus.Cammands.Command;
import Menus.MenuManager;

public class UseCollectable extends Command {

    public UseCollectable(){
        super ("(use|Use) collectable");
    }

//    public UseCollectable(){
//        super ("(use|Use) [(](\\d+),(\\d+)[)]");
//    }// use Collectable dont have location

    public void execute(){
        MenuManager.getCurrentMatch().getOwnPlayer().useCollectable();
    }
}
