package Menus.Cammands.CollectionCommands;

import Account_package.Account;
import Exceptions.UnitNotFoundException;
import Menus.Cammands.Command;
import Model.Collection;

public class SearchUnit extends Command {

    public SearchUnit(){
        super("search (\\w+)");
    } // get name

    public void execute(){
        Collection collection = Account.getCurrentAccount().getCollection();
        if(!collection.hasUnit(matcher.group(1)))
            throw new UnitNotFoundException();

    }
}
