package Menus.Cammands.Collection_Commands;

import Account_package.Account;
import Exceptions.UnitNotFoundException;
import Menus.Cammands.Command;
import Model.Collection;

public class SearchUnit extends Command {

    public SearchUnit(){
        super("search (\\w+)");
    }

    public void execute(){
        Collection collection = Account.getCurrentAccount().getCollection();
        if(!collection.hasUnitOfType(matcher.group(1)))
            throw new UnitNotFoundException();
        view.showIds(collection.getUnitsOfType(matcher.group(1)));
    }
}
