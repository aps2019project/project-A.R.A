package Menus.Cammands.Shop_Commands;

import Menus.Cammands.Command;
import Model.Shop;

public class Show extends Command {
    public Show(){
        super("show");
    }

    public void execute(){
        view.show(Shop.getInstance().toString());
    }
}
