import Exceptions.CustomException;
import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;
import View.View;

import static Menus.GameMode.SINGLE_PLAYER;

public class Main {
    public static void main(String[] args) {
        try {
            String commandLine;
            if (MenuManager.getCurrentMenuType().equals(Menus.BATTLE)) {
//                if (MenuManager.getGameMode().equals(SINGLE_PLAYER))
//                    commandLine = AI.getCommand();
//                else
                    commandLine = View.getInstance().getCommand();
            } else
                commandLine = View.getInstance().getCommand();
            for(Command command:MenuManager.getCurrentMenu().getMenuCommands()){
                command.setMatcher(command.getPattern().matcher(commandLine));
                if(command.getMatcher().matches())
                    command.execute();
            }
        }catch (CustomException e){
            e.printStackTrace();
        }
    }
}
