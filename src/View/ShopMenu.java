package View;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ShopMenu extends StackPane {
    private static ShopMenu instance = new ShopMenu();
    private Scene scene;

    private ShopMenu() {
        scene  = new Scene(this, View.WINDOW_WIDTH, View.WINDOW_HEIGHT);

        initBackground();


    }

    private void initBackground(){
        ImageView shopBackground = new ImageView(new Image("resource\\shop-background.jpg"));
        shopBackground.setFitWidth(scene.getWidth());
        shopBackground.setFitHeight(scene.getHeight());
        this.getChildren().add(shopBackground);
    }

    public static ShopMenu getInstance() {
        return instance;
    }

    public Scene getMenuScene() {
        return scene;
    }
}

class shopCategory extends VBox{

}


