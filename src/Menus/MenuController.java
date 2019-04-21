
package Menus;
import java.util.Scanner;
import Menus.Menu;
import Menus.MenuManager;
import Menus.OnMenuItemClickListener;
import Menus.ParentMenu;


public class MenuController {
    private MenuManager menuManager;

    public void start() {
        initMenus();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.matches("\\d+")) {
                int index = Integer.parseInt(input) - 1;
                menuManager.performClickOnItem(index);
            } else if (input.equalsIgnoreCase("back"))
                menuManager.back();
        }
    }

    private void initMenus() {
        //todo : creating different menus
        menuManager = new MenuManager();
        menuManager.addOnMenuChangeListener(this::showMenu);    //Add listeners - (Method reference)
        menuManager.addOnClickListener(new OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int menuId) {
                onItemClicked(menuId);
            }
        });
        //todo : menuManager.setCurrentMenu();
    }

    private void onItemClicked(int id) {
        //todo :
    }

    private void showMenu(ParentMenu menu) {
        //todo : showMenu
    }
}
