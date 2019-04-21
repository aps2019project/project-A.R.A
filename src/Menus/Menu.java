package Menus;

public class Menu {
    private int id;
    private String title;
    private ParentMenu parentMenu;

    public Menu(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public enum MenuIDs{
        MAIN_MENU(1);//TODO
        // every menu must be added //todo

        MenuIDs(int id) {
            this.id = id;
        }
        int id;
    }
}
