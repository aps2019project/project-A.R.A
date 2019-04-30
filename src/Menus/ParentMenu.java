package Menus;

import java.util.ArrayList;
import java.util.List;

public class ParentMenu extends Menu {
    private List<Menu> subItems = new ArrayList<>();

    public ParentMenu(Menus type, String title) {
        super(type, title);
    }

    public void addSubItem(Menu menu) {
        subItems.add(menu);
        menu.setParentMenu(this);
    }

    public List<Menu> getSubItems() {
        return subItems;
    }

    public void addSubItem(Menus type, String title) {
        addSubItem((new Menu(type, title)));
    }

    public void addSubItme(Menu menu){
        subItems.add(menu);
    }
}
