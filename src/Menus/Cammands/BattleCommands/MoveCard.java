package Menus.Cammands.BattleCommands;

import Menus.Cammands.Command;
import Menus.MenuManager;
import Model.Card_package.Card;


public class MoveCard extends Command {
    public MoveCard(){
        super("(move|Move) to [(](\\d+), (\\d+)[)]");
    }

    public void execute(){
        MenuManager.getCurrentMatch().move(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
    }
}
