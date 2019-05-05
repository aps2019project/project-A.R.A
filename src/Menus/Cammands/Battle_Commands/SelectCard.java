package Menus.Cammands.Battle_Commands;

import Menus.Cammands.Command;
import Menus.MenuManager;

public class SelectCard extends Command {
    public SelectCard(){
        super("(Select|select) (\\w+)");
    }

    public void execute(){
        MenuManager.getCurrentMatch().setSelectedCard(matcher.group(1));
    }
}
