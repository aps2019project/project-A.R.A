package Menus;

import Menus.Cammands.AccountCommands.*;
import Menus.Cammands.Back;
import Menus.Cammands.CustomGameCommands.StartCustomGame;
import Menus.Cammands.Exit;
import Menus.Cammands.BattleCommands.*;
import Menus.Cammands.CollectionCommands.*;
import Menus.Cammands.Command;
import Menus.Cammands.EndGameCommands.EndGame;
import Menus.Cammands.GraveYardCommands.ShowAllCards;
import Menus.Cammands.GraveYardCommands.ShowDeadCardInfo;
import Menus.Cammands.MainMenu_Commands.*;
import Menus.Cammands.ModeChoose_Commands.MultiMode;
import Menus.Cammands.ModeChoose_Commands.SingleMode;
import Menus.Cammands.MultiPlayer_Commands.SelectUser;
import Menus.Cammands.MultiPlayer_Commands.StartMultiPlayerGame;
import Menus.Cammands.Shop_Commands.*;
import Menus.Cammands.Shop_Commands.SearchShopUnit;
import Menus.Cammands.ShowMenu;
import Menus.Cammands.SingleMode_Commands.Custom;
import Menus.Cammands.SingleMode_Commands.Story;
import Menus.Cammands.Story_Commands.Lvl1;
import Menus.Cammands.Story_Commands.Lvl2;
import Menus.Cammands.Story_Commands.Lvl3;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private Menus menuType;
    private String title;
    private ArrayList<Menu> parentMenus = new ArrayList<>();
    private final ArrayList<Command> MenuCommands = new ArrayList<>();
    private List<Menu> subItems = new ArrayList<>();

    public Menu(Menus menuType, String title) {
        this.menuType = menuType;
        this.title = title;
        initCommands();
    }

    public ArrayList<Command> getMenuCommands() {
        return MenuCommands;
    }

    public Menu addSubItem(Menu menu) {
        subItems.add(menu);
        menu.addParentMenu(this);
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

    public ArrayList getParentMenus() {
        return parentMenus;
    }

    public void addParentMenu(Menu parentMenu) {
       parentMenus.add(parentMenu);
    }

    @Override
    public boolean equals(Object object){
        return ((Menu) object).menuType.equals(this.menuType);
    }

    public Menus getType(){
        return menuType;
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
            case GAME_END:
                initEndGameCommands();
                break;
            case GRAVE_YARD:
                initGraveYardCommand();
                break;
            case BATTLE:
                initBattleCommands();
                break;
            case STORY:
                initStoryCommands();
                break;
            case CUSTOM_GAME:
                initCustomGameCommands();
                break;
            case MULTI_PLAYER:
                initMultiPlayerGameCommands();
                break;
        }
    }

    private void initMainCommands() {
        MenuCommands.add(new Battle());
        MenuCommands.add(new Collection());
        MenuCommands.add(new Shop());
        MenuCommands.add(new Exit());
        MenuCommands.add(new ShowMenu());
        MenuCommands.add(new Logout());
//        MenuCommands.add(new Save());
    }

    private void initShopCommands() {
        MenuCommands.add(new Buy());
        MenuCommands.add(new Sell());
        MenuCommands.add(new SearchShopUnit());
        MenuCommands.add(new SearchCollection());
        MenuCommands.add(new Exit());
        MenuCommands.add(new Show());
        MenuCommands.add(new ShowMenu());
        MenuCommands.add(new ShowCollection());
    }

    private void initAccountCommands() {
        MenuCommands.add(new CreateAccount());
        MenuCommands.add(new ShowMenu());
        MenuCommands.add(new Login());
        MenuCommands.add(new ShowLeaderBoard());
        MenuCommands.add(new Exit());
    }

    private void initCollectionCommands() {
        MenuCommands.add(new AddToDeck());
        MenuCommands.add(new CheckValidity());
        MenuCommands.add(new CreateDeck());
        MenuCommands.add(new DeleteDeck());
        MenuCommands.add(new Exit());
        MenuCommands.add(new ShowMenu());
        MenuCommands.add(new RemoveFromDeck());
        MenuCommands.add(new Save());
        MenuCommands.add(new SearchUnit());
        MenuCommands.add(new SelectDeck());
        MenuCommands.add(new ShowAllDecks());
        MenuCommands.add(new ShowCards());
        MenuCommands.add(new ShowDeck());
    }

    private void initEndGameCommands() {
        MenuCommands.add(new Exit());
        MenuCommands.add(new EndGame());
    }

    private void initGraveYardCommand() {
        MenuCommands.add(new ShowAllCards());
        MenuCommands.add(new ShowDeadCardInfo());
        MenuCommands.add(new ShowMenu());
    }

    private void initBattleCommands() {
        MenuCommands.add(new Attack());
        MenuCommands.add(new ComboAttack());
        MenuCommands.add(new EndTurn());
        MenuCommands.add(new EnterGraveYard());
        MenuCommands.add(new GameInfo());
        MenuCommands.add(new ShowMenu());
        MenuCommands.add(new Insert());
        MenuCommands.add(new MoveCard());
        MenuCommands.add(new SelectCard());
        MenuCommands.add(new SelectCollectable());
        MenuCommands.add(new ShowCardInfo());
        MenuCommands.add(new ShowHand());
        MenuCommands.add(new ShowCollectableInfo());
        MenuCommands.add(new ShowMyMinions());
        MenuCommands.add(new ShowOpponenntMinions());
        MenuCommands.add(new UseSP());
        MenuCommands.add(new ShowNextCard());
        MenuCommands.add(new UseItem());
        MenuCommands.add(new ShowCollectables());
        MenuCommands.add(new Leave());
    }

    private void initSinglePlayerCommands() {
        MenuCommands.add(new Custom());
        MenuCommands.add(new Story());
        MenuCommands.add(new Back());
        MenuCommands.add(new ShowMenu());
    }

    private void initModeChooseCommands() {
        MenuCommands.add(new SingleMode());
        MenuCommands.add(new Back());
        MenuCommands.add(new MultiMode());
    }

    private void initStoryCommands(){
        MenuCommands.add(new Lvl1());
        MenuCommands.add(new Lvl2());
        MenuCommands.add(new Lvl3());
        MenuCommands.add(new ShowMenu());
    }

    private void initCustomGameCommands(){
        MenuCommands.add(new StartCustomGame());
    }

    private void initMultiPlayerGameCommands(){
        MenuCommands.add(new SelectUser());
        MenuCommands.add(new StartMultiPlayerGame());
        MenuCommands.add(new Back());
        MenuCommands.add(new ShowMenu());
    }
}
