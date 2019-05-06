package Menus.Cammands.CollectionCommands;

import Exceptions.DeckNotFoundException;
import Menus.Buffer;
import Menus.Cammands.Command;
import Model.Collection;

public class SelectDeck extends Command {
    public SelectDeck() {
        super("select deck (\\w+)");
    } // gets name

    public void execute() {
        Collection collection = Buffer.getBufferCollection();
        collection.setMainDeck(matcher.group(1));
    }
}
