package View;

import Account_package.Account;
import Menus.Menu;
import Menus.MenuManager;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class View {

    private static View Instance = new View();
    private Scanner scanner = new Scanner(System.in);

    public static View getInstance(){
        return Instance;
    }

    public String getPassWord(){
        System.out.println("please enter your password:");
        return scanner.next();
    }

    public void showCurrentMenuList(){
        Menu menu = MenuManager.getCurrentMenu();
        int counter = 0;
        for(Menu menu1:menu.getSubItems())
            System.out.println(counter++ + ". " + menu.getTitle());
    }

    public void showAccountCommands(){
        System.out.println("1-create account");
        System.out.println("2-login");
        System.out.println("3-show leaderBoard");
    }

    public void showLeaderBoard(){
        Collections.sort(Account.getAccounts(), Comparator.comparing(Account::getNumOfWins));
        int counter = 1;
        for(Object account:Account.getAccounts())
            System.out.println(counter++ + "-UserName: "+ ((Account) account).getName() + "-Wins : " + ((Account) account).getNumOfWins());

    }

}
