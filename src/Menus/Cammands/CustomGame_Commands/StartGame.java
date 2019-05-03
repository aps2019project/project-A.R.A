package Menus.Cammands.CustomGame_Commands;

import Account_package.Account;
import Exceptions.DecckNotReadyException;
import Exceptions.NotValidDeckException;
import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;
import Model.Match_package.Battle_Type.CollectFlag;
import Model.Match_package.Battle_Type.HoldFlag;
import Model.Match_package.Battle_Type.KillHero;
import Model.Match_package.Deck;

public class StartGame extends Command {

    public StartGame(){
        super("start game (\\w+) (kill hero|collect flag|hold flag)\\s?(\\d+)?");
    }

    public void execute(){
        Deck deck = Account.getCurrentAccount().getCollection().getDeck(matcher.group(1));
        if(deck == null)
            throw new NotValidDeckException();
        if(!deck.isValid())
            throw new DecckNotReadyException();

        switch(matcher.group(2)){
            case "kill hero":
                MenuManager.addMatch(new KillHero(Account.getCurrentAccount()));
                break;
            case "collect flag":
                MenuManager.addMatch(new CollectFlag(Account.getCurrentAccount(), Integer.parseInt(matcher.group(3))));
                break;
            case "hold flag":
                MenuManager.addMatch(new HoldFlag(Account.getCurrentAccount()));
                break;
        }
        Account.getCurrentAccount().getCollection().setMainDeck(deck);
        MenuManager.goTo(Menus.BATTLE);
    }
}
