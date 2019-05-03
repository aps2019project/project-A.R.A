package View;

import Account_package.Account;
import Menus.Menu;
import Menus.MenuManager;
import Model.Match_package.Match;
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
        for(Object object:menu.getType().getSubItems())
            System.out.println(counter++ + ". " + ((String) object));
    }

    public void showCurrentMenuTitle(){
        System.out.println(MenuManager.getCurrentMenu().getTitle().toUpperCase());
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

    public void showMainMenuCommands(){
        System.out.println("Enter [one of list items]");
    }

    public void showModeChooseCommands(){
        System.out.println("please choose one of the modes to play");
    }

    public void showSingleModeCommands(){
        System.out.println("choose between playing a custom game or following a story contains 3 different battles");
    }

    public void showStoryLevels(){
        int counter = 1;
        for(Object match: MenuManager.getMatches()) {
            System.out.println("level " + counter++ + ((Match) match).getMatchType().getTitle());
            System.out.println("----> " + ((Match) match).getMatchType().getHint());
        }
    }

}
