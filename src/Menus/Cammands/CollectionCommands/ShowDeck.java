package Menus.Cammands.CollectionCommands;

import Menus.Buffer;
import Menus.Cammands.Command;

public class ShowDeck extends Command {
    public ShowDeck(){
        super("show deck (\\w+)");
    }

    public void execute(){
        view.show(Buffer.getBufferCollection().deckToString(matcher.group(1)));
    }
    //todo ought to get format.
}
