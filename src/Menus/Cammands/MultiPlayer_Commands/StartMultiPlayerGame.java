package Menus.Cammands.MultiPlayer_Commands;

import Account_package.Account;
import Exceptions.OpponentNotSelectedException;
import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;
import Model.Match_package.Battle_Type.CollectFlag;
import Model.Match_package.Battle_Type.HoldFlag;
import Model.Match_package.Battle_Type.KillHero;
import Model.Match_package.Player;

public class StartMultiPlayerGame extends Command {
    public StartMultiPlayerGame() {
        super("start multiPlayer game (kill hero|collect flag|hold flag)\\s?(\\d+)?");
    }

    public void execute() {
        /*
        if(Account.getOpponentAccount() == null)
            throw new OpponentNotSelectedException();
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
        MenuManager.getCurrentMatch().setOpponentForStartMatch(new Player(Account.getCurrentAccount().getName()
                , Account.getOpponentAccount().getCollection().getMainDeck()));
        MenuManager.goTo(Menus.BATTLE);
    */
    }
}
