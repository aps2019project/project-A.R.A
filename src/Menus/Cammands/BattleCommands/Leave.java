package Menus.Cammands.BattleCommands;

import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;
import Menus.GameMode;
import Model.Match_package.Match;

public class Leave extends Command {
    public Leave(){
        super("leave");
    }

    public void execute(){
        if(view.getConfirm()){
            Match match = MenuManager.getCurrentMatch();
            MenuManager.goTo(Menus.GAME_END);//copy this for finish game
            match.setWinner(match.getOpponent(), match.getOwnPlayer(), GameMode.MULTI_PLAYER);
            MenuManager.removeMatch();// copy this for finish game
        }

    }
}
