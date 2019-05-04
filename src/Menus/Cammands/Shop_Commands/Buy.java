package Menus.Cammands.Shop_Commands;

import Account_package.Account;
import Exceptions.NotEnoughDrakeException;
import Exceptions.UnitNotFoundException;
import Exceptions.fullItemException;
import Menus.Cammands.Command;
import Model.Item_package.Item;
import Model.Shop;
import Model.Unit;

public class Buy extends Command {
    public Buy(){
        super("buy (\\w+)");
    }

    public void execute(){
        if(!Shop.getInstance().hasUnit(matcher.group(1)))
            throw new UnitNotFoundException();
        Unit unit = Shop.getInstance().getBasedOnType(matcher.group(1));
        if(Account.getCurrentAccount().getDrake()<unit.getPrice())
            throw new NotEnoughDrakeException();
        if(unit instanceof Item)
            if(Account.getCurrentAccount().getCollection().getItems().size()==3)
                throw new fullItemException();
        Shop.getInstance().buy(Account.getCurrentAccount(),Shop.getInstance().getUnitID(matcher.group(1)));
    }
}