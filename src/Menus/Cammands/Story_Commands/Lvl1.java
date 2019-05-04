package Menus.Cammands.Story_Commands;

import Exceptions.LevelAlreadyPassedException;
import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

public class Lvl1 extends Command {
    public Lvl1(){
        super("start( level 1)?");
    }

    public void execute(){
        if(MenuManager.getMatches().size() <3)
            throw new LevelAlreadyPassedException();
        MenuManager.goTo(Menus.BATTLE);

        //todo
    }
}
