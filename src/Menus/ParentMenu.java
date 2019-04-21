package Menus;

import java.util.ArrayList;
import java.util.List;

public class ParentMenu extends Menu {
    private List<Menu> subItems = new ArrayList<>();

    public ParentMenu(int id, String title) {
        super(id, title);
    }

    public void addSubItem(Menu menu) {
        subItems.add(menu);
        menu.setParentMenu(this);
    }

    public List<Menu> getSubItems() {
        return subItems;
    }

    public void addSubItem(int id, String title) {
        addSubItem((new Menu(id, title)));
    }

}
