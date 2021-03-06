package Menus.Cammands.Shop_Commands;

import Account_package.Account;
import Exceptions.UnitNotFoundException;
import Menus.Cammands.Command;
import Model.Unit;

public class SearchCollection extends Command {

    public SearchCollection() {
        super("search collection (\\w+)");
    } //gets name

    public void execute() {
        if (!Account.getCurrentAccount().getCollection().hasUnit(matcher.group(1)))
            throw new UnitNotFoundException(); // checks if our collection has this unit

        for (Unit unit : Account.getCurrentAccount().getCollection().getUsAbles())
            if (unit.getName().equals(matcher.group(1)))
                view.show(unit.getID());// prints cards of this name

        for (Unit unit : Account.getCurrentAccount().getCollection().getCards())
            if (unit.getName().equals(matcher.group(1)))
                view.show(unit.getID()); // prints items of this name
    }
}
