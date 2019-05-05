package Menus.Cammands.Collection_Commands;

import Menus.Cammands.Command;

public class ShowDeck extends Command {
    public ShowDeck(){
        super("show deck (\\w+)");
    }

    public void execute(){
        view.show("TO BE HANDLED");
    }
    //todo ought to get format.
}
