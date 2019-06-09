package View;

import Account_package.Account;
import Menus.Menu;
import Menus.MenuManager;
import Menus.Menus;
import Model.Match_package.Match;
import Model.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class View {

    private static View Instance = new View();
    private Scanner scanner = new Scanner(System.in);
    static final int WINDOW_WIDTH =1300;
    static final int WINDOW_HEIGHT =700;


    public static View getInstance(){
        return Instance;
    }

    public void show(String string){
        System.out.println(string);
    }

    public String getPassWord(){
        System.out.println("please enter your password:");
        return scanner.nextLine();
    }

    public void showCurrentMenuList(){
        Menu menu = MenuManager.getCurrentMenu();
        int counter = 0;
        for(Object object:menu.getType().getSubItems())
            System.out.println(counter++ + ". " + ((String) object));
    }

    public void showCommands(Menus type){
        System.out.println("menu commands :");
        for(String s:type.getCommands())
            System.out.println("_ " + s);
    }

    public void showLeaderBoard(){
        Account.sortAccounts();
        int counter = 1;
        for(Object account:Account.getAccounts())
            System.out.println(counter++ + "-UserName: "+ ((Account) account).getName() + "-Wins : " + ((Account) account).getNumOfWins());

    }

    public void showSingleModeCommands(){
        System.out.println(" // choose between playing a custom game or following a story \n contains 3 different battles // ");
    }

    public void showStoryLevels(){
        int counter = 1;
        for(Object match: MenuManager.getMatches()) {
            System.out.println("level " + counter++ + ((Match) match).getMatchType().getTitle());
            System.out.println("----> " + ((Match) match).getMatchType().getHint());
        }
    }

    public String getCommand(){
        return scanner.nextLine();
    }

    public boolean getConfirm(){
        System.out.println("Are you sure you want to abandon this battle ?");
        System.out.println("-Yes    -No");
        return getCommand().equals("Yes");
    }

    public void showIds(ArrayList<Unit> units){
        for(Unit unit:units)
            System.out.println(unit.getID());
    }

    public void showPlayers(ArrayList players){
        System.out.println("Players :");
        for (Object account : players)
            System.out.println("- " + ((Account) account).getName());
    }

}
