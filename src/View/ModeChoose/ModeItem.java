package View.ModeChoose;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ModeItem extends StackPane {

    public ModeItem(String name, String desc) {
        this.setEffect(new DropShadow());
        Image bgImage;
        switch (name) {
            case "Story":
                bgImage = new Image("View/resource/ModeChoose/play_mode_arenagauntlet.jpg");
                break;
            case "Custom":
                bgImage = new Image("View/resource/ModeChoose/play_mode_bossbattle.jpg");
                break;
            default:
                bgImage = new Image("View/resource/ModeChoose/play_mode_rankedladder.jpg");
        }

        ImageView bgImageView = new ImageView(bgImage);
        bgImageView.setEffect(new MotionBlur(20, 3));
        this.getChildren().add(bgImageView);

        Label title = new Label(name);
        title.setFont(Font.font(40));
        title.setTextFill(Color.GOLD);
//        glow.setInput(new MotionBlur(30, 2));
        title.setEffect(new DropShadow());
        title.setTranslateY(80);
        this.getChildren().add(title);

        Label descLabel = new Label(desc.toUpperCase());
        descLabel.setAlignment(Pos.CENTER);
        descLabel.setWrapText(true);
        descLabel.setMaxWidth(180);
        descLabel.setFont(Font.font(15));
        descLabel.setTextFill(Color.WHITE);
        descLabel.setEffect(new DropShadow());
        descLabel.setTranslateY(150);
        this.getChildren().add(descLabel);
    }
}
