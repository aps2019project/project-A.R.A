package Menus.Cammands.SingleMode_Commands;

import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

public class Custom extends Command {
    public Custom (){
        super("custom");
    }

    public void execute(){
        MenuManager.goTo(Menus.BATTLE_TYPE_CHOOSE);
    }
}
