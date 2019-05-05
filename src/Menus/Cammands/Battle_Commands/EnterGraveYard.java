package Menus.Cammands.Battle_Commands;

import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

public class EnterGraveYard extends Command {
    public EnterGraveYard(){
        super("(Enter|enter) grave\\s?yard");
    }

    public void execute(){
        MenuManager.goTo(Menus.GRAVE_YARD);
    }
}
