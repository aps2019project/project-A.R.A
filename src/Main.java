import Exceptions.CustomException;
import Exceptions.WrongCommandException;
import Menus.Cammands.Command;
import Menus.MenuManager;
import Menus.Menus;
import Model.AI;
import View.View;

import static Menus.GameMode.SINGLE_PLAYER;

public class Main {
    public static void main(String[] args) {
        MenuManager.start();
        int aiMistakeCounter = 0;
        while (true) {
            boolean validCommand = false;
            try {
                String commandLine;
                if (MenuManager.getCurrentMenuType().equals(Menus.BATTLE)) {
                    if (MenuManager.getGameMode().equals(SINGLE_PLAYER) && MenuManager.getCurrentMatch().isAITurn()) {
                        if (aiMistakeCounter != 40)
                            commandLine = AI.getInstance().getCommand();
                        else {
                            commandLine = "end turn";
                            aiMistakeCounter = 0;
                        }
                    } else
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
                if (!validCommand)
                    throw new WrongCommandException();
            } catch (CustomException e) {
                if (!MenuManager.getCurrentMenu().getType().equals(Menus.BATTLE) ||!MenuManager.getCurrentMatch().isAITurn())
                    e.printStackTrace();
                else aiMistakeCounter++;
            }
        }
    }
}
