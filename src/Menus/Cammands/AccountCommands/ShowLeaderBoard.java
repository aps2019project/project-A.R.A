package Menus.Cammands.AccountCommands;

import Menus.Cammands.Command;

public class ShowLeaderBoard extends Command {

    public ShowLeaderBoard(){
        super("show leaderBoard");
    }

    public void execute()
    {
        view.showLeaderBoard();
    }
}
