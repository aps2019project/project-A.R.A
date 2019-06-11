package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavafxTest extends Application {
    static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        JavafxTest.stage = stage;

        stage.setScene(new CollectionMenu().getMenuScene());

        stage.setMaximized(true);
        stage.setResizable(false);
        stage.setFullScreen(true);

        stage.show();
    }
}

