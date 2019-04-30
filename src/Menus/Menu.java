package Menus;

import Menus.Cammands.Command;
import Menus.Cammands.MainMenu_Commands.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu {
    Menus menuType;
    private String title;
    private ParentMenu parentMenu;
    private final ArrayList<Command> MenuCommands = new ArrayList<>();

    public Menu(Menus menuType, String title) {
        this.menuType = menuType;
        this.title = title;
        initCommands();
    }

    public void setType(Menus menuType) {
        this.menuType = menuType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ParentMenu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(ParentMenu parentMenu) {
        this.parentMenu = parentMenu;
    }

    private void initCommands(){
        switch (menuType){
            case MAIN:
                initMainCommands();
                break;
            case SHOP:
                initShopCommands();
                break;
            case ACCOUNT:
                initAccountCommands();
                break;
            case COLLECTION:
                initCollectionCommands();
                break;
            case MULTIPLAYER:
                initMultiplayerCommands();
                break;
            case SNIGLE_PLAYER:
                intiSinglePlayerCommands();
                break;
            case GAME_MODE_CHOOSE:
                initModeChooseCommnds();
                break;
            case BATTLE_TYPE_CHOOSE:
                intitypeChooseCommands();
                break;
        }
    }

    private void initMainCommands() {
        MenuCommands.add(new Battle());
        MenuCommands.add(new Collection());
        MenuCommands.add(new Shop());
        MenuCommands.add(new Exit());
        MenuCommands.add(new Help());
    }

}
