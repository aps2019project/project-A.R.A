package Menus.Cammands.CollectionCommands;

import Account_package.Account;
import Menus.Cammands.Command;

public class Save extends Command {
    public Save(){
        super("(save|Save)");
    }

    public void execute(){
        System.out.println("not handled");
        //Account.getCurrentAccount().setCollection(Buffer.getBufferCollection());
    }
}
