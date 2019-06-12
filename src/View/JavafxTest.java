package View;

import Account_package.Accounts;
import Controller.Controller;
import Model.Shop;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class JavafxTest extends Application {
    static Stage stage;

    @Override
    public void start(Stage stage) {
        JavafxTest.stage = stage;
        Shop.getInstance().initCards();
//        scene = new Scene(new LoginMenu());
//        ArrayList<Unit> units = new ArrayList<>();
//        for(int i = 0; i<13; i++){
//            units.add(new Hero("hi", 4, 4,4,"desc", null, AttackType.MELEE, 4, new ArrayList<HeroSpecialPower>()));
//        }
        Controller.getInstance().register("re", "123");
        stage.setScene(MainMenu.getInstance().getMenuScene());

        stage.setMaximized(true);
        stage.setResizable(false);
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        stage.show();
    }

    static void changeMenu(Scene scene) {
        Platform.runLater(()->{
            stage.setScene(scene);
            stage.setFullScreen(true);
        });
    }
}

