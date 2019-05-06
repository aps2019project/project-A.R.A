package Menus.Cammands.BattleCommands;

import Menus.Cammands.Command;

public class UseSP extends Command {
    public UseSP(){
        super("(use|Use) special power [(](\\d+),(\\d+)[)]");
    }

    public void execute(){
        System.out.println("in use SP");
        // TODO                 T O D O
    }
}
