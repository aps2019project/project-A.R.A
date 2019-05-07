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
        Shop.getInstance().sell(matcher.group(1));
    }
}
