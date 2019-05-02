package Account_package;

import Exceptions.NotValidUsernameOrPassWordException;
import Model.Collection;

import java.util.ArrayList;

public class Account {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static Account currentAccount;
    private String name;
    private String password;
    private int drake;
    private ArrayList<MatchResult> matchHistory;
    private Collection collection = new Collection();


    public Account(String name, String password) {
        this.name = name;
        this.password = password;
        drake = 15000;
        matchHistory = new ArrayList<>();
    }

    public static void addAccount(Account account) {
        accounts.add(account);
    }

    public static void deleteAccount(Account account) {
        accounts.remove(account);
    }

    public static ArrayList getAccounts() {
        return accounts;
    }

    public static boolean hasAccount(String userName) {
        for (Account account : accounts)
            if (account.getName().equals(userName))
                return true;
        return false;
    }

    public static Account getAccount(String username) {
        if (hasAccount(username))
            for (Account account : accounts)
                if (account.getName().equals(username))
                    return account;
        return null;
    }

    public static boolean inAccount(){
        return (currentAccount !=null);
    }

    public static void logout(){
         currentAccount = null;
    }

    public static void loginTo(String userName, String password) {
        for (Account account : accounts) {
            if (account.getName().equals(userName) && account.getPassword().equals(password)) {
                currentAccount = account;
                return;
            }
        }
        throw new NotValidUsernameOrPassWordException();
    }

    public static void loginTo(Account account) {
        if (accounts.contains(account))
            currentAccount = account;
        // todo
    }

    @Override
    public boolean equals(Object o) {
        return ((Account) o).getName().equals(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDrake() {
        return drake;
    }

    public void setDrake(int drake) {
        this.drake = drake;
    }

    public ArrayList<MatchResult> getMatchHistory() {
        return matchHistory;
    }

    public void setMatchHistory(ArrayList<MatchResult> matchHistory) {
        this.matchHistory = matchHistory;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public void addToMatchHistory(MatchResult matchResult) {
        this.matchHistory.add(matchResult);
    }

    public void pay(int cost) {
        this.setDrake(this.drake - cost);
    }

    public void earn(int cost) {
        this.setDrake(this.drake + cost);
    }
}

