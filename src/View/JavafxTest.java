package View;

import Model.Shop;
import View.Login.LoginMenu;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class JavafxTest extends Application {
    public static Stage stage;

    @Override
    public void start(Stage stage) {
        JavafxTest.stage = stage;
        Shop.getInstance().initCards();
        stage.setScene(new LoginMenu().getMenuScene());

        stage.setMaximized(true);
        stage.setResizable(false);
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        stage.show();
    }

    public static void changeMenu(Scene scene) {
        Platform.runLater(()->{
            stage.setScene(scene);
            stage.setFullScreen(true);
        });
    }
}

