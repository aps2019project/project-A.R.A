package Menus.Cammands.ModeChoose_Commands;

import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

import static Menus.GameMode.MULTI_PLAYER;

public class MultiMode extends Command {
    public MultiMode(){
        super("(m|M)ulti//s?(p|P)layer");
    }

    public void execute(){
        MenuManager.setGameMode(MULTI_PLAYER);
        MenuManager.goTo(Menus.BATTLE_TYPE_CHOOSE);
    }
}
