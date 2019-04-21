package Menus;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {
    private ParentMenu currentMenu;
    private List<OnMenuItemClickListener> clickListeners = new ArrayList<>();
    private List<OnMenuChangeListener> menuChangeListeners = new ArrayList<>();


    public void setCurrentMenu(ParentMenu currentMenu) {
        this.currentMenu = currentMenu;
    }

    public ParentMenu getCurrentMenu() {
        return currentMenu;
    }

    public void addOnClickListener(OnMenuItemClickListener listener) {
        clickListeners.add(listener);
    }

    private void callOnClickListeners(int menuId) {
        clickListeners.forEach(listener -> listener.onMenuItemClicked(menuId));
    }

    public void addOnMenuChangeListener(OnMenuChangeListener listener) {
        menuChangeListeners.add(listener);
    }

    private void callOnMenuChangeListeners() {
        menuChangeListeners.forEach(listener -> listener.onMenuChanged(currentMenu)); // todo : I don't understand it
    }

    public void performClickOnItem(int index) { //todo
        if (index >= currentMenu.getSubItems().size())
            return;

        Menu clickedItem = currentMenu.getSubItems().get(index);
        if (clickedItem instanceof ParentMenu)
            setCurrentMenu((ParentMenu) clickedItem);
        else
            callOnClickListeners(clickedItem.getId());
    }


    public void back() {
        if (this.currentMenu.getParentMenu() != null)
            setCurrentMenu(this.currentMenu.getParentMenu());
    }
}
