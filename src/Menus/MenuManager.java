package Menus;

import Model.Shop;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {
    private Menu currentMenu = new Menu(Menus.MAIN, "Main Menu");
//    private List<OnMenuItemClickListener> clickListeners = new ArrayList<>();
//    private List<OnMenuChangeListener> menuChangeListeners = new ArrayList<>();

    public MenuManager(){
        setMenuRelations();
    }

    private void setMenuRelations(){
        Menu shop = new Menu(Menus.SHOP, "Shop");
        Menu collection = new Menu(Menus.COLLECTION, "Collection");
        Menu modeChoose = new Menu(Menus.GAME_MODE_CHOOSE, "Choose Game Mode");
        Menu singleMode = new Menu(Menus.SINGLE_PLAYER, "single Player");
        Menu typeChoose = new Menu(Menus.BATTLE_TYPE_CHOOSE, "choose battle type");
        Menu battle = new Menu(Menus.BATTLE, "Battle");
        Menu endGame = new Menu(Menus.GAME_END, "game ended");
        Menu account = new Menu(Menus.ACCOUNT, "login");
        Menu graveYard = new Menu(Menus.GRAVE_YARD, "graveYard");

        currentMenu.addSubItem(shop).addSubItem(collection).addSubItem(endGame).addSubItem(modeChoose);
        modeChoose.addSubItem(singleMode).addSubItem(typeChoose);
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
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

    public void back() {
        if (this.currentMenu.getParentMenu() != null)
            setCurrentMenu(this.currentMenu.getParentMenu());
    }
}
