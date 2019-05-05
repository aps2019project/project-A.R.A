package Menus.Cammands.Shop_Commands;

import Account_package.Account;
import Exceptions.UnitNotFoundException;
import Menus.Cammands.Command;
import Model.Collection;
import Model.Shop;

public class Sell extends Command{
    public Sell(){
        super("sell (\\w+)");
    } // ID entered

    public void execute(){
        Collection collection = Account.getCurrentAccount().getCollection();
        String ID = matcher.group(1);
        if(!collection.hasUnit(ID))
            throw new UnitNotFoundException(); // checks unit validity

        Shop.getInstance().sell(Account.getCurrentAccount(), ID);
    }
}
