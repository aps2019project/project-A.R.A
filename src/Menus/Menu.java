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
        MAIN_MENU(0), ACCOUNT(1), BATTLE_TYPE_CHOOSE(2), GAME_MODE_CHOOSE(3), COLLECTION(4), SHOP(5), SNIGLE_PLAYER(6), MULTIPLAYER(7);
        // every menu must be added //todo

        MenuIDs(int id) {
            this.id = id;
        }
        int id;
    }
}
