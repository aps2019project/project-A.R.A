package Menus.Cammands.MainMenu_Commands;

import Account_package.Account;
import Menus.Cammands.Command;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class Save extends Command {

    public Save(){
        super("save( account)?");
    }

    public void execute(){
        //todo
        try {
            OutputStream outputStream = new FileOutputStream(Account.getCurrentAccount().getName()+".txt");
            outputStream.write((Account.getCurrentAccount().getName()+'\n'
            +Account.getCurrentAccount().getPassword()).getBytes()); // todo also use json
        }catch (Exception e){
            //do nothing dont know so much about this kind of exception
        }
    }
}
