package Menus.Cammands.BattleCommands;

import Menus.Cammands.Command;
import Menus.MenuManager;
import Model.Card_package.Card;

import java.util.ArrayList;

public class ComboAttack extends Command {
    public ComboAttack(){
        super("(attack|Attack) combo (\\w+) (\\w+){2,}");
    }

    public void execute(){
        System.out.println("NOT HANDLED !! ");
//        System.out.println("in combo");
//        ArrayList<Card> attackers = new ArrayList<>();
//        for(int i = 3; true; i++){
//            try{
//                attackers.add(MenuManager.getCurrentMatch().getOwnPlayer().getCard(matcher.group(i)));
//            }catch (IndexOutOfBoundsException e){
//                break;
//            }
//        }
//        Card target = MenuManager.getCurrentMatch().getOpponent().getCard(matcher.group(2));
        //todo
//          dar combo attact arraylist ra pass midahim

//        for(Card card:attackers)
//            card.attack(target);
//                  TODO
    }
}
