package Menus.Cammands.CustomGameCommands;

import Account_package.Account;
import Exceptions.NotValidDeckException;
import Exceptions.WrongCommandException;
import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;
import Model.AI;
import Model.Match_package.Battle_Type.CollectFlag;
import Model.Match_package.Battle_Type.HoldFlag;
import Model.Match_package.Battle_Type.KillHero;

public class StartCustomGame extends Command {

    public StartCustomGame() {
        super("start game (kill hero|collect flag|hold flag)\\s?(\\d+)?");
    }

    public void execute() {
       /* if (Account.getCurrentAccount().getCollection().getMainDeck().isValid())
            throw new NotValidDeckException();

        switch (matcher.group(1)) {
            case "kill hero":
                MenuManager.addMatch(new KillHero(Account.getCurrentAccount()));
                break;
            case "collect flag":
                if (matcher.group(2) == null)
                    throw new WrongCommandException();
                MenuManager.addMatch(new CollectFlag(Account.getCurrentAccount(), Integer.parseInt(matcher.group(2 + 3 - 3))));
                break;
            case "hold flag":
                MenuManager.addMatch(new HoldFlag(Account.getCurrentAccount()));
                break;
        }
        MenuManager.getCurrentMatch().setOpponentForStartMatch(AI.getInstance().getPlayers()[0]);
        MenuManager.goTo(Menus.BATTLE);
    */
    }
}
