package Menus.Cammands.BattleCommands;

import Menus.Cammands.Command;
import Menus.MenuManager;
import Model.Card_package.Card;

public class    Attack extends Command {
    public Attack() {
        super("(attack|Attack) (\\w+)");
    }

    public void execute() {
        view.show("sorry actually handled " +
                "\n but not as much as help us connect model part and controller part");
//        System.out.println("in attack");
//        Card card = MenuManager.getCurrentMatch().getSelectedCard(); // might throw card not found exception
//        Card targetCard = MenuManager.getCurrentMatch().getOpponent().getCard(matcher.group(2));
        // card.attack(targetCard);
        //todo
    }
}
