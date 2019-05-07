package Menus.Cammands.Shop_Commands;

import Menus.Cammands.Command;
import Model.Shop;

public class SearchShopUnit extends Command{
    public SearchShopUnit(){
        super("search (\\w+)");
    }

    public void execute(){
        view.show(Shop.getInstance().getUnitID(matcher.group(1)));
    }
}
