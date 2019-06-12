package Account_package;

import java.util.ArrayList;

public class Accounts {
    private static Accounts instance = new Accounts(); // just for now
    private ArrayList<Account> accounts = new ArrayList<>();
    private static Account currentAccount;

    // todo save to file and read from file on startup


    public static Accounts getInstance() {
        return instance;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public static Account getCurrentAccount() {
        return currentAccount;
    }

    public boolean login(String username, String password){
        for (Account account : accounts) {
            if(account.getName().equals(username) && account.getPassword().equals(password)){
                currentAccount = account;
                return true;
            }
        }
        return false;
    }

    public boolean createNewAccount(String username, String password){
        Account newAccount = new Account(username, password);
        for (Account account : accounts) {
            if(account.equals(newAccount))
                return false;
        }
        accounts.add(newAccount);
        currentAccount = newAccount;
        return true;
    }

    public void logout(){
        currentAccount = null;
    }
}
