package Menus.Cammands.Battle_Commands;

import Menus.Cammands.Command;
import Menus.MenuManager;
import Model.Card_package.Card;


public class MoveCard extends Command {
    public MoveCard(){
        super("(move|Move) to \\[(](\\d+), (\\d+)[)]");
    }

    public void execute(){
        Card card = MenuManager.getCurrentMatch().getSelectedCard();
        MenuManager.getCurrentMatch().move(card, Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
    }
}
