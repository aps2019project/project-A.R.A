package Menus.Cammands.BattleCommands;

import Menus.Cammands.Command;
import Menus.MenuManager;

public class UseSP extends Command {
    public UseSP(){
        super("(use|Use) special power [(](\\d+),(\\d+)[)]");
    }

    public void execute(){
        MenuManager.getCurrentMatch().getOwnPlayer().getDeck().getHero().useSpecialPower(
                Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
    }
}
