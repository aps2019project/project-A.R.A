package View;

import Model.Card_package.AttackType;
import Model.Card_package.Hero;
import Model.Card_package.hero_special_power.HeroSpecialPower;
import Model.Unit;
import View.Card.CardGroup;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class JavafxTest extends Application {
    static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        JavafxTest.stage = stage;

        ArrayList<Unit> units = new ArrayList<>();
        for(int i = 0; i<13; i++){
            units.add(new Hero("hi", 4, 4,4,"desc", null, AttackType.MELEE, 4, new ArrayList<HeroSpecialPower>()));
        }
        stage.setScene(new CollectionMenu().getMenuScene());

        stage.setMaximized(true);
        stage.setResizable(false);
        stage.setFullScreen(true);

        stage.show();
    }
}

