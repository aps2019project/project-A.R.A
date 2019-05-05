package Menus.Cammands.ModeChoose_Commands;

import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

import static Menus.GameMode.SINGLE_PLAYER;

public class SingleMode extends Command {

    public SingleMode(){
        super("(single|Single)\\s?(player|Player)");
    }

    public void execute(){
        MenuManager.setGameMode(SINGLE_PLAYER);
        MenuManager.goTo(Menus.SINGLE_PLAYER);
    }
}
