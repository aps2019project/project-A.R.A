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
        Buffer.getBufferCollection().addToDecks(matcher.group(1));
    }
}
