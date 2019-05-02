package Menus;

import Account_package.Account;
import Model.Shop;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {
    private static Menu currentMenu = new Menu(Menus.ACCOUNT, "login");
//    private List<OnMenuItemClickListener> clickListeners = new ArrayList<>();
//    private List<OnMenuChangeListener> menuChangeListeners = new ArrayList<>();

    public MenuManager() {
        setMenuRelations();
    }

    private void setMenuRelations() {
        Menu main = new Menu(Menus.MAIN, "main menu");
        Menu shop = new Menu(Menus.SHOP, "Shop");
        Menu collection = new Menu(Menus.COLLECTION, "Collection");
        Menu modeChoose = new Menu(Menus.GAME_MODE_CHOOSE, "Choose Game Mode");
        Menu singleMode = new Menu(Menus.SINGLE_PLAYER, "single Player");
        Menu typeChoose = new Menu(Menus.BATTLE_TYPE_CHOOSE, "choose battle type");
        Menu typeChoose2 = new Menu(Menus.BATTLE_TYPE_CHOOSE, "choose battle type");
        Menu battle = new Menu(Menus.BATTLE, "Battle");
        Menu battle2 = new Menu(Menus.BATTLE, "Battle");
        Menu endGame = new Menu(Menus.GAME_END, "game ended");
        Menu graveYard = new Menu(Menus.GRAVE_YARD, "graveYard");
        Menu graveYard2 = new Menu(Menus.GRAVE_YARD, "graveYard");

        currentMenu.addSubItem(main);
        main.addSubItem(shop).addSubItem(collection).addSubItem(endGame).addSubItem(modeChoose);
        modeChoose.addSubItem(singleMode).addSubItem(typeChoose);
        singleMode.addSubItem(typeChoose2); // todo 2 type chooses
        typeChoose.addSubItem(battle);
        typeChoose2.addSubItem(battle2);
        battle.addSubItem(graveYard);
        battle2.addSubItem(graveYard2);
    }

    public static void setCurrentMenu(Menu currentMenu) {
        MenuManager.currentMenu = currentMenu;
    }

//    public Menu getCurrentMenu() {
//        return currentMenu;
//    }
//
//    public void addOnClickListener(OnMenuItemClickListener listener) {
//        clickListeners.add(listener);
//    }
//
//    private void callOnClickListeners(int menuId) {
//        clickListeners.forEach(listener -> listener.onMenuItemClicked(menuId));
//    }
//
//    public void addOnMenuChangeListener(OnMenuChangeListener listener) {
//        menuChangeListeners.add(listener);
//    }
//
//    private void callOnMenuChangeListeners() {
//        menuChangeListeners.forEach(listener -> listener.onMenuChanged(currentMenu)); // todo : I don't understand it
//    }
//
//    public void performClickOnItem(int index) { //todo
//        if (index >= currentMenu.getSubItems().size())
//            return;
//
//        Menu clickedItem = currentMenu.getSubItems().get(index);
//        if (clickedItem instanceof ParentMenu)
//            setCurrentMenu((ParentMenu) clickedItem);
//        else
//            callOnClickListeners(clickedItem.getId());
//    }

    public static void goTo(Menus type) {
        for (Menu menu : currentMenu.getSubItems())
            if (menu.equals(new Menu(type, ""))) {
                currentMenu = menu;
                return;
            }
    }// can throw exception

    public static void back() {
        if (currentMenu.getParentMenu() != null)
            setCurrentMenu(currentMenu.getParentMenu());
    }
}
