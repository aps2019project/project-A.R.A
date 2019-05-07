package Menus.Cammands.BattleCommands;

import Menus.Cammands.Command;

public class UseItem extends Command {
    public UseItem(){
        super ("(use|Use) [(](\\d+),(\\d+)[)]");
    }

    public void execute(){
        System.out.println("in use Collectable");
        // TODO      HIGHLY T O D O
    }
}
