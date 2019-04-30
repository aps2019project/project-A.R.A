package Menus;

import Menus.Cammands.Account_Commands.*;
import Menus.Cammands.Account_Commands.Help;
import Menus.Cammands.Account_Commands.Save;
import Menus.Cammands.Battle_Commands.*;
import Menus.Cammands.Collection_Commands.*;
import Menus.Cammands.Command;
import Menus.Cammands.EndGame_Commands.EndGame;
import Menus.Cammands.EndGame_Commands.ShowMenu;
import Menus.Cammands.GraveYard_Commands.ShowAllCards;
import Menus.Cammands.GraveYard_Commands.ShowCardInfo;
import Menus.Cammands.MainMenu_Commands.*;
import Menus.Cammands.MainMenu_Commands.Exit;
import Menus.Cammands.ModeChoose_Commands.MultiMode;
import Menus.Cammands.ModeChoose_Commands.SingleMode;
import Menus.Cammands.Shop_Commands.*;
import Menus.Cammands.Shop_Commands.SearchUnit;
import Menus.Cammands.SingleMode_Commands.Custom;
import Menus.Cammands.SingleMode_Commands.Story;
import Menus.Cammands.TypeChoose_Commands.CollectFlag;
import Menus.Cammands.TypeChoose_Commands.HoldFlag;
import Menus.Cammands.TypeChoose_Commands.KillHero;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    Menus menuType;
    private String title;
    private Menu parentMenu;
    private final ArrayList<Command> MenuCommands = new ArrayList<>();
    private List<Menu> subItems = new ArrayList<>();

    public Menu(Menus menuType, String title) {
        this.menuType = menuType;
        this.title = title;
        initCommands();
    }

    public Menu addSubItem(Menu menu) {
        subItems.add(menu);
        menu.setParentMenu(this);
        return this;
    }

    public List<Menu> getSubItems() {
        return subItems;
    }

    public Menu addSubItem(Menus type, String title) {
        return addSubItem((new Menu(type, title)));
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

    public Menu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Menu parentMenu) {
        this.parentMenu = parentMenu;
    }

    // ---------------------------------------------------------------------------------------

    private void initCommands() {
        switch (menuType) {
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
            case SINGLE_PLAYER:
                initSinglePlayerCommands();
                break;
            case GAME_MODE_CHOOSE:
                initModeChooseCommands();
                break;
            case BATTLE_TYPE_CHOOSE:
                initTypeChooseCommands();
                break;
            case GAME_END:
                initEndGameCommands();
                break;
            case GRAVE_YARD:
                initGraveYardCommand();
                break;
            case BATTLE:
                initBattleCommands();
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

    private void initShopCommands() {
        MenuCommands.add(new Buy());
        MenuCommands.add(new Sell());
        MenuCommands.add(new SearchUnit());
        MenuCommands.add(new SearchCollection());
        MenuCommands.add(new Menus.Cammands.Shop_Commands.Exit());
        MenuCommands.add(new Show());
        MenuCommands.add(new Menus.Cammands.Shop_Commands.Help());
        MenuCommands.add(new ShowCollection());
    }

    private void initAccountCommands() {
        MenuCommands.add(new CreateAccount());
        MenuCommands.add(new Menus.Cammands.Account_Commands.Help());
        MenuCommands.add(new Login());
        MenuCommands.add(new Logout());
        MenuCommands.add(new Save());
        MenuCommands.add(new ShowLeaderBoard());
    }

    private void initCollectionCommands() {
        MenuCommands.add(new AddToDeck());
        MenuCommands.add(new CheckValidity());
        MenuCommands.add(new CreateDeck());
        MenuCommands.add(new DeleteDeck());
        MenuCommands.add(new Menus.Cammands.Collection_Commands.Exit());
        MenuCommands.add(new Menus.Cammands.Collection_Commands.Help());
        MenuCommands.add(new RemoveFromDeck());
        MenuCommands.add(new Save());
        MenuCommands.add(new Menus.Cammands.Collection_Commands.SearchUnit());
        MenuCommands.add(new SelectDeck());
        MenuCommands.add(new ShowAllDecks());
        MenuCommands.add(new ShowCards());
        MenuCommands.add(new ShowDeck());

    }

    private void initEndGameCommands() {
        MenuCommands.add(new Menus.Cammands.EndGame_Commands.Exit());
        MenuCommands.add(new EndGame());
        MenuCommands.add(new ShowMenu());
    }

    private void initGraveYardCommand() {
        MenuCommands.add(new ShowAllCards());
        MenuCommands.add(new Help());
        MenuCommands.add(new ShowCardInfo());
    }

    private void initBattleCommands() {
        MenuCommands.add(new Attack());
        MenuCommands.add(new ComboAttack());
        MenuCommands.add(new EndTurn());
        MenuCommands.add(new EnterGraveYard());
        MenuCommands.add(new GameInfo());
        MenuCommands.add(new Menus.Cammands.Battle_Commands.Help());
        MenuCommands.add(new Insert());
        MenuCommands.add(new MoveCard());
        MenuCommands.add(new SelectCard());
        MenuCommands.add(new SelectCollectable());
        MenuCommands.add(new Menus.Cammands.Battle_Commands.ShowCardInfo());
        MenuCommands.add(new ShowHand());
        MenuCommands.add(new ShowInfo());
        MenuCommands.add(new ShowMyMinions());
        MenuCommands.add(new ShowOpponenntMinions());
        MenuCommands.add(new UseSP());
    }

    private void initSinglePlayerCommands() {
        MenuCommands.add(new Custom());
        MenuCommands.add(new Menus.Cammands.SingleMode_Commands.Help());
        MenuCommands.add(new Story());
    }

    private void initTypeChooseCommands() {
        MenuCommands.add(new CollectFlag());
        MenuCommands.add(new HoldFlag());
        MenuCommands.add(new KillHero());
        MenuCommands.add(new Menus.Cammands.TypeChoose_Commands.Help());
    }

    private void initModeChooseCommands() {
        MenuCommands.add(new SingleMode());
        MenuCommands.add(new MultiMode());
        MenuCommands.add(new Menus.Cammands.ModeChoose_Commands.Help());
    }

}
