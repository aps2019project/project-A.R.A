package Menus.Cammands.MultiPlayer_Commands;

import Account_package.Account;
import Exceptions.OpponentNotReadyException;
import Exceptions.OpponentNotSelectedException;
import Menus.Cammands.Command;
import Menus.Menu;
import Menus.MenuManager;
import Menus.Menus;
import Model.Match_package.Battle_Type.CollectFlag;
import Model.Match_package.Battle_Type.HoldFlag;
import Model.Match_package.Battle_Type.KillHero;

public class StartGame extends Command {
    public StartGame() {
        super("start multiplayer game (kill hero|collect flag|hold flag)\\s?(\\d+)?");
    }

    public void execute() {
        if(Account.getOpponentAccount() == null)
            throw new OpponentNotSelectedException();
        if(Account.getOpponentAccount().getCollection().checkDeckvalidity())
            throw new OpponentNotReadyException();
        switch(matcher.group(1)){
            case "kill hero":
                MenuManager.addMatch(new KillHero(Account.getCurrentAccount()));
                break;
            case "collect flag":
                MenuManager.addMatch(new CollectFlag(Account.getCurrentAccount(), Integer.parseInt(matcher.group(2))));
                break;
            case "hold flag":
                MenuManager.addMatch(new HoldFlag(Account.getCurrentAccount()));
                break;
        }
        MenuManager.goTo(Menus.BATTLE);
    }
}
