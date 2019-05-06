import Exceptions.CustomException;
import Exceptions.WrongCommandException;
import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;
import View.View;

import static Menus.GameMode.SINGLE_PLAYER;

public class Main {
    public static void main(String[] args) {
        while (true) {
            boolean matchACommand = false;
            System.out.println(MenuManager.getCurrentMenu().getTitle()); // todo as debug
            try {
                String commandLine;
                if (MenuManager.getCurrentMenuType().equals(Menus.BATTLE)) {
//                if (MenuManager.getGameMode().equals(SINGLE_PLAYER) && MenuManager.getCurrentMatch().getOwnPlayer() == null)
//                    commandLine = AI.getCommand();
//                else
                    commandLine = View.getInstance().getCommand();
                } else
                    commandLine = View.getInstance().getCommand();
                for (Command command : MenuManager.getCurrentMenu().getMenuCommands()) {
                    command.setMatcher(command.getPattern().matcher(commandLine));
                    if (command.getMatcher().matches()) {
                        command.execute();
                        matchACommand = true;
                    }
                    if(!matchACommand)
                        throw new WrongCommandException();
                }
            } catch (CustomException e) {
                e.printStackTrace();
            }
        }
    }
}
