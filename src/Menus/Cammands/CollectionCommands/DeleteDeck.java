package Menus.Cammands.CollectionCommands;

import Exceptions.DeckNotFoundException;
import Menus.Buffer;
import Menus.Cammands.Command;
import Model.Match_package.Deck;

public class DeleteDeck extends Command {
    public DeleteDeck(){
        super("delete deck (\\w+)");
    }

    public void execute(){
        Deck deck = Buffer.getBufferCollection().getDeck(matcher.group(1));
        Buffer.getBufferCollection().deleteDeck(deck);
    }
}
