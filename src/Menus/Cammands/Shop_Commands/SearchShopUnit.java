package Menus.Cammands.Shop_Commands;

import Exceptions.UnitNotFoundException;
import Menus.Cammands.Command;
import Model.Shop;

public class SearchShopUnit extends Command{
    public SearchShopUnit(){
        super("search (\\w+)");
    }

    public void execute(){
        if(!Shop.getInstance().hasUnit(matcher.group(1)))
            throw new UnitNotFoundException();// checks unit validity

        view.show(Shop.getInstance().getUnitID(matcher.group(1)));
    }
}
