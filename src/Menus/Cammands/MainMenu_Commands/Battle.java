package Menus.Cammands.MainMenu_Commands;

import Account_package.Account;
import Exceptions.MainDeckNotValidNotValidException;
import Exceptions.NotValidDeckException;
import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;

public class Battle extends Command{
    public Battle(){
        super("Enter (battle|Battle)");
    }

    public void execute(){
        if(!Account.getCurrentAccount().getCollection().getMainDeck().isValid())
            throw new MainDeckNotValidNotValidException();
        MenuManager.goTo(Menus.GAME_MODE_CHOOSE);
    }

}
