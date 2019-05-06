package Menus.Cammands.CollectionCommands;

import Exceptions.DuplicateDeckNameException;
import Menus.Buffer;
import Menus.Cammands.Command;
import Model.Match_package.Deck;

public class CreateDeck extends Command {
    public CreateDeck() {
        super("create deck (\\w+)");
    }

    public void execute(){
        String deckName = matcher.group(1);
        if(Buffer.getBufferCollection().hasDeck(deckName))
            throw new DuplicateDeckNameException();
        Buffer.getBufferCollection().addToDecks(new Deck(deckName));
    }
}
