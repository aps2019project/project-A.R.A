package Menus.Cammands.GraveYardCommands;

import Menus.Cammands.Command;
import Menus.MenuManager;
public class ShowAllCards extends Command {
        public ShowAllCards(){
            super("show cards");
        }

        public void execute(){
            view.show(MenuManager.getCurrentMatch().getOwnPlayer().getGraveYard().toString());
        }
}
