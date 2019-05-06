import Exceptions.CustomException;
import Exceptions.WrongCommandException;
import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menu;
import Menus.Menus;
import View.View;

import static Menus.GameMode.SINGLE_PLAYER;

public class Main {
    public static void main(String[] args) {
        MenuManager.start();
        while (true) {
//            System.out.println("Menu : " + MenuManager.getCurrentMenu().getTitle());
//            System.out.println("-------------subItems------------------");
//            for(Menu menu:MenuManager.getCurrentMenu().getSubItems())
//                System.out.println(menu.getTitle());
//            System.out.println("-------------Commands------------------");
//            View.getInstance().showCommands(MenuManager.getCurrentMenu().getType());
//            System.out.println("---------------------------------------");
            boolean validCommand = false;
            try {
                String commandLine;
                if (MenuManager.getCurrentMenuType().equals(Menus.BATTLE)) {
//                if (MenuManager.getGameMode().equals(SINGLE_PLAYER) && MenuManager.getCurrentMatch().getOwnPlayer() == null)
//                    commandLine = AI.getCommand();
//                else
                    commandLine = View.getInstance().getCommand();
                } else
                    commandLine = View.getInstance().getCommand();
                commandLine = commandLine.trim();
                for (Command command : MenuManager.getCurrentMenu().getMenuCommands()) {
                    command.setMatcher(command.getPattern().matcher(commandLine));
                    if (command.getMatcher().matches()) {
                        command.execute();
                        validCommand = true;
                    }

                }
                if(!validCommand)
                    throw new WrongCommandException();
            } catch (CustomException e) {
                e.printStackTrace();
            }
        }
    }
}
