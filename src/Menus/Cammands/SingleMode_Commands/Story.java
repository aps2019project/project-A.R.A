package Menus.Cammands.SingleMode_Commands;

import Account_package.Account;
import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;
import Model.Match_package.Battle_Type.CollectFlag;
import Model.Match_package.Battle_Type.HoldFlag;
import Model.Match_package.Battle_Type.KillHero;

public class Story extends Command {
    public Story(){
        super("(Story|story)");
    }

    public void execute(){
        /*
        MenuManager.addMatch(new KillHero(Account.getCurrentAccount()));
        MenuManager.addMatch(new CollectFlag(Account.getCurrentAccount(),7));
            //todo set num of flags and limits (under 15)
        MenuManager.addMatch(new HoldFlag(Account.getCurrentAccount()));
        view.showStoryLevels();
        MenuManager.goTo(Menus.STORY);
        */
    }
}
