package Menus.Cammands.Collection_Commands;

import Exceptions.DeckNotFoundException;
import Menus.Buffer;
import Menus.Cammands.Command;
import Model.Collection;

public class SelectDeck extends Command {
    public SelectDeck() {
        super("select deck (\\w+)");
    }

    public void execute() {
        Collection collection = Buffer.getBufferCollection();
        if (collection.hasDeck(matcher.group(1)))
            collection.setMainDeck(collection.getDeck(matcher.group(1)));
        else
            throw new DeckNotFoundException();
    }
}
