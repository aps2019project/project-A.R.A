package Menus.Cammands.Shop_Commands;

import Exceptions.UnitNotFoundException;
import Menus.Cammands.Command;
import Model.Shop;

public class SearchUnit extends Command{
    public SearchUnit(){
        super("search (\\w+)");
    }

    public void execute(){
        if(!Shop.getInstance().hasUnit(matcher.group(1)))
            throw new UnitNotFoundException();
        view.show(Shop.getInstance().getUnitID(matcher.group(1)));
    }
}
