package View.Sprite;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SpriteTest extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Pane root = new Pane();
        root.getChildren().add(SpriteBase.getInstance().get(SpriteType.HERO, "Simorgh"));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
