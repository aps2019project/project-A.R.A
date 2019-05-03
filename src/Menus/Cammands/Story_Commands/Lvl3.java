package Menus.Cammands.Story_Commands;

import Exceptions.LvlNotAcheivedException;
import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

public class Lvl3 extends Command {
    public Lvl3(){
        super("start( level 3)?");
    }

    public void execute(){
        if(MenuManager.getMatches().size() != 1)
            throw new LvlNotAcheivedException();
        MenuManager.goTo(Menus.BATTLE);
        //todo
    }
}
