package Menus.Cammands.Shop_Commands;

import Account_package.Account;
import Menus.Cammands.Command;

public class ShowCollection extends Command{
    public ShowCollection(){
        super("show collection");
    }

    public void execute(){
        view.show(Account.getCurrentAccount().getCollection().toStringInShop());
    }
}
