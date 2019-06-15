package sample;

import View.Battle.BattleMenu;
import View.Battle.GraveYardView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Arrays;


public class Main extends Application {
    public static Stage stage;
    public static BattleMenu battleMenu;

    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Main.stage = stage;

        UnitPhaseTwoTest unit = new UnitPhaseTwoTest("DiveSiah", 5, "hp : 25 and ap : 2");
        UnitPhaseTwoTest unit2 = new UnitPhaseTwoTest("dive sefid", 3, "Some desciption for card useful in battle");
        UnitPhaseTwoTest unit3 = new UnitPhaseTwoTest("Simorgh", 2, "for sure is a general");
        ArrayList<UnitPhaseTwoTest> units = new ArrayList<>(Arrays.asList(unit, unit2, unit3, unit2, unit, unit3));

//        Scene scene = new Scene(new PlayerStatusView("Player 1", 25, 2, false));
        Scene scene = new Scene(new GraveYardView(units));
        scene.getStylesheets().add("View/Battle/css.css");
//        stage.setScene(new BattleMenu().getMenuScene());
//        stage.setScene(new Scene(new GameCard("dive sefid", "Some desciption for card useful in battle")));

        battleMenu = new BattleMenu();
        stage.setScene(battleMenu.getMenuScene());

//        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setResizable(false);
        stage.setFullScreen(true);
//        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();
    }
}
