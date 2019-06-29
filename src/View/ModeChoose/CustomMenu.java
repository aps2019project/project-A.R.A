package View.ModeChoose;

import View.JavafxTest;
import View.MainMenu.MainMenu;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CustomMenu extends BorderPane {
    private Scene scene;

    CustomMenu() {
        scene = new Scene(this, JavafxTest.stage.getWidth(), JavafxTest.stage.getHeight());
        scene.getStylesheets().add("View/Battle/css.css");
        this.setId("mode-menu");

        HBox listBox = new HBox(70);
        ModeItem item = new ModeItem("KILL HERO", "you should kill enemy's hero to win");
        ModeItem item1 = new ModeItem("COLLECT FLAG", "you have to collect at least half flags in map to win");
        ModeItem item2 = new ModeItem("HOLD FLAG", "you have to hold a flag for 6 turns to win");
        listBox.getChildren().addAll(item, item1, item2);
        listBox.setPadding(new Insets(0,0,0,200));
        this.setCenter(listBox);
        initButton();
    }

    private void initButton() {
        StackPane stackPane = new StackPane();
        stackPane.setEffect(new DropShadow());

        Image image = new Image("View/resource/LoginMenu/button.png");
        ImageView bg = new ImageView(image);
        stackPane.setOnMousePressed(e -> stackPane.setEffect(new Glow(0.2+0.1)));

        Label label = new Label("Back");
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("Berlin Sans FB Demi", 13+2));
        label.setEffect(new DropShadow(20, Color.BLACK));

        stackPane.getChildren().addAll(bg, label);
        stackPane.setOnMousePressed(e->JavafxTest.changeMenu(new ModeChooseMenu().getMenuScene()));
        this.setBottom(stackPane);
    }



    public Scene getMenuScene() {
        return scene;
    }

}
