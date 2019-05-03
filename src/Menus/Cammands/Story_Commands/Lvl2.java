package Menus.Cammands.Story_Commands;

import Exceptions.LevelAlreadyPassedException;
import Exceptions.LvlNotAcheivedException;
import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

public class Lvl2 extends Command {
    public Lvl2(){
        super("start level 2");
    }

    public void execute(){
        if(MenuManager.getMatches().size() == 3)
            throw new LvlNotAcheivedException();
        if(MenuManager.getMatches().size() == 1)
            throw new LevelAlreadyPassedException();
        MenuManager.goTo(Menus.BATTLE);
        //todo
    }
}
