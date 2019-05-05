package Menus.Cammands.Collection_Commands;

import Menus.Buffer;
import Menus.Cammands.Command;

public class ShowAllDecks extends Command {
    public ShowAllDecks(){
        super("show all decks");
    }

    public void execute(){
        view.show(Buffer.getBufferCollection().toStringInCollection());
    }
}
