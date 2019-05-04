package Menus.Cammands.Shop_Commands;

import Account_package.Account;
import Exceptions.UnitNotFoundException;
import Menus.Cammands.Command;
import Model.Collection;

public class Sell extends Command{
    public Sell(){
        super("sell (\\w+)");
    }

    public void execute(){
        Collection collection = Account.getCurrentAccount().getCollection();
        if(!collection.hasUnit(matcher.group(1)))
            throw new UnitNotFoundException();

    }
}
