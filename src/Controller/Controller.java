package Controller;

import Account_package.Account;
import Account_package.Accounts;
import Exceptions.NotAValidAccountException;
import Exceptions.NotEnoughDrakeException;
import Exceptions.UnitNotFoundException;
import Model.Shop;

public class Controller {
    private static Controller instance = new Controller();

    public boolean sell(String unitName) {
        try {
            Shop.getInstance().sell(Account.getCurrentAccount(), unitName);
        } catch (UnitNotFoundException e) {
            return false;
        }
        return true;
    }

    public boolean buy(String unitName) {
        try {
            Shop.getInstance().buy(Accounts.getCurrentAccount(), unitName);
        } catch (NotEnoughDrakeException e) {
            return false;
        }
        return true; // todo ought to change on net programming.
    }

    public void login(String username, String password) {
        if (!Accounts.getInstance().login(username, password))
            throw new NotAValidAccountException();
    }

    public void register(String username, String password) {
        if (!Accounts.getInstance().createNewAccount(username, password))
            throw new NotAValidAccountException();
    }

    public static Controller getInstance() {
        return instance;
    }
}
