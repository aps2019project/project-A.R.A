import Account_package.Accounts;
import Exceptions.NotAValidAccountException;

public class Controller {
    private static Controller instance = new Controller();

    public void login(String username, String password){
        if(!Accounts.getInstance().login(username, password))
            throw new NotAValidAccountException();
    }

    public void register(String username, String password){
        if(!Accounts.getInstance().createNewAccount(username, password))
            throw new NotAValidAccountException();
    }
}
