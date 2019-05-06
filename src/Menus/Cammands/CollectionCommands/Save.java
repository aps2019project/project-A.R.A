package Menus.Cammands.CollectionCommands;

import Account_package.Account;
import Menus.Cammands.Command;
import Menus.Buffer;

public class Save extends Command {
    public Save(){
        super("(save|Save)");
    }

    public void execute(){
        Account.getCurrentAccount().setCollection(Buffer.getBufferCollection());
    }
}
